package br.iesb.sie.entity;

import br.iesb.sie.model.Parentesco;

import javax.persistence.*;

@Entity
public class Matricula extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Entidade aluno;

    @ManyToOne
    @JoinColumn
    private Entidade escola;

    @ManyToOne
    @JoinColumn
    private Turma turma;

    @Column
    private String nomeResponsavel;

    @Column
    private String cpfResponsavel;

    @JoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco enderecoResponsavel;

    @Column
    @Enumerated(EnumType.STRING)
    private Parentesco parentescoResponsavel;

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
}
