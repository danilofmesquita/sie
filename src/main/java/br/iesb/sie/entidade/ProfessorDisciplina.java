package br.iesb.sie.entidade;

import br.iesb.sie.model.Disciplina;

import javax.persistence.*;

@Entity
public class ProfessorDisciplina extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated
    private Disciplina disciplina;

    @ManyToOne
    @JoinColumn
    private Turma turma;

    @ManyToOne
    @JoinColumn
    private Entidade professor;

    public ProfessorDisciplina() {
    }

    public ProfessorDisciplina(Turma turma) {
        this.turma = turma;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Entidade getProfessor() {
        return professor;
    }

    public void setProfessor(Entidade professor) {
        this.professor = professor;
    }
}
