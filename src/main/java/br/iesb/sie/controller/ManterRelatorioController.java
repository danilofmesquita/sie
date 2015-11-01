package br.iesb.sie.controller;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.iesb.sie.util.Attributes;

@Named
@ViewScoped
public class ManterRelatorioController extends RelatorioController {

    /**
     * 
     */
    private static final long serialVersionUID = -8454139740462197050L;

    @Override
    @PostConstruct
    public void init() {
        super.init();
        Long id = getFlashAttribute(Attributes.ID);
        if (id != null) {
            setRelatorio(relatorioService.buscarRelatorio(id));
        }
    }

    public void salvar() {
        relatorioService.salvar(getRelatorio());
        addInfoMessage("Dados salvos com sucesso!");
    }

}
