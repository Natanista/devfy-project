package br.com.devfy.devfy.controller;


import br.com.devfy.devfy.helper.UsuarioLogin;
import br.com.devfy.devfy.entity.Desenvolvedor;
import br.com.devfy.devfy.service.DesenvolvedorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/devfy/desenvolvedores")
@Slf4j
public class DesenvolvedorController {

    @Autowired
    private DesenvolvedorService desenvolvedorService;

    @GetMapping
    public ResponseEntity findAll() {
        log.info("findAll em DesenvolvedorController");
        return desenvolvedorService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(
            @PathVariable int id,
            @Valid  @RequestBody Desenvolvedor desenvolvedor
    ) {
        log.info("update em DensenvolvedorController");
        return desenvolvedorService.update(id, desenvolvedor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(
            @PathVariable int id) {
        log.info("delete em DesenvolvedorController");
        return desenvolvedorService.delete(id);
    }

    //feito
    @PostMapping
    public ResponseEntity save(
            @Valid @RequestBody Desenvolvedor desenvolvedor
    ) {
        log.info("save em DesenvolvedorController");
        return desenvolvedorService.save(desenvolvedor);
    }

    @PostMapping("/login")
    public ResponseEntity login( @Valid @RequestBody UsuarioLogin desenvolvedor) {
        log.info("login em DesenvolvedorController");
        return desenvolvedorService.login(desenvolvedor);
    }

    @PostMapping("/logoff/{id}")
    public ResponseEntity logoff(@PathVariable int id) {
        log.info("logoff em DesenvolvedorController");
        return desenvolvedorService.logoff(id);
    }

}
