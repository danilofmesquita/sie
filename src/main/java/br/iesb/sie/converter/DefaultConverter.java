package br.iesb.sie.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value = "sie.converter.default")
public class DefaultConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        return uiComponent.getAttributes().get(value);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value == null) {
            return null;
        }
        String hash = String.valueOf(value.hashCode());
        uiComponent.getAttributes().put(hash, value);
        return hash;
    }
}
