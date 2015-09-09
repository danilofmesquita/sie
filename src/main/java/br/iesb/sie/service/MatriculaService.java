package br.iesb.sie.service;

import br.iesb.sie.dao.MatriculaDAO;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class MatriculaService {

    @Inject
    private MatriculaDAO matriculaDAO;
}
