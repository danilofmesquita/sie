package br.iesb.sie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "NOTA")
public class Nota extends BaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = -6961675493946660836L;

    @Id
    @Column(name = "ID_NOTA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOTA")
    private Double nota;

    @ManyToOne
    @JoinColumn(name = "FK_NOTA_LANCAMENTO")
    private NotaLancamento lancamento;

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

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
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
