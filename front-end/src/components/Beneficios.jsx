import React from "react";
import beneficio from '../html/img/dollar.svg';
import beneficio2 from '../html/img/emoji_happy.svg';
import beneficio3 from '../html/img/seguro.svg';

function Beneficios() {
    return (
        <div class="contem_tudo_ben">
                <div class="container"><br /><br />
                    <h1> Benefícios </h1>
                    <div class="cont">
                        <div class="info_ben">
                            <div class="img_ben">
                                <img src={beneficio2} alt="" />
                            </div><br />
                            <h2>Conexões</h2><br />
                            <p>Conheça pessoas e projetos da sua área de trabalho</p><br />
                        </div>
                        <div class="info_ben">
                            <div class="img_ben">
                                <img src={beneficio3} alt="" />
                            </div><br />
                            <h2>Segurança</h2><br />
                            <p>Suporte ativo e segurança no pagamento</p><br />
                        </div>
                        <div class="info_ben">
                            <div class="img_ben">
                                <img src={beneficio} alt="" />
                            </div><br />
                            <h2>Taxas reduzidas</h2><br />
                            <p>Somos a empresa com as taxas mais baixas do mercado freelancer</p><br />
                        </div>
                    </div>
                </div>
            </div>
    );
}

export default Beneficios;