package br.iesb.sie.service;

import br.iesb.sie.dao.ProfessorDisciplinaDAO;
import br.iesb.sie.dao.TurmaDAO;
import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.ProfessorDisciplina;
import br.iesb.sie.entity.Turma;
import br.iesb.sie.model.Disciplina;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class TurmaService extends BaseService {

    @Inject
    private TurmaDAO turmaDAO;

    @Inject
    private ProfessorDisciplinaDAO professorDisciplinaDAO;


    public void salvarTurma(Turma turma) {
        turmaDAO.salvar(turma);
    }

    public Turma buscarTurma(Long id) {
        Turma turma = turmaDAO.get(id);
        turma.getProfessorDisciplinas().size();
        return turma;
    }

    public List<Turma> buscarTurmas(Turma filtro, List<Entidade> escolas) {
        List<Turma> turmas = turmaDAO.buscarTurmas(filtro, escolas);
        turmas.forEach(turma -> turma.getMatriculas().size());
        return turmas;
    }

    public List<Disciplina> buscarDisciplinasVinculadasATurma(Long idTurma) {
        Turma turma = turmaDAO.get(idTurma);
        List<Disciplina> disciplinas = new ArrayList<>();

        turma.getProfessorDisciplinas().forEach((pd) -> disciplinas.add(pd.getDisciplina()));

        return disciplinas;
    }

    public List<Disciplina> buscarDisciplinasVinculadasATurmaEProfessor(Long idTurma, Long idEntidadeProfessor) {
        Turma turma = turmaDAO.get(idTurma);
        List<Disciplina> disciplinas = new ArrayList<>();

        turma.getProfessorDisciplinas().forEach((pd) -> {
            if(pd.getProfessor().getId().equals(idEntidadeProfessor)) {
                disciplinas.add(pd.getDisciplina());
            }
        });

        return disciplinas;
    }

    public List<Turma> buscarTurmasVinculadasAEscolaEAluno(Entidade escola, Entidade aluno) {
        return turmaDAO.buscarTurmasVinculadasAEscolaEAluno(escola, aluno);
    }
}
