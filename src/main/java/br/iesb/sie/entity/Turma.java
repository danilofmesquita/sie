package br.iesb.sie.entity;

import br.iesb.sie.model.Serie;
import br.iesb.sie.model.Turno;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TURMA")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Turma extends BaseEntity {

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
}
