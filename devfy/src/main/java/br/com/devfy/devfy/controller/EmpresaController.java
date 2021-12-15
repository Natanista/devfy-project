package br.com.devfy.devfy.controller;

import br.com.devfy.devfy.helper.UsuarioLogin;
import br.com.devfy.devfy.entity.Empresa;
import br.com.devfy.devfy.service.EmpresaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/devfy/empresas")
public class EmpresaController {


    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public ResponseEntity getAll() {
        log.info("getAll em EmpresaController");
        return empresaService.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(
            @PathVariable int id,
            @Valid @RequestBody Empresa empresa
    ) {
        log.info("update em EmpresaControlelr");
        return empresaService.update(id, empresa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(
            @PathVariable int id) {
        log.info("delete em EmpresaController");
        return empresaService.delete(id);
        }

    @PostMapping()
    public ResponseEntity save(
           @Valid @RequestBody Empresa empresa
    ) {
        log.info("save em EmpresaController");
        return empresaService.save(empresa);
    }

    @PostMapping ("/login")
    public ResponseEntity login( @Valid @RequestBody UsuarioLogin empresa) {
        log.info("login em EmpresaController");
        return empresaService.login(empresa);
    }

    @PostMapping("/logoff/{id}")
    public ResponseEntity logoff(  @PathVariable int id) {
       log.info("logoff em EmpresaController");
       return empresaService.logoff(id);
    }


}
