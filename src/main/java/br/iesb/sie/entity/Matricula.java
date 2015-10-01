package br.iesb.sie.entity;

import br.iesb.sie.model.Parentesco;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "MATRICULA")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Matricula extends BaseEntity {

    @Id
    @Column(name = "ID_MATRICULA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FK_ENTIDADE_ALUNO")
    private Entidade aluno;

    @ManyToOne
    @JoinColumn(name = "FK_ENTIDADE_ESCOLA")
    private Entidade escola;

    @ManyToOne
    @JoinColumn(name = "FK_TURMA")
    private Turma turma;

    @Column(name = "NOME_RESPONSAVEL")
    private String nomeResponsavel;

    @Column(name = "CPF_RESPONSAVEL")
    private String cpfResponsavel;

    @JoinColumn(name = "FK_ENDERECO_RESPONSAVEL")
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco enderecoResponsavel;

    @Column(name = "PARENTESCO_RESPONSAVEL")
    @Enumerated(EnumType.STRING)
    private Parentesco parentescoResponsavel;

    @Column(name = "TELEFONE_RESPONSAVEL")
    private Long telefoneResponsavel;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Entidade getAluno() {
        return aluno;
    }

    public void setAluno(Entidade aluno) {
        this.aluno = aluno;
    }

    public Entidade getEscola() {
        return escola;
    }

    public void setEscola(Entidade escola) {
        this.escola = escola;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getCpfResponsavel() {
        return cpfResponsavel;
    }

    public void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
    }

    public Endereco getEnderecoResponsavel() {
        return enderecoResponsavel;
    }

    public void setEnderecoResponsavel(Endereco enderecoResponsavel) {
        this.enderecoResponsavel = enderecoResponsavel;
    }

    public Parentesco getParentescoResponsavel() {
        return parentescoResponsavel;
    }

    public void setParentescoResponsavel(Parentesco parentescoResponsavel) {
        this.parentescoResponsavel = parentescoResponsavel;
    }

    public Long getTelefoneResponsavel() {
        return telefoneResponsavel;
    }

    public void setTelefoneResponsavel(Long telefoneResponsavel) {
        this.telefoneResponsavel = telefoneResponsavel;
    }
}
