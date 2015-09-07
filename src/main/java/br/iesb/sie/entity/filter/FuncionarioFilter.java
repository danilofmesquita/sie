package br.iesb.sie.entity.filter;

import br.iesb.sie.entity.Entidade;
import br.iesb.sie.jsf.PaginatorFilter;

import java.util.Date;

public class FuncionarioFilter implements PaginatorFilter {

    private Entidade escola;
    private Entidade funcionario;
    private boolean vinculoAtivo;
    private Date dataVinculo;

    public FuncionarioFilter() {
    }

    public FuncionarioFilter(Entidade escola, Entidade funcionario) {
        this.escola = escola;
        this.funcionario = funcionario;
    }

    public Entidade getEscola() {
        return escola;
    }

    public void setEscola(Entidade escola) {
        this.escola = escola;
    }

    public Entidade getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Entidade funcionario) {
        this.funcionario = funcionario;
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

}
