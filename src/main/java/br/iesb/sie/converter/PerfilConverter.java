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
        return uiComponent.getAttributes().get("perfil");
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        uiComponent.getAttributes().put("perfil", o);
        return ((Perfil) o).getNomeMF();
    }
}
