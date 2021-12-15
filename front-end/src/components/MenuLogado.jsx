import React from "react";
import logo from '../html/img/LOGO.png';
import Login from "../pages/Login";
import { Link } from "react-router-dom";

function MenuLogado() {
  return (
    <div>
      <header class="header">
        <nav>
          <div class="container">
            <Link to={'/'}>
            <img class="logo_img" src={logo} alt="" />
            </Link>
            <ul class="menu_1">
              <li>
                <a href="#">Freelancer</a>
              </li>
              <li>
                <a href="#empresa">Empresa</a>
              </li>
              <li>
                <a href="#comoFunciona">Como funciona</a>
              </li>
            </ul>
            <ul class="menu_2">
              <li class="menu_li">
            
                
              </li>
            </ul>
          </div>
        </nav>
      </header>
    </div>
  );
}

export default MenuLogado;
