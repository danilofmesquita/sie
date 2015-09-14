package br.iesb.sie.dao;

import br.iesb.sie.entity.Frequencia;

import javax.inject.Named;

@Named
public class FrequenciaDAO extends BaseDAO<Frequencia, Long> {

    public FrequenciaDAO() {
        super(Frequencia.class);
    }
}
