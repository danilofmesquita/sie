package br.iesb.sie.entity;

import br.iesb.sie.model.Bimestre;
import br.iesb.sie.model.Disciplina;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "NOTA_LANCAMENTO")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class NotaLancamento extends BaseEntity {

    @Id
    @Column(name = "ID_NOTA_LANCAMENTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FK_ENTIDADE_ESCOLA")
    private Entidade escola;

    @ManyToOne
    @JoinColumn(name = "FK_ENTIDADE_TURMA")
    private Turma turma;

    @OneToMany(mappedBy = "lancamento", cascade = CascadeType.ALL)
    private List<Nota> notas;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_LANCAMENTO")
    private Date dataLancamento;

    @Column(name = "DISCIPLINA")
    @Enumerated(EnumType.ORDINAL)
    private Disciplina disciplina;

    @Column(name = "BIMESTRE")
    @Enumerated(EnumType.STRING)
    private Bimestre bimestre;

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

    public Bimestre getBimestre() {
        return bimestre;
    }

    public void setBimestre(Bimestre bimestre) {
        this.bimestre = bimestre;
    }
}
