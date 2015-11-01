package br.iesb.sie.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class BaseController implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 450687208376152404L;

    protected FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    protected void addInfoMessage(String message) {
        getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
    }

    protected void addErrorMessage(String message) {
        getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }

    @SuppressWarnings("unchecked")
    protected <T> T getFlashAttribute(String flashAttributeName) {
        return (T) getFacesContext().getExternalContext().getFlash().get(flashAttributeName);
    }

    protected void putFlashAttribute(String flashAttributeName, Object o) {
        getFacesContext().getExternalContext().getFlash().put(flashAttributeName, o);
    }

}
