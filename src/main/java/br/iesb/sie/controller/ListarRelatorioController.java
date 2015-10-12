package br.iesb.sie.controller;

import br.iesb.sie.bean.UsuarioLogado;
import br.iesb.sie.entity.Relatorio;
import br.iesb.sie.util.Attributes;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class ListarRelatorioController extends RelatorioController {

    @Inject
    private UsuarioLogado usuarioLogado;

    private List<Relatorio> relatorios;

    @Override
    @PostConstruct
    public void init() {
        super.init();
        filtrar();
    }

    public void filtrar() {
        relatorios = relatorioService.buscarRelatorios(getRelatorio(), usuarioLogado.getEscolasVinculadas());
    }

    public List<Relatorio> getRelatorios() {
        return relatorios;
    }

    public void setRelatorios(List<Relatorio> relatorios) {
        this.relatorios = relatorios;
    }

    public void limpar() {
        setRelatorio(new Relatorio());
    }

    public String editar(Long id){
        putFlashAttribute(Attributes.ID, id);
        return "incluir.xhtml?faces-redirect=true";
    }
}
