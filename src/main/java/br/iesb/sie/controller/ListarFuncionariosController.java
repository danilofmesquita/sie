package br.iesb.sie.controller;

import br.iesb.sie.bean.UsuarioLogado;
import br.iesb.sie.entidade.Funcionario;
import br.iesb.sie.jsf.Paginator;
import br.iesb.sie.jsf.PaginatorFilter;
import br.iesb.sie.service.FuncionarioService;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class ListarFuncionariosController extends BaseController implements Paginator<Funcionario> {

    @Inject
    private FuncionarioService funcionarioService;

    @Inject
    private UsuarioLogado usuarioLogado;

    private String nomeFuncionario;

    private String nomeEscola;

    boolean escola;

    @PostConstruct
    public void init(){
        if(usuarioLogado.isEscola()){
            escola = true;
            nomeEscola = usuarioLogado.getEntidade().getNomeCompleto();
        }
    }

    @Override
    public Integer contarRegistros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Funcionario> consultarRegistros(int first, int pageSize, PaginatorFilter filter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNomeEscola() {
        return nomeEscola;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeEscola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public boolean isEscola() {
        return escola;
    }
}
