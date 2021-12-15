package br.com.devfy.devfy.entity;



import javax.persistence.*;

@Entity
@Table(name = "tbl_conta_bancaria")
public class ContaBancaria {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer numero;
    private Double saldo;


    // Metodos

    public Boolean debitar(Double valor){
        if(valor > saldo) {
            System.out.println("Saldo insuficiente");
            return false;
        }
        saldo = saldo - valor;
        System.out.println(String.format("Saldo atual(pós débito): R$%.2f", saldo));
        return true;
    }

    public void depositar(Double valor){
        saldo = saldo + valor;
        System.out.println(String.format("Saldo atual(pós depósito): R$%.2f", saldo));
    }


    // Sobrescrita do metodo toString()
    @Override
    public String toString() {
        return String.format("\n----------Conta Bancária----------\n" +
                        "Número: %d\n" +
                        "Saldo: R$%.2f",
                numero, saldo);
    }

    // Getters and Setters
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
