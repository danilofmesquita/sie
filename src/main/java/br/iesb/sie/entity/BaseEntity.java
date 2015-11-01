package br.iesb.sie.entity;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 4753521334736571769L;

    public abstract Serializable getId();

    @Override
    public boolean equals(Object obj) {
        BaseEntity be = (BaseEntity) obj;
        if (getId() != null) {
            return getId().equals(be.getId());
        } else {
            return super.equals(be);
        }
    }

    @Override
    public int hashCode() {
        if (getId() != null) {
            return getId().hashCode();
        } else {
            return super.hashCode();
        }
    }
}
