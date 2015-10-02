package br.iesb.sie.entity;

import br.iesb.sie.model.Disciplina;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "PROFESSOR_DISCIPLINA")
public class ProfessorDisciplina extends BaseEntity {

    @Id
    @Column(name = "ID_PROFESSOR_DISCIPLINA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DISCIPLINA")
    @Enumerated(EnumType.STRING)
    private Disciplina disciplina;

    @ManyToOne
    @JoinColumn(name = "FK_TURMA")
    private Turma turma;

    @ManyToOne
    @JoinColumn(name = "FK_ENTIDADE_PROFESSOR")
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
