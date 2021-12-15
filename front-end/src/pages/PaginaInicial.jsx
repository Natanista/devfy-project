import React from "react";
import Menu from "../components/Menu";
import Footer from "../components/Footer";
import Banner from "../components/Banner";
import ComoFunciona from "../components/ComoFunciona";
import Beneficios from "../components/Beneficios";
import Empresa from "../components/Empresa";
import ProjectList from "../components/ProjectList";

function PaginaInicial() {
    return (
        <div>
            <Menu />

       
            <Banner />

            <ComoFunciona />

            <Beneficios />

            <Empresa />

            <Footer />
        </div>
    );
}

export default PaginaInicial;