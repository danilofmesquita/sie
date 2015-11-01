package br.iesb.sie.dao;

import javax.inject.Named;

import br.iesb.sie.entity.ProfessorDisciplina;

@Named
public class ProfessorDisciplinaDAO extends BaseDAO<ProfessorDisciplina, Long> {

    public ProfessorDisciplinaDAO() {
        super(ProfessorDisciplina.class);
    }
}
