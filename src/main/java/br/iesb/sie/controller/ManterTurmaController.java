package br.iesb.sie.controller;

import br.iesb.sie.bean.UsuarioLogado;
import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.ProfessorDisciplina;
import br.iesb.sie.entity.Turma;
import br.iesb.sie.service.EntidadeService;
import br.iesb.sie.service.TurmaService;
import br.iesb.sie.util.Attributes;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class ManterTurmaController extends BaseController {

    private Turma turma;

    private List<Entidade> professores;

    private ProfessorDisciplina professorDisciplina;

    @Inject
    private UsuarioLogado usuarioLogado;

    @Inject
    private EntidadeService entidadeService;

    @Inject
    private TurmaService turmaService;

    @PostConstruct
    public void init() {
        Long id = getFlashAttribute(Attributes.ID);

        if (id == null) {
            turma = new Turma();
            if (usuarioLogado.isEscola()) {
                turma.setEscola(usuarioLogado.getEntidade());
            }
        } else {
            turma = turmaService.buscarTurma(id);
        }

        if (usuarioLogado.isEscola()) {
            professores = entidadeService.buscarProfessores(usuarioLogado.getEntidade());
        }

        professorDisciplina = new ProfessorDisciplina(turma);
    }

    public void salvar() {
        turmaService.salvarTurma(turma);
        addInfoMessage("Dados salvos com sucesso!");
    }

    public void adicionarProfessorDisciplina() {
        turma.getProfessorDisciplinas().add(professorDisciplina);
        professorDisciplina = new ProfessorDisciplina(turma);
    }

    public void removerProfessorDisciplina(ProfessorDisciplina professorDisciplina) {
        turma.getProfessorDisciplinas().remove(professorDisciplina);
    }

    public void editarProfessorDisciplina(ProfessorDisciplina professorDisciplina) {
        turma.getProfessorDisciplinas().remove(professorDisciplina);
        this.professorDisciplina = professorDisciplina;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public List<Entidade> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Entidade> professores) {
        this.professores = professores;
    }

    public ProfessorDisciplina getProfessorDisciplina() {
        return professorDisciplina;
    }

    public void setProfessorDisciplina(ProfessorDisciplina professorDisciplina) {
        this.professorDisciplina = professorDisciplina;
    }
}
