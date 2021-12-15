package br.com.devfy.devfy.entity;


import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_desenvolvedor")
public class Desenvolvedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dev_id")
    private int id;

    @NotNull
    @Column(name = "dev_nome")
    private String nome;

    @Email
    @NotNull
    @Column(name = "dev_email")
    private String email;

    @NotNull
    @Pattern(regexp = "\\d{11}", message = "O telefone deve conter 11 inteiros")
    @Column(name = "dev_telefone")
    private String telefone;

    @NotNull
    @Column(name = "dev_nacionalidade")
    private String nacionalidade;

    @NotNull
    @Pattern(regexp =  "\\d{5}-\\d{3}",
            message = "o cep deve conter 8 caracteres, sendo eles: 5 inteiros, seguido de traço e dos 3 inteiros restantes")
    @Column(name = "dev_cep")
    private String cep;

    @NotNull
    @CPF
    @Column(name = "dev_cpf")
    private String cpf;

    @Size(min = 10, max = 60, message
            = "Descriçao deve ter entre 10 e 60 caracteres")
    @Column(name = "dev_descricao")
    private String descricao;

    @Column(name = "dev_autenticado")
    private Boolean isAutenticado;

    @Column(name = "premium")
    private Boolean isPremium;

    @Column(name = "dev_valor_hora")
    private Double valorHora;

    @Size(min = 1, max = 30, message
            = "A linguagem deve ter entre 1 e 30 caracteres")
    @Column(name = "linguagem_dev")
    private String linguagem;

    @PositiveOrZero
    @Column(name = "dev_anos_exp")
    private int anoSExperiencia;

    @NotNull
    @Size(min = 8, max = 15, message
            = "O campo usuario deve conter entre 8 e 15 caracteres")
    @Column(name = "dev_usuario")
    private String usuario;

    @NotNull
    @Size(min = 8, max = 20, message
            = "A senha deve conter no minimo 8, e  no maximo 20 caracteres.")
    @Column(name = "dev_senha")
    private String senha;

    @OneToMany(mappedBy = "desenvolvedor")
    private List<Projeto> projetos;

    public List<String> getProjetos() {
        List<String> projs = new ArrayList<>();

        for (Projeto projeto : projetos) {
            projs.add(projeto.getTitulo());
        }

        return projs;
    }


    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getIsAutenticado() {
        return isAutenticado;
    }

    public void setIsAutenticado(Boolean autenticado) {
        this.isAutenticado = autenticado;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    public int getAnoSExperiencia() {
        return anoSExperiencia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagemDev) {
        this.linguagem = linguagemDev;
    }

    public void logoff() {
        this.isAutenticado = false;
    }

    public void login() {
        this.isAutenticado = true;
    }

    public Boolean getPremium() {
        return isPremium;
    }

    public void setPremium(Boolean premium) {
        isPremium = premium;
    }

    public void contratarPremium(){
        this.isPremium = true;
    }

    public void cancelarPremium(){
        this.isPremium = false;
    }

}
