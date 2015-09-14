package br.iesb.sie.entity;

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
    private Turma turma;

    @OneToMany(mappedBy = "lancamento")
    private List<Nota> notas;

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
}
