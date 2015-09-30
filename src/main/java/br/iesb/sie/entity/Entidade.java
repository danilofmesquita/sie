package br.iesb.sie.entity;

import br.iesb.sie.model.Perfil;
import br.iesb.sie.model.TipoPessoa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ENTIDADE")
public class Entidade extends BaseEntity {

    @Id
    @Column(name = "ID_ENTIDADE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TIPO_PESSOA")
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    @Column(name = "CPF_CNPJ")
    private String cpfCnpj;

    @Column(name = "NOME_COMPLETO")
    private String nomeCompleto;

    @Column(name = "NOME_COMPLETO_PAI")
    private String nomeCompletoPai;

    @Column(name = "NOME_COMPLETO_MAE")
    private String nomeCompletoMae;

    @Column(name = "RAZAO_SOCIAL")
    private String razaoSocial;

    @Column(name = "DATA_NASCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SENHA")
    private String senha;

    @JoinColumn(name = "FK_ENDERECO")
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToMany(mappedBy = "entidade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Telefone> telefones = new ArrayList<>();

    @Column(name = "NOME_PERFIL")
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Perfil.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "PEFIL_ENTIDADE",
            joinColumns = @JoinColumn(name = "FK_ENTIDADE"))
    private List<Perfil> perfis = new ArrayList<>();

    @Column(name = "LOGIN")
    private Integer login;

    @OneToMany(mappedBy = "escola")
    private List<Funcionario> funcionarios = new ArrayList<>();

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

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpf) {
        this.cpfCnpj = cpf;
    }

    public String getPrimeiroNome() {
        if (nomeCompleto != null) {
            if (nomeCompleto.contains(" ")) {
                return nomeCompleto.substring(0, nomeCompleto.indexOf(" "));
            } else {
                return nomeCompleto;
            }
        } else if (razaoSocial != null) {
            if (razaoSocial.contains(" ")) {
                return razaoSocial.substring(0, razaoSocial.indexOf(" "));
            } else {
                return razaoSocial;
            }
        }

        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entidade entidade = (Entidade) o;
        return Objects.equals(id, entidade.id) &&
                Objects.equals(tipoPessoa, entidade.tipoPessoa) &&
                Objects.equals(cpfCnpj, entidade.cpfCnpj) &&
                Objects.equals(email, entidade.email) &&
                Objects.equals(senha, entidade.senha) &&
                Objects.equals(login, entidade.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipoPessoa, cpfCnpj, email, senha, login);
    }
}
