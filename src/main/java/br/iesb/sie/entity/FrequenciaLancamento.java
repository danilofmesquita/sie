package br.iesb.sie.entity;

import br.iesb.sie.model.Disciplina;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "FREQUENCIA_LANCAMENTO")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class FrequenciaLancamento extends BaseEntity {

    @Id
    @Column(name = "ID_FREQUENCIA_LANCAMENTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FK_ENTIDADE_ESCOLA")
    private Entidade escola;

    @ManyToOne
    @JoinColumn(name = "FK_TURMA")
    private Turma turma;

    @Column(name = "DISCIPLINA")
    @Enumerated(EnumType.STRING)
    private Disciplina disciplina;

    @OneToMany(mappedBy = "lancamento", cascade = CascadeType.ALL)
    private List<Frequencia> frequencias;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_LANCAMENTO")
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
