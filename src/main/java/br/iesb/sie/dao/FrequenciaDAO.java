package br.iesb.sie.dao;

import javax.inject.Named;

import br.iesb.sie.entity.Frequencia;

@Named
public class FrequenciaDAO extends BaseDAO<Frequencia, Long> {

    public FrequenciaDAO() {
        super(Frequencia.class);
    }
}
