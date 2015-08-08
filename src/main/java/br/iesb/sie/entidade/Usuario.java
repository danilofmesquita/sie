package br.iesb.sie.entidade;

import br.iesb.sie.model.TipoPessoa;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Entity
public class Usuario {

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

    @Past
    @Column
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Column
    private String email;

    @Column
    private String senha;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Endereco endereco;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Telefone> telefones = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "PerfilUsuario",
            joinColumns = {@JoinColumn(name = "usuario")},
            inverseJoinColumns = {@JoinColumn(name = "perfil")})
    private List<Perfil> perfis;

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
        try {
            MessageDigest ms = MessageDigest.getInstance("SHA-512");
            byte[] digest = ms.digest(senha.getBytes(Charset.forName("UTF-8")));
            this.senha = Base64.getEncoder().encodeToString(digest);
        } catch (NoSuchAlgorithmException e) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, e.getMessage());
        }
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
}
