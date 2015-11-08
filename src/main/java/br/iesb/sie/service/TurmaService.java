package br.iesb.sie.service;

import br.iesb.sie.dao.TurmaDAO;
import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.Turma;
import br.iesb.sie.model.Disciplina;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class TurmaService extends BaseService {

    /**
     * 
     */
    private static final long serialVersionUID = -8505725186152964563L;

    @Inject
    private TurmaDAO turmaDAO;

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

    public List<Disciplina> buscarDisciplinasPorTurma(Long idTurma) {
        Turma turma = turmaDAO.get(idTurma);
        List<Disciplina> disciplinas = new ArrayList<>();

        turma.getProfessorDisciplinas().forEach((pd) -> disciplinas.add(pd.getDisciplina()));

        return disciplinas;
    }

    public List<Disciplina> buscarDisciplinasPorTurmaProfessor(Long idTurma, Long idEntidadeProfessor) {
        Turma turma = turmaDAO.get(idTurma);
        List<Disciplina> disciplinas = new ArrayList<>();

        turma.getProfessorDisciplinas().forEach((pd) -> {
            if (pd.getProfessor().getId().equals(idEntidadeProfessor)) {
                disciplinas.add(pd.getDisciplina());
            }
        });

        return disciplinas;
    }

    public List<Turma> buscarTurmasPorEscolaAluno(Entidade escola, Entidade aluno) {
        return turmaDAO.buscarTurmasPorEscolaAluno(escola, aluno);
    }

    public List<Turma> buscarTurmasPorEscola(Entidade escola) {
        return turmaDAO.buscarTurmasPorEscola(escola);
    }

    public List<Entidade> buscarAlunos(Turma turma) {
        return turmaDAO.buscarAlunosPorTurma(turma);
    }

    public List<Turma> buscarTurmasPorAluno(Entidade aluno){
     return turmaDAO.buscarTurmasPorAluno(aluno);
    }
}
