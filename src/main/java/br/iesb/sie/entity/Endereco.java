package br.iesb.sie.entity;

import br.iesb.sie.model.UF;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "ENDERECO")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Endereco extends BaseEntity {

    @Id
    @Column(name = "ID_ENDERECO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CEP")
    private Integer cep;

    @Column(name = "MUNICIPIO")
    private String municipio;

    @Column(name = "ENDERECO")
    private String endereco;

    @Column(name = "UF")
    @Enumerated(EnumType.STRING)
    private UF uf;

    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "BAIRRO")
    private String bairro;

    @Column(name = "COMPLEMENTO")
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
