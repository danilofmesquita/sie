package br.iesb.sie.dao;


import br.iesb.sie.entity.Nota;

import javax.inject.Named;

@Named
public class NotaDAO extends BaseDAO<Nota, Long> {

    public NotaDAO() {
        super(Nota.class);
    }
}
