package br.com.devfy.devfy.service;

import br.com.devfy.devfy.entity.Desenvolvedor;
import br.com.devfy.devfy.helper.UsuarioLogin;
import br.com.devfy.devfy.entity.Empresa;
import br.com.devfy.devfy.repository.EmpresaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa getById(int id){
        return empresaRepository.getById(id);
    }

    public ResponseEntity getAll() {
        log.info("getAll em EmpresaService");
        List<Empresa> empresas = empresaRepository.findAll();

        if (empresas.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(empresas);
    }

    public ResponseEntity update(int id, Empresa empresa) {
        log.info("update em EmpresaService");
        if (empresaRepository.existsById(id)) {
            empresa.setId(id);
            empresaRepository.save(empresa);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }


    public ResponseEntity delete(int id) {
        log.info("delete em EmpresaService");
        if (empresaRepository.existsById(id)) {
            empresaRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    public ResponseEntity save(Empresa empresa) {
        log.info("save em EmpresaService");
        empresa.logoff();
        empresa.cancelarPremium();
        empresaRepository.save(empresa);
        return ResponseEntity.status(201).build();
    }

    public ResponseEntity login(UsuarioLogin empresa) {
        log.info("login em EmpresaService");
        Empresa empresaEncontrada = empresaRepository.findEmpresaByUsuarioEqualsAndSenhaEquals(
                empresa.getUsuario(), empresa.getSenha()
        );

        if(empresaEncontrada == null){
            return ResponseEntity.status(200).body(false);
        }
        empresaEncontrada.login();
        empresaRepository.save(empresaEncontrada);
        return ResponseEntity.status(200).body(true);
    }

    public ResponseEntity logoff(int id) {
        log.info("logoff em EmpresaService");
        if (empresaRepository.existsById(id)) {
            Empresa empresa = empresaRepository.getById(id);
            empresa.logoff();
            empresaRepository.save(empresa);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

}
