import React from "react";
import funciona from '../html/img/1.svg';
import funciona2 from '../html/img/2.svg';
import funciona3 from '../html/img/3.svg';

function ComoFunciona() {
    return (
        <div class="contem_tudo" id="comoFunciona">
        <div class="container">
            <h1> Como funciona? </h1>
            <div class="cont">
                <div class="info">
                    <div class="img">
                        <img src={funciona2} alt="" />
                    </div><br />
                    <h2>Cadastre-se</h2><br />
                    <p>Cadastre suas informações em nosso site, como experiências, linguagens que trabalha, portfolio,
                        etc.</p><br />
                    <a href="#"> Saiba mais </a>
                </div>
                <div class="info">
                    <div class="img">
                        <img src={funciona3} alt="" class="info_img" />
                    </div><br />
                    <h2>Escolha o job</h2><br />
                    <p>Dentre centenas de jobs, escolha o que te interessar, através de recomendações baseadas nos seus
                        conhecimentos e filtros.</p><br />
                    <a href="#"> Saiba mais </a>
                </div>
                <div class="info">
                    <div class="img">
                        <img src={funciona} alt="" />
                    </div><br />
                    <h2>Entregue e receba</h2><br />
                    <p>Entregue o combinado, aumentando sua credibilidade na plataforma e receba o valor combinado 100%
                        garantido.</p><br />
                    <a> Saiba mais </a>
                </div>
            </div>
        </div>
    </div>
    )
};

export default ComoFunciona;