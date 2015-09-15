package br.iesb.sie.entity;

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
    private Turma turma;

    @OneToMany(mappedBy = "lancamento", cascade = CascadeType.ALL)
    private List<Frequencia> frequencias;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
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
}
