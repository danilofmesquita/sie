package br.iesb.sie.controller;

import br.iesb.sie.util.Attributes;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ManterRelatorioController extends RelatorioController {

    @Override
    @PostConstruct
    public void init() {
        super.init();
        Long id = getFlashAttribute(Attributes.ID);
        if (id != null) {
            setRelatorio(relatorioService.buscarRelatorio(id));
        }
    }

    public void salvar(){
        relatorioService.salvar(getRelatorio());
    }

}
