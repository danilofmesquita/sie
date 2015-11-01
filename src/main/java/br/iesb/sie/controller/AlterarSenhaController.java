package br.iesb.sie.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.iesb.sie.bean.UsuarioLogado;
import br.iesb.sie.service.EntidadeService;

@Named
@ViewScoped
public class AlterarSenhaController extends BaseController {

    /**
     * 
     */
    private static final long serialVersionUID = 1801248198797724561L;

    @Inject
    private EntidadeService entidadeService;

    @Inject
    private UsuarioLogado usuarioLogado;

    private String senhaAnterior;

    private String novaSenha;

    public void salvar() {
        Integer status = entidadeService.atualizarSenha(usuarioLogado.getEntidade(), senhaAnterior, novaSenha);
        if (status > 0) {
            addInfoMessage("Senha atualizada com sucesso.");
        } else {
            addErrorMessage("Senha atual está incorreta.");
        }
    }

    public String getSenhaAnterior() {
        return senhaAnterior;
    }

    public void setSenhaAnterior(String senhaAnterior) {
        this.senhaAnterior = senhaAnterior;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }
}
