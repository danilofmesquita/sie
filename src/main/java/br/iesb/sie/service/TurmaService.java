package br.iesb.sie.service;

import br.iesb.sie.dao.ProfessorDisciplinaDAO;
import br.iesb.sie.dao.TurmaDAO;
import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.ProfessorDisciplina;
import br.iesb.sie.entity.Turma;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class TurmaService {

    @Inject
    private TurmaDAO turmaDAO;

    @Inject
    private ProfessorDisciplinaDAO professorDisciplinaDAO;


    public void salvarTurma(Turma turma) {
        if (turma.getId() != null) {

            Turma turmaSalva = buscarTurma(turma.getId());

            turmaSalva.setEscola(turma.getEscola());
            turmaSalva.setAno(turma.getAno());
            turmaSalva.getProfessorDisciplinas().clear();
            turmaSalva.setTurno(turma.getTurno());
            turmaSalva.setSerie(turma.getSerie());
            turmaSalva.setNome(turma.getNome());

            for (ProfessorDisciplina pd : turma.getProfessorDisciplinas()) {
                if (pd.getId() != null) {
                    turmaSalva.getProfessorDisciplinas().add(professorDisciplinaDAO.get(pd.getId()));
                } else {
                    turmaSalva.getProfessorDisciplinas().add(pd);
                }
            }

        } else {
            turmaDAO.salvar(turma);
        }
    }

    public Turma buscarTurma(Long id) {
        Turma turma = turmaDAO.get(id);
        turma.getProfessorDisciplinas().size();
        return turma;
    }

    public List<Turma> buscarTurmas(Turma filtro, List<Entidade> escolas) {
        return turmaDAO.buscarTurmas(filtro, escolas);
    }

}
