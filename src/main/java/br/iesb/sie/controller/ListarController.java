package br.iesb.sie.controller;

import br.iesb.sie.util.Attributes;

public abstract class ListarController extends BaseController {

    /**
     * 
     */
    private static final long serialVersionUID = -8395387603402127343L;

    public abstract void filtrar();

    public abstract void limpar();

    public String editar(Long id) {
        putFlashAttribute(Attributes.ID, id);
        return "incluir.xhtml?faces-redirect=true";
    }

}
