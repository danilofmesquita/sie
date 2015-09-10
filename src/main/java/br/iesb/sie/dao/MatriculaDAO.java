package br.iesb.sie.dao;


import br.iesb.sie.entity.Matricula;

import javax.inject.Named;

@Named
public class MatriculaDAO extends BaseDAO<Matricula, Long> {

    public MatriculaDAO() {
        super(Matricula.class);
    }
}
