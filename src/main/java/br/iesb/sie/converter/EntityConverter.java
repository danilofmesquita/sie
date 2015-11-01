package br.iesb.sie.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.iesb.sie.entity.BaseEntity;

@FacesConverter("sie.converter.entity")
public class EntityConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
            return component.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null && value instanceof BaseEntity) {
            BaseEntity be = (BaseEntity) value;
            component.getAttributes().put(String.valueOf(be.getId()), be);
            return String.valueOf(be.getId());
        }

        return String.valueOf(value);

    }
}