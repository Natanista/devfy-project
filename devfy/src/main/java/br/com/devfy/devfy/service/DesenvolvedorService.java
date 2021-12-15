package br.com.devfy.devfy.service;

import br.com.devfy.devfy.helper.UsuarioLogin;
import br.com.devfy.devfy.entity.Desenvolvedor;
import br.com.devfy.devfy.repository.DesenvolvedorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DesenvolvedorService {

    @Autowired
    private DesenvolvedorRepository desenvolvedorRepository;

    public Desenvolvedor getById(int id){
        return desenvolvedorRepository.getById(id);
    }

    public ResponseEntity save(Desenvolvedor desenvolvedor) {
        log.info("save em DesenvolvedorService");
        desenvolvedor.logoff();
        desenvolvedor.cancelarPremium();
        desenvolvedorRepository.save(desenvolvedor);
        return ResponseEntity.status(201).build();
    }

    public ResponseEntity update(
            int id,
            Desenvolvedor desenvolvedor) {
        log.info("update em DesenvolvedorService");
        if (desenvolvedorRepository.existsById(id)) {
            desenvolvedor.setId(id);
            desenvolvedorRepository.save(desenvolvedor);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }


    public ResponseEntity findAll() {
        log.info("findAll em DesenvolvedorService");
        List<Desenvolvedor> desenvolvedores = desenvolvedorRepository.findAll();
        if (desenvolvedores.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(desenvolvedores);
    }


    public ResponseEntity delete(int id) {
        log.info("delete em DesenvolvedorService");
        if (desenvolvedorRepository.existsById(id)) {
            desenvolvedorRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    public ResponseEntity login(UsuarioLogin desenvolvedor) {
        log.info("login em DesenvolvedorService");
        Desenvolvedor devEncontrado = desenvolvedorRepository.findDesenvolvedorByUsuarioEqualsAndSenhaEquals(
                desenvolvedor.getUsuario(), desenvolvedor.getSenha()
        );

        if (devEncontrado.equals(null)) {
            return ResponseEntity.status(404).build();
        }

        devEncontrado.login();
        desenvolvedorRepository.save(devEncontrado);
        return ResponseEntity.status(200).body(devEncontrado);
    }

    public ResponseEntity logoff(int id) {
        log.info("logoff em DesenvolvedorService");
        if (desenvolvedorRepository.existsById(id)) {
            Desenvolvedor desenvolvedor = desenvolvedorRepository.getById(id);
            desenvolvedor.logoff();
            desenvolvedorRepository.save(desenvolvedor);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

}

