package br.iesb.sie.service;

import br.iesb.sie.dao.MatriculaDAO;
import br.iesb.sie.entity.Matricula;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class MatriculaService {

    @Inject
    private MatriculaDAO matriculaDAO;

    public void salvar(Matricula matricula) {
        matriculaDAO.salvar(matricula);
    }
}
