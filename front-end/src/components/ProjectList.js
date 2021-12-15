import axios from 'axios';
import React from 'react';

export default class ProjectList extends React.Component {
    state = {
        projects: []
    }

    componentDidMount() {
        axios.get(`http://localhost:8080/devfy/projetos`)
        .then(results => {
            console.log(results);
            this.setState({projects: results.data});
        })  
    }

    render() {
        return (
            <ul>
                {this.state.projects.map( project =>
                <div>
                 <li> <h1>{project.titulo}</h1> <h2>{project.descricao}</h2> <h3>{project.valor}</h3> </li>
                 </div>
                
                ) }
            </ul>
        )
    }

}