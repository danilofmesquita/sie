package br.iesb.sie.entity;

import br.iesb.sie.model.Disciplina;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class NotaLancamento extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn
    @ManyToOne
    private Entidade escola;

    @JoinColumn
    @ManyToOne
    private Turma turma;

    @OneToMany(mappedBy = "lancamento", cascade = CascadeType.ALL)
    private List<Nota> notas;

    @Column
    @Temporal(TemporalType.DATE)
    private Date dataLancamento;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private Disciplina disciplina;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Entidade getEscola() {
        return escola;
    }

    public void setEscola(Entidade escola) {
        this.escola = escola;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
