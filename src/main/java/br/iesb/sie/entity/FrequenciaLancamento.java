package br.iesb.sie.entity;

import br.iesb.sie.model.Disciplina;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class FrequenciaLancamento extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn
    @ManyToOne
    private Entidade escola;

    @JoinColumn
    @ManyToOne
    private Turma turma;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private Disciplina disciplina;

    @OneToMany(mappedBy = "lancamento", cascade = CascadeType.ALL)
    private List<Frequencia> frequencias;

    @Column
    @Temporal(TemporalType.DATE)
    private Date dataLancamento;

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

    public List<Frequencia> getFrequencias() {
        return frequencias;
    }

    public void setFrequencias(List<Frequencia> frequencias) {
        this.frequencias = frequencias;
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
