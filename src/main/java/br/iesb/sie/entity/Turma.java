package br.iesb.sie.entity;

import br.iesb.sie.model.Serie;
import br.iesb.sie.model.Turno;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Turma extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated
    private Serie serie;

    @Column
    private String nome;

    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProfessorDisciplina> professorDisciplinas = new ArrayList<>();

    @Column
    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @Column
    @Temporal(TemporalType.DATE)
    private Date dataFim;

    @ManyToOne
    @JoinColumn
    private Entidade escola;

    @Column
    @Enumerated
    private Turno turno;

    public Turma() {
    }

    public Turma(Entidade escola) {
        this.escola = escola;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProfessorDisciplina> getProfessorDisciplinas() {
        return professorDisciplinas;
    }

    public void setProfessorDisciplinas(List<ProfessorDisciplina> professorDisciplinas) {
        this.professorDisciplinas = professorDisciplinas;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Entidade getEscola() {
        return escola;
    }

    public void setEscola(Entidade escola) {
        this.escola = escola;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
}
