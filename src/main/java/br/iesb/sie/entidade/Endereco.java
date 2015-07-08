package br.iesb.sie.entidade;

import br.iesb.sie.model.UF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private Integer cep;

    @Column
    @NotNull
    private String municipio;

    @Column
    @NotNull
    private String endereco;

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private UF uf;

    @Column
    @NotNull
    private String numero;

    @Column
    @NotNull
    private String bairro;

    @Column
    private String complemento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
