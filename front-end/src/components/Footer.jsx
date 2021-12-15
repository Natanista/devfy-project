import React from "react";
import logo from '../html/img/LOGO.png';
import rede from '../html/img/facebook.png';
import rede2 from '../html/img/instagram.png';
import rede3 from '../html/img/linkedin.png';
import rede4 from '../html/img/telephone.png';

function Footer() {
  return (
    <div>
      <footer>
        <div class="container">
            <div class="cont-footer">
                <div class="cont-img">
                    <img src={logo} alt="" />
                </div>
                <div class="cont-footer-texto">
                    <div class="cont-footer-telefone">
                        <img src={rede4} alt="" />
                        <p>+55 (11) 9 - 0000 - 000</p>
                    </div>
                    <p>Rua haddock Lobo, 595 - Cerqueira César</p>
                    <p>São paulo - SP, 01123 - 000</p>
                    <div class="cont-footer-icone">
                        <img src={rede} alt="" />
                        <img src={rede2} alt="" />
                        <img src={rede3} alt="" />
                    </div>
                </div>
            </div>
        </div>
    </footer>
    </div>
  );
}

export default Footer;
