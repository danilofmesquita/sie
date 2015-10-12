package br.iesb.sie.entity;

import br.iesb.sie.model.Bimestre;

import javax.persistence.*;

@Entity
@Table(name = "RELATORIO")
public class Relatorio extends BaseEntity {

    @Id
    @Column(name = "ID_RELATORIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FK_ENTIDADE_ESCOLA")
    private Entidade escola;

    @ManyToOne
    @JoinColumn(name = "FK_ENTIDADE_ALUNO")
    private Entidade aluno;

    @ManyToOne
    @JoinColumn(name = "FK_ENTIDADE_PROFESSOR")
    private Entidade professor;

    @ManyToOne
    @JoinColumn(name = "FK_TURMA")
    private Turma turma;

    @Column(name = "BIMESTRE")
    @Enumerated(EnumType.STRING)
    private Bimestre bimestre;

    @Column(name = "TEXTO")
    private String texto;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Entidade getEscola() {
        return escola;
    }

    public void setEscola(Entidade escola) {
        this.escola = escola;
    }

    public Entidade getAluno() {
        return aluno;
    }

    public void setAluno(Entidade aluno) {
        this.aluno = aluno;
    }

    public Entidade getProfessor() {
        return professor;
    }

    public void setProfessor(Entidade professor) {
        this.professor = professor;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Bimestre getBimestre() {
        return bimestre;
    }

    public void setBimestre(Bimestre bimestre) {
        this.bimestre = bimestre;
    }
}
