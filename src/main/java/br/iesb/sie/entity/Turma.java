package br.iesb.sie.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.iesb.sie.model.Serie;
import br.iesb.sie.model.Turno;

@Entity
@Table(name = "TURMA")
public class Turma extends BaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 7892483435754047194L;

    @Id
    @Column(name = "ID_TURMA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SERIE")
    @Enumerated(EnumType.STRING)
    private Serie serie;

    @Column(name = "NOME")
    private String nome;

    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProfessorDisciplina> professorDisciplinas = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "FK_ENTIDADE_ESCOLA")
    private Entidade escola;

    @Column(name = "TURNO")
    @Enumerated(EnumType.STRING)
    private Turno turno;

    @Column(name = "ANO")
    private Integer ano;

    @OneToMany(mappedBy = "turma")
    private List<Matricula> matriculas;

    @OneToMany(mappedBy = "turma")
    private List<FrequenciaLancamento> frequenciaLancamentos;

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

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        String formato = "%s \"%s\" %s de %d";
        return String.format(formato, serie.getDescricao(), nome, turno.getDescricao(), ano);
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public List<FrequenciaLancamento> getFrequenciaLancamentos() {
        return frequenciaLancamentos;
    }

    public void setFrequenciaLancamentos(List<FrequenciaLancamento> frequenciaLancamentos) {
        this.frequenciaLancamentos = frequenciaLancamentos;
    }
}
