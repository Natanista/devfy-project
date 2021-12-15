package br.com.devfy.devfy.service;

import br.com.devfy.devfy.dto.ValorContaDTO;
import br.com.devfy.devfy.entity.ContaBancaria;
import br.com.devfy.devfy.helper.FilaObj;
import br.com.devfy.devfy.helper.Operacao;
import br.com.devfy.devfy.helper.PilhaObj;
import br.com.devfy.devfy.repository.ContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.devfy.devfy.helper.FilaObj;

@Service
public class ContaBancariaService<FilaObj> {

    public static int contador = 0;

    @Autowired
    ContaBancariaRepository contaBancariaRepository;

    PilhaObj<Operacao> pilhaOperacoes = new PilhaObj(1000);
    br.com.devfy.devfy.helper.FilaObj<Operacao> filaOperacoes = new br.com.devfy.devfy.helper.FilaObj<>(1000);


    public ResponseEntity getContaById(int id) {

     if(contaBancariaRepository.existsById(id))   {
         return ResponseEntity.status(200).body(contaBancariaRepository.findById(id).get());
     }
     return ResponseEntity.status(404).build();
    }


    public ResponseEntity debitar(ValorContaDTO valor, int id) {
        if(!contaBancariaRepository.existsById(id)){
            return ResponseEntity.status(404).build();
        }

        ContaBancaria conta = contaBancariaRepository.getById(id);
        conta.debitar(valor.getValor());
        Operacao operacao = new Operacao(conta, "debito", valor.getValor());
        pilhaOperacoes.push(operacao);
        contador++;
        contaBancariaRepository.save(conta);
        return ResponseEntity.status(200).build();
    }

    public ResponseEntity depositar(ValorContaDTO valor, int id)
    {
        if(!contaBancariaRepository.existsById(id)){
            return ResponseEntity.status(404).build();
        }
        ContaBancaria conta = contaBancariaRepository.getById(id);
        conta.depositar(valor.getValor());
        Operacao operacao = new Operacao(conta, "deposito", valor.getValor());
        pilhaOperacoes.push(operacao);
        contador++;
        contaBancariaRepository.save(conta);

        return ResponseEntity.status(200).build();
    }

    public ResponseEntity desfazer() {
            Operacao op = pilhaOperacoes.pop();
            if (("debito").equals(op.getTipoOperacao())) {
                ContaBancaria conta = contaBancariaRepository.getById(op.getContaBancaria().getId());
                conta.depositar(op.getValor());
                contaBancariaRepository.save(conta);
            } else if ("deposito".equals(op.getTipoOperacao())) {
                ContaBancaria conta = contaBancariaRepository.getById(op.getContaBancaria().getId());
                conta.debitar(op.getValor());
                contaBancariaRepository.save(conta);
            }
            contador -= 1;

            return ResponseEntity.status(200).build();
    }


    public ResponseEntity debitoAgendado(int id, ValorContaDTO valorDTO) {
        if(!contaBancariaRepository.existsById(id)){
            return ResponseEntity.status(404).build();
        }
        ContaBancaria conta = contaBancariaRepository.getById(id);
        conta.debitar(valorDTO.getValor());
        Operacao operacao = new Operacao(conta, "debito", valorDTO.getValor());
        filaOperacoes.insert(operacao);

        return ResponseEntity.status(200).build();
    }

    public ResponseEntity depositoAgendado(int id, ValorContaDTO valorDTO) {
        if(!contaBancariaRepository.existsById(id)){
            return ResponseEntity.status(404).build();
        }
        ContaBancaria conta = contaBancariaRepository.getById(id);
        conta.depositar(valorDTO.getValor());
        Operacao operacao = new Operacao(conta, "deposito", valorDTO.getValor());
        filaOperacoes.insert(operacao);

        return ResponseEntity.status(200).build();
    }

    public ResponseEntity executarOperacao() {
        if(filaOperacoes.isEmpty()){
            return ResponseEntity.status(204).build();
        }

        Operacao op = filaOperacoes.poll();
        if(op.getTipoOperacao().equals("debito")){
            ContaBancaria conta = contaBancariaRepository.getById(op.getContaBancaria().getId());
            conta.debitar(op.getValor());
            contaBancariaRepository.save(conta);
        }else{
            ContaBancaria conta = contaBancariaRepository.getById(op.getContaBancaria().getId());
            conta.depositar(op.getValor());
            contaBancariaRepository.save(conta);
        }

        return ResponseEntity.status(200).build();
    }

    public ResponseEntity saqueAgendado(int id, ValorContaDTO valorDTO) {
        if(!contaBancariaRepository.existsById(id)){
            return ResponseEntity.status(404).build();
        }
        ContaBancaria conta = contaBancariaRepository.getById(id);
        conta.debitar(valorDTO.getValor());
        Operacao operacao = new Operacao(conta, "debito", valorDTO.getValor());
        filaOperacoes.insert(operacao);
        contaBancariaRepository.save(conta);

        return ResponseEntity.status(200).build();
    }
}
