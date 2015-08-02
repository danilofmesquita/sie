package br.iesb.sie.controller;

import br.iesb.sie.service.CEPService;
import br.iesb.sie.service.CadastroService;
import br.iesb.sie.entidade.Endereco;
import br.iesb.sie.entidade.Telefone;
import br.iesb.sie.entidade.Usuario;
import br.iesb.sie.util.NavigationRules;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;

@Named
@ViewScoped
public class CadastroController implements Serializable {

    @Inject
    private CadastroService cadastroService;

    @Inject
    private CEPService cepService;

    private Usuario usuario;

    @PostConstruct
    private void init() {
        usuario = new Usuario();
        usuario.setEndereco(new Endereco());
        usuario.setTelefones(new ArrayList<>());
        adicionarTelefone();
    }

    public void carregarEnderecoPorCEP(){
        usuario.setEndereco(cepService.buscarEnderecoPorCEP(usuario.getEndereco().getCep()));
    }

    public void adicionarTelefone() {
        usuario.getTelefones().add(new Telefone());
    }

    public String salvar() {
        cadastroService.criarNovoUsuaro(usuario);
        return NavigationRules.CADASTRO_CONCLUIDO;
    }

    public void limpar(){
        init();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
