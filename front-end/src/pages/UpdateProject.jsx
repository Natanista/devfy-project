import React, { useEffect, useState } from "react";
import api from "../api";
import Footer from "../components/Footer";
import { useHistory, useParams } from 'react-router';
import MenuLogado from "../components/MenuLogado";

function UpdateProject() {

    const { id } = useParams();
    const history = useHistory();


  const [tituloDigitado, setTituloDigitado] = useState("");
  const [linguagemDigitada, setLinguagemDigitada] = useState("");
  const [descricaoDigitada, setDescricaoDigitada] = useState("");
  const [categoriaDigitada, setCategoriaDigitada] = useState("");
  const [valorDigitado, setValorDigitado] = useState("");

  useEffect(() => {
    async function getById() {
        const resposta = await api
        .get(`/projetos/${id}`)
        .then((resposta) => {
            console.log("Achei esse id: ", resposta)
            setTituloDigitado(resposta.data.titulo);
            setLinguagemDigitada(resposta.data.linguagem);
            setDescricaoDigitada(resposta.data.descricao);
            setCategoriaDigitada(resposta.data.categoria);
            setValorDigitado(resposta.data.valor);
        })
        .catch((erro) => {
            console.log("Erro ao buscar projeto pelo id")
        })
    }
    getById();
  }, [])




  function update(e) {
    e.preventDefault();

    api.put(`/projetos/${id}`, {
      titulo: tituloDigitado,
      linguagem: linguagemDigitada,
      descricao: descricaoDigitada,
      categoria: categoriaDigitada,
      valor: valorDigitado,
    }).then((resposta) => {
      history.push("/dashboard-empresa")
    }).catch((erro) => {
      alert("Erro ao atualizar projeto!")
    });

  }

  return (
    <div>
      <MenuLogado />
        <div class="content-tudo">
        <h1>Atualização de projeto</h1>
          <form onSubmit={update}>
            <label>
              Titulo: <br />
              <input class="input_info" type="text" onChange={e => setTituloDigitado(e.target.value)} value={tituloDigitado} />
            </label>
            <br />
            <br />
            <label>
              Linguagem: <br /> 
              <input class="input_info" type="text" onChange={e => setLinguagemDigitada(e.target.value)} value={linguagemDigitada} />
            </label>
            <br />
            <br />
            <label>
              Descricao: <br />
              <input class="input_info" type="text" onChange={e => setDescricaoDigitada(e.target.value)} value={descricaoDigitada} />
            </label>
            <br />
            <br />
            <label>
              Categoria: <br />
              <input class="input_info" type="text" onChange={e => setCategoriaDigitada(e.target.value)} value={categoriaDigitada} />
            </label>
            <br />
            <br />
            <label>
              Valor: <br />
              <input class="input_info" type="text" onChange={e => setValorDigitado(e.target.value)} value={valorDigitado} />
            </label>
            <br />
<br />
            <button type="submit" class="btn_global"> Atualizar </button>

          </form>
        </div>
        <Footer />
      </div>
  );
}

export default UpdateProject;