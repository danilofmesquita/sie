package br.iesb.sie.controller;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.iesb.sie.entity.Endereco;
import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.Telefone;
import br.iesb.sie.service.CEPService;
import br.iesb.sie.service.EntidadeService;
import br.iesb.sie.util.NavigationRules;

@Named
@ViewScoped
public class CadastroController extends BaseController {

    /**
     * 
     */
    private static final long serialVersionUID = 8565729650757035391L;

    @Inject
    private EntidadeService entidadeService;

    @Inject
    private CEPService cepService;

    private Entidade entidade;

    @PostConstruct
    public void init() {
        entidade = new Entidade();
        entidade.setEndereco(new Endereco());
        entidade.setTelefones(new ArrayList<>());
        entidade.getTelefones().add(new Telefone());
        entidade.getTelefones().add(new Telefone());
        adicionarTelefone();
    }

    public void carregarEnderecoPorCEP() {
        entidade.setEndereco(cepService.buscarEnderecoPorCEP(entidade.getEndereco().getCep()));
    }

    public void adicionarTelefone() {
        entidade.getTelefones().add(new Telefone());
    }

    public String salvar() {
        entidadeService.criarNovoUsuaro(entidade);
        return NavigationRules.CADASTRO_CONCLUIDO;
    }

    public void limpar() {
        init();
    }

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }
}
