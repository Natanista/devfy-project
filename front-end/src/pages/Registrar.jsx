import React, { useState } from "react";
import api from "../api";
import Menu from "../components/Menu";
import Footer from "../components/Footer";
import { useHistory } from 'react-router';
import logoGrande from '../html/img/LogoGrande.png';

function Registrar() {

  const [nomeDigitado, setNomeDigitado] = useState("");
  const [emailDigitado, setemailDigitado] = useState("");
  const [telefoneDigitado, settelefoneDigitado] = useState("");
  const [paisDigitado, setpaisDigitado] = useState("");
  const [cepDigitado, setcepDigitado] = useState("");
  const [representanteDigitado, setrepresentanteDigitado] = useState("");
  const [telefoneRepresentanteDigitado, settelefoneRepresentanteDigitado] = useState("");
  const [usuarioDigitado, setusuarioDigitado] = useState("");
  const [senhaDigitada, setsenhaDigitada] = useState("");
  const [cnpjDigitado, setcnpjDigitado] = useState("");

  const history = useHistory();


  function cadastrar(e) {
    e.preventDefault();

    api.post("/empresas", {
      nome: nomeDigitado,
      email: emailDigitado,
      telefone: telefoneDigitado,
      pais: paisDigitado,
      cep: cepDigitado,
      representante: representanteDigitado,
      telefoneRepresentante: telefoneRepresentanteDigitado,
      usuario: usuarioDigitado,
      senha: senhaDigitada,
      cnpj: cnpjDigitado
    }).then((resposta) => {
      history.push("/login")
    }).catch((erro) => {
      alert("Erro ao cadastrar a empresa!")
    });

  }

  return (
    <div>
      <Menu />

      <div class="content-tudo-cad">
          <h1>Cadastrar</h1>
          <form onSubmit={cadastrar} >
            <label>
              Nome: <br />
              <input  type="text" onChange={e => setNomeDigitado(e.target.value)} />
            </label>
            <br /> <br />
            <label>
              Email: <br />
              <input  type="text" onChange={e => setemailDigitado(e.target.value)} />
            </label>
            <br /> <br />
            <label>
              Telefone: <br />
              <input   type="text" onChange={e => settelefoneDigitado(e.target.value)} />
            </label>
            <br /> <br />
            <label>
              Pais: <br />
              <input  type="text" onChange={e => setpaisDigitado(e.target.value)} />
            </label>
            <br /> <br />
            <label>
              CEP: <br />
              <input   type="text" onChange={e => setcepDigitado(e.target.value)} />
            </label>
            <br /> <br />
            <label>
              CNPJ: <br />
              <input   type="text" onChange={e => setcnpjDigitado(e.target.value)} />
            </label>
            <br /> <br />
            <label>
              Representante: <br />
              <input   type="text" onChange={e => setrepresentanteDigitado(e.target.value)} />
            </label>
            <br /> <br />
            <label>
              Telefone Representante: <br />
              <input   type="text" onChange={e => settelefoneRepresentanteDigitado(e.target.value)} />
            </label>
            <br /> <br />
            <label>
              Usuário: <br />
              <input   type="text" onChange={e => setusuarioDigitado(e.target.value)} />
            </label>
            <br /> <br />
            <label>
              Senha: <br />
              <input  type="text" onChange={e => setsenhaDigitada(e.target.value)} />
            </label>
            <br />
            <br />
            <button class="btn_global" type="submit">Enviar</button>

          </form>
      </div>

      <div class="espacamento"></div>

      <Footer />
    </div>
  );
}

export default Registrar;