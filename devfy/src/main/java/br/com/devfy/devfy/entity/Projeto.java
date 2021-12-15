package br.com.devfy.devfy.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_projeto")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_projeto")
    private int id;

    @Column(name = "proj_titulo")
    private String titulo;

    @Column(name = "proj_linguagem")
    private String linguagem;

    @Column(name = "proj_descricao")
    private String descricao;

    @Column(name = "proj_categoria")
    private String categoria;

    @Column(name = "proj_valor")
    private Double valor;

    @Column(name = "proj_publicacao")
    private LocalDateTime publicadoEm;

    @ManyToOne
    @JoinColumn(name="dev_id", nullable=true)
    private Desenvolvedor desenvolvedor;

    @ManyToOne
    @JoinColumn(name="emp_id", nullable=true)
    private Empresa empresa;

    public Desenvolvedor getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(Desenvolvedor desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public LocalDateTime getPublicadoEm() {
        return publicadoEm;
    }

    public void setPublicadoEm(LocalDateTime publicadoEm) {
        this.publicadoEm = publicadoEm;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
