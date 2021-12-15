import React from "react";
import '../html/css/dashboard.css'
import Card from "../components/Card";

function QuadradoCinzaDaDashboard() {
  return (
    <div class="div_fundo">
      <div class="div_cinza">
          <h3>Projetos</h3>
          <div class="div_fundo_card">
            <Card  projeto="eu nao vou sentir saudade" empresa="asd" linguagem="asd" tempoEst="to escrevendo na tela"/>
          </div>          
      </div>
      <div class="div_cinza">
        <h3>Projetos em andamento</h3>
        <div class="div_fundo_card">
            <Card/>    
        </div>   

      </div>
      <div class="div_cinza">
      <h3>Projetos concluidos</h3>
      </div>
    </div>
    );
}

export default QuadradoCinzaDaDashboard;