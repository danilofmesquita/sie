package br.iesb.sie.entity;


import javax.persistence.*;

@Entity
public class Frequencia extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean presente;

    @JoinColumn
    @ManyToOne
    private FrequenciaLancamento lancamento;

    @JoinColumn
    @ManyToOne
    private Entidade aluno;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }

    public FrequenciaLancamento getLancamento() {
        return lancamento;
    }

    public void setLancamento(FrequenciaLancamento lancamento) {
        this.lancamento = lancamento;
    }

    public Entidade getAluno() {
        return aluno;
    }

    public void setAluno(Entidade aluno) {
        this.aluno = aluno;
    }
}
