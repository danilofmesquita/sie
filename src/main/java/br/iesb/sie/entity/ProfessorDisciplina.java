package br.iesb.sie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.iesb.sie.model.Disciplina;

@Entity
@Table(name = "PROFESSOR_DISCIPLINA")
public class ProfessorDisciplina extends BaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = -3747490794736066029L;

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
