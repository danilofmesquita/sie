package br.iesb.sie.controller;

import br.iesb.sie.bean.UsuarioLogado;
import br.iesb.sie.entidade.Funcionario;
import br.iesb.sie.jsf.Paginator;
import br.iesb.sie.jsf.PaginatorFilter;
import br.iesb.sie.service.FuncionarioService;
import br.iesb.sie.util.Attributes;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class ListarFuncionariosController extends BaseController {

    @Inject
    private FuncionarioService funcionarioService;

    @Inject
    private UsuarioLogado usuarioLogado;

    private List<Funcionario> funcionarios;

    private String nomeFuncionario;

    private String nomeEscola;

    boolean escola;

    @PostConstruct
    public void init(){
        if(usuarioLogado.isEscola()){
            escola = true;
            nomeEscola = usuarioLogado.getEntidade().getNomeCompleto();
            funcionarios = funcionarioService.buscarFuncionarios(usuarioLogado.getEntidade());
        }
    }

    public String editar(Funcionario funcionario){
        putFlashAttribute(Attributes.ID, funcionario.getId());
        return "incluir.xhtml?faces-redirect=true";
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

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
