package br.iesb.sie.controller;

import br.iesb.sie.bean.EntidadeLogadaController;
import br.iesb.sie.service.EntidadeService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class AlterarSenhaController extends BaseController {

    @Inject
    private EntidadeService entidadeService;

    @Inject
    private EntidadeLogadaController entidadeLogadaController;

    private String senhaAnterior;

    private String novaSenha;

    public void salvar() {
        Integer status = entidadeService.atualizarSenha(entidadeLogadaController.getEntidade(), senhaAnterior, novaSenha);
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
