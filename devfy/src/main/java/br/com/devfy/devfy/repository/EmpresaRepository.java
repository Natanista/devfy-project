package br.com.devfy.devfy.repository;

import br.com.devfy.devfy.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
Interface com os métodos de acesso a banco para a entidade Musica
<Musica, Integer>
 Musica -> Tipo da Entidade
 Integer -> Tipo da PK da Entidade (note que é o tipo do atributo anotado com @Id em Musica)
 */
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

    Empresa findEmpresaByUsuarioEqualsAndSenhaEquals(String usuario, String senha);


}
