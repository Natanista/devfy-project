import React from 'react'
import {BrowserRouter, Switch, Route} from 'react-router-dom'
import PaginaInicial from './pages/PaginaInicial';
import AddProject from './pages/AddProject';
import Login from './pages/Login';
import Registrar from './pages/Registrar';
import DashboardEmpresa  from './pages/DashboardEmpresa';
import UpdateProject from './pages/UpdateProject';

//BrowserRouter: da acesso para usar os recursos de rotas
//Switch: permite navegar entre as rotas
//Route : cria a rota em si

function Rotas(){
    return(
        <BrowserRouter>
            <Switch>
               <Route exact path="/" component={PaginaInicial}/> 
               <Route exact path="/login" component={Login}/>
               <Route exact path="/registrar" component={Registrar}/>
               <Route exact path="/dashboard-empresa" component={DashboardEmpresa}/>
               <Route exact path="/cadastrar-projeto" component={AddProject} />
               <Route exact path="/atualizar-projeto/:id" component={UpdateProject} />
            </Switch>
        </BrowserRouter>
    );
}

export default Rotas;