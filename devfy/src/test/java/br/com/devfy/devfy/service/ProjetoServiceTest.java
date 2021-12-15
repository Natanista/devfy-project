package br.com.devfy.devfy.service;

import br.com.devfy.devfy.controller.ProjetoController;
import br.com.devfy.devfy.entity.Projeto;
import br.com.devfy.devfy.repository.ProjetoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProjetoServiceTest {

    @MockBean
    ProjetoRepository projetoRepository;

    @Autowired
    ProjetoService projetoService;


    //getAll tests
    @Test
    @DisplayName("Quando chamar getAll deve retornar todos e status 200")
    void getAllDeveRetornarConteudoEStatus200() {
        //Given
        List<Projeto> projetos = List.of(new Projeto(), new Projeto());
        //When
        when(projetoRepository.findAll()).thenReturn(projetos);
        ResponseEntity response = projetoService.getAll();
        //Then

        assertTrue(response.hasBody());
        assertEquals(projetos, response.getBody());
        assertEquals(200, response.getStatusCodeValue());

    }

    @Test
    @DisplayName("Quando chamar getAll deve retornar null e status 204")
    void getAllDeveRetornarVazioE404() {
        //Given
        List<Projeto> projetos = projetoRepository.findAll();
        ResponseEntity response = projetoService.getAll();

        //When
        when(projetoRepository.findAll()).thenReturn(projetos);

        //Then
        assertNull(response.getBody());
        assertEquals(204, response.getStatusCodeValue());
    }

    //save tests
    @Test
    @DisplayName("Quando salvar deve retornar 201")
    void deveSalvarERetornarStatus201() {
        //Given
        Projeto projeto = new Projeto();
        projeto.setId(1);
        //When
        ResponseEntity response =  projetoService.save(projeto);
        //Then
        assertEquals(201, response.getStatusCodeValue());
    }

    //update tests
    @Test
    @DisplayName("Quando atualizar deve atualizar e retornar 201")
        void deveAtualizarERetornar201(){

        //Given
        Projeto projeto = new Projeto();
        projeto.setId(1);
        projeto.setCategoria("site de carros");
        Projeto projeto2 = new Projeto();
        projeto2.setCategoria("site de prefeitura");

        //When
        when(projetoRepository.findAll()).thenReturn(List.of(projeto));
        when(projetoRepository.existsById(1)).thenReturn(true);
        ResponseEntity response = projetoService.update(1, projeto2);
        List<Projeto> projetos = projetoRepository.findAll();

        //Then
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(projetos.get(0).getTitulo(), projeto2.getTitulo());

        }

    @Test
    @DisplayName("Quando atualizar nao deve atualizar e retornar 404")
    void deveAtualizarERetornar404(){

        //Given
        Projeto projeto = new Projeto();
        projeto.setId(1);
        projeto.setCategoria("site de carros");
        Projeto projeto2 = new Projeto();
        projeto2.setCategoria("site de prefeitura");

        //When
        when(projetoRepository.findAll()).thenReturn(List.of(projeto));
        when(projetoRepository.existsById(1)).thenReturn(false);
        ResponseEntity response = projetoService.update(1, projeto2);
        Projeto projetoAtualizado = projetoRepository.findProjetoByTituloEquals("site de prefeitura");

        //Then
        assertEquals(404, response.getStatusCodeValue());
        assertNull(projetoAtualizado);

    }

    //delete tests
    @Test
    @DisplayName("Quando deletar deve deletar e retornar 200")
    void deveDeletarERetornar200(){
        //Given
        Projeto projeto = new Projeto();
        projeto.setId(1);

        //When
        when(projetoRepository.findAll()).thenReturn(List.of(projeto));
        when(projetoRepository.existsById(1)).thenReturn(true);
        ResponseEntity response = projetoService.delete(1);

        //Then
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(0, projetoRepository.count());
    }

    @Test
    @DisplayName("Quando deletar deve retornar 404")
    void deveNaoApagarERetornar404(){

        //When
        when(projetoRepository.existsById(1)).thenReturn(false);
        ResponseEntity response = projetoService.delete(1);

        //Then
        assertEquals(404, response.getStatusCodeValue());
    }

    //


}