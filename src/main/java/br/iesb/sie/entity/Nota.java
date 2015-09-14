package br.iesb.sie.entity;

import javax.persistence.*;

@Entity
public class Nota extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer nota;

    @JoinColumn
    @ManyToOne
    private NotaLancamento lancamento;

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

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public NotaLancamento getLancamento() {
        return lancamento;
    }

    public void setLancamento(NotaLancamento lancamento) {
        this.lancamento = lancamento;
    }

    public Entidade getAluno() {
        return aluno;
    }

    public void setAluno(Entidade aluno) {
        this.aluno = aluno;
    }
}
