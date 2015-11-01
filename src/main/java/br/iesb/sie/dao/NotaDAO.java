package br.iesb.sie.dao;

import javax.inject.Named;

import br.iesb.sie.entity.Nota;

@Named
public class NotaDAO extends BaseDAO<Nota, Long> {

    public NotaDAO() {
        super(Nota.class);
    }
}
