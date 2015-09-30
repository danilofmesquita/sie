package br.iesb.sie.dao;

import br.iesb.sie.entity.ProfessorDisciplina;

import javax.inject.Named;

@Named
public class ProfessorDisciplinaDAO extends BaseDAO<ProfessorDisciplina, Long> {

    public ProfessorDisciplinaDAO() {
        super(ProfessorDisciplina.class);
    }
}
