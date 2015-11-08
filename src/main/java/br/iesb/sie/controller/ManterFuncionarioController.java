package br.iesb.sie.controller;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.iesb.sie.bean.UsuarioLogado;
import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.Funcionario;
import br.iesb.sie.service.EntidadeService;
import br.iesb.sie.service.FuncionarioService;
import br.iesb.sie.util.Attributes;

@Named
@ViewScoped
public class ManterFuncionarioController extends BaseController {

    /**
     *
     */
    private static final long serialVersionUID = -1748037368764476859L;

    @Inject
    private UsuarioLogado usuarioLogado;

    @Inject
    private FuncionarioService funcionarioService;

    @Inject
    private EntidadeService entidadeService;

    private Funcionario funcionario;

    @PostConstruct
    public void init() {
        Long id = getFlashAttribute(Attributes.ID);
        if (id == null) {
            funcionario = new Funcionario();
            if (usuarioLogado.isEscola()) {
                funcionario.setEscola(usuarioLogado.getEntidade());
            }
            funcionario.setVinculoAtivo(true);
        } else {
            funcionario = funcionarioService.buscarFuncionario(id);
        }
    }

    public String salvar() {
        funcionarioService.salvar(funcionario);
        addInfoMessage("Dados salvos com sucesso!");
        return "listar.xhtml?faces-redirect=true";
    }

    public List<Entidade> buscarPessoasPorPerfil() {
        if (funcionario.getPerfil() != null) {
            return entidadeService.buscarEntidadesPorPerfil(funcionario.getPerfil());
        } else {
            return Collections.emptyList();
        }
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}