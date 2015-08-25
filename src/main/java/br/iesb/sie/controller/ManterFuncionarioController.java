package br.iesb.sie.controller;

import br.iesb.sie.bean.UsuarioLogado;
import br.iesb.sie.entidade.Entidade;
import br.iesb.sie.entidade.Funcionario;
import br.iesb.sie.model.Perfil;
import br.iesb.sie.service.FuncionarioService;
import br.iesb.sie.util.Attributes;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class ManterFuncionarioController extends BaseController {

    @Inject
    private UsuarioLogado usuarioLogado;

    @Inject
    private FuncionarioService funcionarioService;

    private List<Entidade> funcionarios;

    private List<Entidade> escolas;

    private Funcionario funcionario;

    @PostConstruct
    public void init() {
        funcionarios = funcionarioService.buscarFuncionarios();
        escolas = funcionarioService.buscarEscolas();
        Long id = getFlashAttribute(Attributes.ID);

        if (id == null) {
            funcionario = new Funcionario();
            if (usuarioLogado.isEscola()) {
                funcionario.setEscola(usuarioLogado.getEntidade());
            }
        } else {
            funcionario = funcionarioService.buscarFuncionario(id);
        }

    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Entidade> getEscolas() {
        return escolas;
    }

    public void setEscolas(List<Entidade> escolas) {
        this.escolas = escolas;
    }

    public List<Entidade> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Entidade> funcionarios) {
        this.funcionarios = funcionarios;
    }
}