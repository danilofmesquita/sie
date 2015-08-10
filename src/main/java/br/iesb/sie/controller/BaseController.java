package br.iesb.sie.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;


public class BaseController implements Serializable {

    protected FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    protected void addInfoMessage(String message) {
        getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
    }

    protected void addErrorMessage(String message) {
        getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }
}
