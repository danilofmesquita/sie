package br.iesb.sie.controller;

import br.iesb.sie.bean.UsuarioLogado;
import br.iesb.sie.entidade.Entidade;
import br.iesb.sie.entidade.Funcionario;
import br.iesb.sie.service.EntidadeService;
import br.iesb.sie.service.FuncionarioService;
import br.iesb.sie.util.Attributes;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collections;
import java.util.List;

@Named
@ViewScoped
public class ListarFuncionariosController extends BaseController {

    @Inject
    private FuncionarioService funcionarioService;

    @Inject
    private UsuarioLogado usuarioLogado;

    @Inject
    private EntidadeService entidadeService;

    private List<Funcionario> funcionarios;

    boolean escola;

    private Funcionario filtro;

    @PostConstruct
    public void init() {
        filtro = new Funcionario();
        if (usuarioLogado.isEscola()) {
            escola = true;
            filtro.setEscola(usuarioLogado.getEntidade());
            filtrar();
        }
    }

    public String editar(Funcionario funcionario) {
        putFlashAttribute(Attributes.ID, funcionario.getId());
        return "incluir.xhtml?faces-redirect=true";
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

    public List<Entidade> buscarPessoasPorPerfil() {
        if (filtro.getPerfil() != null) {
            return entidadeService.buscarEntidadesPorPerfil(filtro.getPerfil());
        } else {
            return Collections.emptyList();
        }
    }

    public void filtrar(){
        funcionarios = funcionarioService.buscarFuncionarios(filtro);
    }

    public Funcionario getFiltro() {
        return filtro;
    }

    public void setFiltro(Funcionario filtro) {
        this.filtro = filtro;
    }
}
