import React, { useState } from "react";
import api from "../api";
import Menu from "../components/Menu";
import { useHistory } from 'react-router';
import logoGrande from '../html/img/LogoGrande.png';
import MenuLogado from "../components/MenuLogado";
import BotaoVerde from "../components/Botao2";

function Registrar() {

  const [tituloDigitado, setTituloDigitado] = useState("");
  const [linguagemDigitada, setLinguagemDigitada] = useState("");
  const [descricaoDigitada, setDescricaoDigitada] = useState("");
  const [categoriaDigitada, setCategoriaDigitada] = useState("");
  const [valorDigitado, setValorDigitado] = useState("");


  const history = useHistory();


  function cadastrar(e) {
    e.preventDefault();

    api.post(`/projetos`, {
      titulo: tituloDigitado,
      linguagem: linguagemDigitada,
      descricao: descricaoDigitada,
      categoria: categoriaDigitada,
      valor: valorDigitado,
    }).then((resposta) => {
      history.push("/dashboard-empresa")
    }).catch((erro) => {
      alert("Erro ao cadastrar projeto!")
    });

  }

  return (
    <div>
      <MenuLogado />

      <div class="content-tudo">
          <h1>Cadastro de projeto</h1>
          <form onSubmit={cadastrar}>
            <br />
            <label>
              Titulo: <br />
              <input class="input_info" type="text" onChange={e => setTituloDigitado(e.target.value)} />
            </label>
            <br /><br />
            <label>
              Linguagem: <br />
              <input class="input_info" type="text" onChange={e => setLinguagemDigitada(e.target.value)} />
            </label>
            <br /><br />
            <label>
              Descricao: <br />
              <input class="input_info" type="text" onChange={e => setDescricaoDigitada(e.target.value)} />
            </label>
            <br /><br />
            <label>
              Categoria: <br />
              <input class="input_info" type="text" onChange={e => setCategoriaDigitada(e.target.value)} />
            </label>
            <br /><br />
            <label>
              Valor: <br />
              <input class="input_info" type="text" onChange={e => setValorDigitado(e.target.value)} />
            </label>
            <br /><br />

            <button type="submit" class="btn_global"> Cadastrar </button>

          </form>
        </div>
      </div>
  );
}

export default Registrar;