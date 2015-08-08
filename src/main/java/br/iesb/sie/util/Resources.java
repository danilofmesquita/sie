package br.iesb.sie.util;


import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Logger;

public class Resources {

    @Produces
    @PersistenceContext
    private EntityManager em;


    @Produces
    private Logger logger(InjectionPoint ip){
        return Logger.getLogger(ip.getMember().getDeclaringClass().getName());
    }

    @Produces
    private FacesContext facesContext() {
        return FacesContext.getCurrentInstance();
    }

}
