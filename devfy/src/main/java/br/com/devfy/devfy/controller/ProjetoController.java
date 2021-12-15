package br.com.devfy.devfy.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import br.com.devfy.devfy.helper.ListaObj;
import br.com.devfy.devfy.entity.*;
import br.com.devfy.devfy.repository.DesenvolvedorRepository;
import br.com.devfy.devfy.repository.EmpresaRepository;
import br.com.devfy.devfy.repository.ProjetoRepository;
import br.com.devfy.devfy.helper.EmailService;
import br.com.devfy.devfy.helper.SlackService;
import br.com.devfy.devfy.service.ProjetoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

import static br.com.devfy.devfy.helper.CsvGenerator.gravaArquivoCsv;
import static br.com.devfy.devfy.helper.CsvGenerator.leArquivoCsv;

@RestController
@RequestMapping("/devfy/projetos")
@Slf4j
@CrossOrigin
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    @CrossOrigin
    public ResponseEntity getAll() {
        log.info("getAll em ProjetoController");
        return projetoService.getAll();
    }

    @PostMapping("/import")
    public ResponseEntity importProjeto(@RequestParam MultipartFile txt) throws IOException {
        return projetoService.importProj(txt);
    }


    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity getById(
            @PathVariable int id
    ){
        log.info("getById em Projeto Controller");
        return projetoService.getById(id);
    }



    @PutMapping("/{id}")
    public ResponseEntity update(
            @PathVariable int id,
            @Valid @RequestBody Projeto projeto
    ) {
        log.info("update em ProjetoController");
        return projetoService.update(id, projeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(
            @PathVariable int id) {
        log.info("delete em ProjetoController");
        return projetoService.delete(id);
    }

    @PostMapping
    public ResponseEntity save(
            @Valid @RequestBody Projeto projeto
    ) {
        log.info("save em ProjetoController");
        return projetoService.save(projeto);
    }

    @GetMapping("/buscar/{tituloProjeto}")
    public ResponseEntity getProjetoByTitulo(@PathVariable String tituloProjeto) {
        log.info("getProjetoByTitulo em ProjetoController");
        return projetoService.getProjetoByTitulo(tituloProjeto);
    }

    @GetMapping("/export-csv/{id}")
    public ResponseEntity gerarRelatorioCsv(
            @PathVariable int id
    ) {
        log.info("gerarRelatorioCsv em ProjetoController");
        return projetoService.gerarRelatorioCsv(id);

    }


    @PutMapping("/associar-dev/{devId}/{projId}")
    public ResponseEntity associarDev(
            @PathVariable int devId,
            @PathVariable int projId
    ) {
        log.info("assicarDev em ProjetoController");
        return projetoService.associarDev(devId, projId);

    }

    @PutMapping("/associar-emp/{empId}/{projId}")
    public ResponseEntity associarEmpresa(
            @PathVariable int empId,
            @PathVariable int projId
    ) {
        log.info("associarEpresa em ProjetoCOntroller");
        return projetoService.associarEmp(empId, projId);

    }

    @GetMapping("/contagem")
    public ResponseEntity getContagem() {
        log.info("associarEpresa em ProjetoCOntroller");
        return projetoService.getContagem();

    }


}


