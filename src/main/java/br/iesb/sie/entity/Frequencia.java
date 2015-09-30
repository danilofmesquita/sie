package br.iesb.sie.entity;


import br.iesb.sie.model.Disciplina;

import javax.persistence.*;

@Entity
@Table(name = "FREQUENCIA")
public class Frequencia extends BaseEntity {

    @Id
    @Column(name = "ID_FREQUENCIA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PRESENTE")
    private boolean presente;

    @ManyToOne
    @JoinColumn(name = "FK_FREQUENCIA_LANCAMENTO")
    private FrequenciaLancamento lancamento;

    @ManyToOne
    @JoinColumn(name = "FK_ENTIDADE_ALUNO")
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
