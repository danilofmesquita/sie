package br.iesb.sie.controller;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.iesb.sie.bean.UsuarioLogado;
import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.ProfessorDisciplina;
import br.iesb.sie.entity.Turma;
import br.iesb.sie.model.Perfil;
import br.iesb.sie.service.EntidadeService;
import br.iesb.sie.service.TurmaService;
import br.iesb.sie.util.Attributes;

@Named
@ViewScoped
public class ManterTurmaController extends BaseController {

    /**
     * 
     */
    private static final long serialVersionUID = -2643724481960871552L;

    @Inject
    private UsuarioLogado usuarioLogado;

    @Inject
    private EntidadeService entidadeService;

    @Inject
    private TurmaService turmaService;

    private Turma turma;

    private ProfessorDisciplina professorDisciplina;

    private List<Entidade> escolasVinculadas;

    @PostConstruct
    public void init() {
        Long id = getFlashAttribute(Attributes.ID);

        if (id == null) {
            turma = new Turma();
        } else {
            turma = turmaService.buscarTurma(id);
        }

        if (usuarioLogado.isEscola()) {
            escolasVinculadas = Collections.singletonList(usuarioLogado.getEntidade());
        } else if (usuarioLogado.isSecretaria()) {
            escolasVinculadas = entidadeService.buscarEscolasVinculadasAoFuncionario(usuarioLogado.getEntidade(),
                    Perfil.SECRETARIA);
        }

        professorDisciplina = new ProfessorDisciplina(turma);
    }

    public String salvar() {
        turmaService.salvarTurma(turma);
        addInfoMessage("Dados salvos com sucesso!");
        return "listar.xhtml?faces-redirect=true";
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

    public List<Entidade> buscarProfessores() {
        if (turma.getEscola() != null) {
            return entidadeService.buscarProfessores(turma.getEscola());
        }
        return Collections.emptyList();
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public ProfessorDisciplina getProfessorDisciplina() {
        return professorDisciplina;
    }

    public void setProfessorDisciplina(ProfessorDisciplina professorDisciplina) {
        this.professorDisciplina = professorDisciplina;
    }

    public List<Entidade> getEscolasVinculadas() {
        return escolasVinculadas;
    }

    public void setEscolasVinculadas(List<Entidade> escolasVinculadas) {
        this.escolasVinculadas = escolasVinculadas;
    }
}
