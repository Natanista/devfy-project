import React, { useEffect, useState,  useParams} from "react";
import MenuLogado from "../components/MenuLogado";
import Footer from "../components/Footer";
import Card from "../components/Card";
import '../html/css/dashboardEmpresa.css';
import api from "../api";
import { Link } from "react-router-dom";



function Cards() {



    const [numero, setNumero] = useState("");
    const [saldo, setSaldo] = useState("");
    const [valorDebito, setValorDebito] = useState("");
    const [valorDeposito, setValorDeposito] = useState("");
    const [file, setFile] = useState(null);
    const [contagem, setContagem] = useState("")




    function submitForm() {
        const formData = new FormData();

        formData.append("txt", file);

        api.post("/projetos/import", formData)
        .then((res) => {
            console.log(res)
            location.reload();
        }).catch((err) => {
            console.log(err)
        });
    
    }


    useEffect(() => {
      async function getConta() {
          const resposta = await api
          .get("/conta-bancaria/1")
          .then((resposta) => {
              console.log("Achei esse id: ", resposta)
              setNumero(resposta.data.numero);
              setSaldo(resposta.data.saldo);
          })
          .catch((erro) => {
              console.log("Erro ao buscar projeto pelo id")
          })
      }
      getConta();
    }, [])

    useEffect(() => {
        async function getContagem() {
            const resposta = await api
            .get("/projetos/contagem")
            .then((resposta) => {
    
                setContagem(resposta.data);
            })
            .catch((erro) => {
                console.log("Erro")
            })
        }
        getContagem();
      }, [])

    function depositar(e){
        e.preventDefault();
        api.patch(`/conta-bancaria/depositar/1`,{
            valor: valorDeposito
        }).then((resposta) => {
            location.reload();
         // history.push("/dashboard-empresa")
        }).catch((erro) => {
          console.log("Erro ao cadastrar música!")
        });
    
    }

    function debitar(e){
        e.preventDefault();
        api.patch(`/conta-bancaria/debitar/1`,{
            valor: valorDebito
        }).then((resposta) => {
            location.reload();
         // history.push("/dashboard-empresa")
        }).catch((erro) => {
          console.log("Erro ao cadastrar música!")
        });
    
    }

    function debitarAgendado(e){
        e.preventDefault();
        api.post(`/conta-bancaria/debito-agendado/1`,{
            valor: valorDebito
        }).then((resposta) => {
            location.reload();
         // history.push("/dashboard-empresa")
        }).catch((erro) => {
          console.log("Erro ao cadastrar música!")
        });
    
    }

    function depositarAgendado(e){
        e.preventDefault();
        api.post(`/conta-bancaria/deposito-agendado/1`,{
            valor: valorDeposito
        }).then((resposta) => {
            location.reload();
         // history.push("/dashboard-empresa")
        }).catch((erro) => {
          console.log("Erro ao cadastrar música!")
        });
    
    }

    function executarOperacao(e){
        e.preventDefault();
        api.post(`/conta-bancaria/executar-operacao`,{
        }).then((resposta) => {
            location.reload();
         // history.push("/dashboard-empresa")
        }).catch((erro) => {
          console.log("Erro ao cadastrar música!")
        });
    
    }

    function desfazer(e) {
        e.preventDefault();
        api.post(`/conta-bancaria/desfazer-operacao`,{
        }).then((resposta) => {
            location.reload();
         // history.push("/dashboard-empresa")
        }).catch((erro) => {
          console.log("Erro ao cadastrar música!")
        });
    }

    const [cards, setCards] = useState([]); 

    useEffect(() => {
        async function buscarCards(){
          const resposta = await api.get(`/projetos`)
            setCards(resposta.data);
          console.log("olha o que veio da api!!!",resposta.data)
        }
        buscarCards()
      },[]);


    
      







        return (
            <div>
                <div>
                    <MenuLogado/>
                </div>

                <div className="div_fundo">
                    <div className="div_esquerda">
                        <div className="div_status_projeto">
                            <div className="conteudo_financeiro">
                                <h2>Financeiro dos projetos</h2>
                                <br/> <br />
                                <p>Projetos em aberto:     {contagem}</p>
                                <br />
                                <p>Conta:  {numero}</p>
                                <br />
                                <h3><b>Saldo:</b>    R${saldo}</h3> 
                                <br />
                               <p> <label class="saldo" htmlFor="saldoDeposito">Depósito: </label></p>
                               <br />
                                <input class="input_txt" onChange={e => setValorDeposito(e.target.value)} type="text" name="saldoDeposito" id="saldoDeposito" />
                                <br   />
                                <button class="btn_todos" id="btn_cor_azul" onClick={depositar}>Deposito imediato</button>
                                <button class="btn_todos" id="btn_cor_amarelo" onClick={depositarAgendado}>Agendar deposito</button>
                                <br />
                                <label >Saque:     </label>
                                <br /> <br />
                                <input class="input_text" onChange={e => setValorDebito(e.target.value)}  type="text" name="saldoSaque" id="saldoSaque" class="input_txt"/>
                               <br />
                                <button class="btn_todos" id="btn_cor_azul" onClick={debitar}>Saque imeadiato</button>
                                <button class="btn_todos" id="btn_cor_amarelo" onClick={debitarAgendado}>Agendar Saque</button> 
                                <br />
                                <button class="btn_todos" id="btn_cor_verde" onClick={executarOperacao}> Atualiza Financeiro</button>
                                <button class="btn_todos" id="btn_cor_vermelha" onClick={desfazer} >Desfazer</button>
                              

                            </div>
                        </div>

                    </div>

                    <div className="div_direita">
                        <div className="div_icons">
                       <Link to="/cadastrar-projeto">
                            <button class="btn_todos"  id="btn_cor_amarelo_cad">Cadastrar projeto</button>        
                            </Link> 
                        <label for="arquivo" class="txt_upload"> Escolher arquivo</label> 
                         <input type="file" name="arquivo" id="arquivo" onChange={(e) => setFile(e.target.files[0])} />

                         <button class="btn_todos" id="btn_cor_azul" onClick={submitForm}>Upload!</button>
                       
                        </div>

                        <div className="div_cards">
                            { 
                                cards.map((card) => (
                                    <Card
                                        key={card.id}
                                        id={card.id}
                                        titulo={card.titulo}
                                        categoria={card.categoria}
                                        linguagem={card.linguagem}
                                        publicadoEm={card.publicadoEm}
                                        descricao={card.descricao}
                                        valor={card.valor}
                                    />
                                ))
                            }
                        </div>
                        

       
                        </div>

                    <br />
                </div>

                <div>
                    <Footer />
                </div>
                </div>
        )
    }
export default Cards;
