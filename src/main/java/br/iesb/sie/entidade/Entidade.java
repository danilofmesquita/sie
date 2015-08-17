package br.iesb.sie.entidade;

import br.iesb.sie.model.TipoPessoa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Entidade extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    @Column
    private String cpfCnpj;

    @Column
    private String nomeCompleto;

    @Column
    private String nomeCompletoPai;

    @Column
    private String nomeCompletoMae;

    @Column
    private String razaoSocial;

    @Column
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Column
    private String email;

    @Column
    private String senha;

    @JoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToMany(mappedBy = "entidade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Telefone> telefones = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "PerfilEntidade",
            joinColumns = {
                @JoinColumn(name = "entidade")},
            inverseJoinColumns = {
                @JoinColumn(name = "perfil")})
    private List<Perfil> perfis = new ArrayList<>();

    @Column
    private Integer login;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(List<Perfil> perfis) {
        this.perfis = perfis;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeCompletoPai() {
        return nomeCompletoPai;
    }

    public void setNomeCompletoPai(String nomeCompletoPai) {
        this.nomeCompletoPai = nomeCompletoPai;
    }

    public String getNomeCompletoMae() {
        return nomeCompletoMae;
    }

    public void setNomeCompletoMae(String nomeCompletoMae) {
        this.nomeCompletoMae = nomeCompletoMae;
    }

    public Integer getLogin() {
        return login;
    }

    public void setLogin(Integer login) {
        this.login = login;
    }

    public String getPrimeiroNome() {
        if (nomeCompleto != null) {
            return nomeCompleto.substring(0, nomeCompleto.indexOf(" "));
        }
        return null;
    }
}