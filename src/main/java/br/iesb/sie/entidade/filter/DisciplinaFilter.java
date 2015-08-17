package br.iesb.sie.entidade.filter;

import br.iesb.sie.jsf.PaginatorFilter;
import java.util.Date;

public class DisciplinaFilter implements PaginatorFilter {

    private String nome;
    private Date dataInclusao;

    public DisciplinaFilter(String nome) {
        this.nome = nome;
    }

    public DisciplinaFilter(String nome, Date dataInclusao) {
        this.nome = nome;
        this.dataInclusao = dataInclusao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

}
