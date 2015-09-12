package br.iesb.sie.service;

import br.iesb.sie.dao.MatriculaDAO;
import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.Matricula;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class MatriculaService {

    @Inject
    private MatriculaDAO matriculaDAO;


    public void salvar(Matricula matricula) {
        matriculaDAO.salvar(matricula);
    }

    public List<Matricula> buscarMatriculas(Matricula filtro, List<Entidade> escolasVinculadas) {
        return matriculaDAO.buscarMatriculas(filtro, escolasVinculadas);
    }

    public Matricula buscarMatricula(Long id) {
        return matriculaDAO.get(id);
    }
}
