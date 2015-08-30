package br.iesb.sie.entidade;

import br.iesb.sie.model.Perfil;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Funcionario extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Entidade funcionario;

    @ManyToOne
    @JoinColumn
    private Entidade escola;

    @Column
    private boolean vinculoAtivo;

    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataVinculo;

    @Column
    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    @PrePersist
    public void prePersist() {
        if (dataVinculo == null) {
            dataVinculo = new Date();
        }
    }

    public Entidade getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Entidade funcionario) {
        this.funcionario = funcionario;
    }

    public Entidade getEscola() {
        return escola;
    }

    public void setEscola(Entidade escola) {
        this.escola = escola;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isVinculoAtivo() {
        return vinculoAtivo;
    }

    public void setVinculoAtivo(boolean vinculoAtivo) {
        this.vinculoAtivo = vinculoAtivo;
    }

    public Date getDataVinculo() {
        return dataVinculo;
    }

    public void setDataVinculo(Date dataVinculo) {
        this.dataVinculo = dataVinculo;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
