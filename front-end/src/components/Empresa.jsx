import React from "react";
import mulherHistoria from '../html/img/mulher.svg';

function Empresa() {
    return (
        <div class="contem_tudo" id="empresa">
                <div class="container">
                    <div class="contem_tudo_his">
                        <div class="cont_img">
                            <img src={mulherHistoria} alt="" />
                        </div>
                        <div class="cont_historia">
                            <h1> Nossa História </h1>
                            <p>A devfy surge em 2021 com o propósito de intermediar a relação entre desenvolvedores freelancers
                                e empresas, gerando uma relação de confiaça e sucesso para ambas as partes.Temos como pilares
                                confiança, seriedade e empreendedorismo. Surgimos durante a pandemia para facilitar esse setor e
                                promover as relações de trabalho sem vínculo empregatício.</p>
                        </div>
                    </div>
                </div>
            </div>
    );
}

export default Empresa;