import React from "react";
import bannerPessoas from '../html/img/pessoas.png';
import BotaoVerde from "./Botao2";
import BotaoLaranja from "./Botao";

function Banner() {
    return (
        <div class="banner">
            <div class="container">
                <div class="cont">
                    <div class="banner_left">
                        <h1> Encontre Projetos e Freelancers </h1>
                        <p>Entre na plataforma ideal para quem procura trabalhos freelance ou procura freelancers para seus
                            trabalhos e projetos!</p>
                        <div class="text_banner">
                            <BotaoLaranja />
                            <p>Registre-se como <b class="banner_text">Empresa</b>, e crie projetos!</p>
                        </div>
                        <div class="text_banner">
                            <BotaoVerde />
                            <p>Registre-se como <b class="banner_text2">Freelancer</b>, e ajude projetos!</p>
                        </div>
                    </div>
                    <div class="banner_right">
                        <img src={bannerPessoas} class="banner_img" alt="" />
                    </div>
                </div>
            </div>
        </div>
    );
}
export default Banner;