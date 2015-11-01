package br.iesb.sie.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;

import br.iesb.sie.model.Perfil;

@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario extends BaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 6001316206032963693L;

    @Id
    @Column(name = "ID_FUNCIONARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FK_ENTIDADE_FUNCIONARIO")
    private Entidade funcionario;

    @ManyToOne
    @JoinColumn(name = "FK_ENTIDADE_ESCOLA")
    private Entidade escola;

    @Column(name = "VINCULO_ATIVO")
    private boolean vinculoAtivo;

    @Column(name = "DATA_VINCULO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataVinculo;

    @Column(name = "PERFIL")
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
