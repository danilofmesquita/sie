package br.iesb.sie.controller;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.iesb.sie.bean.UsuarioLogado;
import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.Matricula;
import br.iesb.sie.entity.Turma;
import br.iesb.sie.model.Perfil;
import br.iesb.sie.service.EntidadeService;
import br.iesb.sie.service.MatriculaService;
import br.iesb.sie.service.TurmaService;

@Named
@ViewScoped
public class ListarMatriculaController extends ListarController {

    /**
     * 
     */
    private static final long serialVersionUID = 4977092014538825621L;

    @Inject
    private MatriculaService matriculaService;

    @Inject
    private UsuarioLogado usuarioLogado;

    @Inject
    private EntidadeService entidadeService;

    @Inject
    private TurmaService turmaService;

    private List<Matricula> matriculas;

    private Matricula filtro;

    private List<Turma> turmas;

    private List<Entidade> alunos;

    @PostConstruct
    public void init() {
        filtro = new Matricula();
        filtrar();
    }

    @Override
    public void filtrar() {
        matriculas = matriculaService.buscarMatriculas(filtro, getEscolasVinculadas());
    }

    public void limpar() {
        filtro = new Matricula();
        filtrar();
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public List<Entidade> getEscolasVinculadas() {
        if (usuarioLogado.isEscola()) {
            return Collections.singletonList(usuarioLogado.getEntidade());
        } else if (usuarioLogado.isSecretaria()) {
            return entidadeService.buscarEscolasVinculadasAoFuncionario(usuarioLogado.getEntidade(), Perfil.SECRETARIA);
        }
        return Collections.emptyList();
    }

    public void carregarTurmasAlunos() {
        if (filtro.getEscola() != null) {
            turmas = turmaService.buscarTurmas(null, getEscolasVinculadas());
            alunos = entidadeService.buscarAlunosVinculados(getEscolasVinculadas());
        } else {
            turmas = Collections.emptyList();
            alunos = Collections.emptyList();
        }
    }

    public Matricula getFiltro() {
        return filtro;
    }

    public void setFiltro(Matricula filtro) {
        this.filtro = filtro;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public List<Entidade> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Entidade> alunos) {
        this.alunos = alunos;
    }
}
