package br.iesb.sie.controller;

import br.iesb.sie.util.Attributes;

public abstract class ListarController extends BaseController {

    public abstract void filtrar();

    public String editar(Long id) {
        putFlashAttribute(Attributes.ID, id);
        return "incluir.xhtml?faces-redirect=true";
    }

}
