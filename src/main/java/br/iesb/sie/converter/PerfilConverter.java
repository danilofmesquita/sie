package br.iesb.sie.converter;

import br.iesb.sie.model.Perfil;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("br.sie.perfilConverter")
public class PerfilConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null || s.equals("Selecione")) {
            return null;
        }
        return uiComponent.getAttributes().get(s);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o == null) {
            return null;
        }
        uiComponent.getAttributes().put(((Perfil) o).getNomeMF() , o);
        return ((Perfil) o).getNomeMF();
    }
}
