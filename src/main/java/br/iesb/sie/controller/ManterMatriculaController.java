package br.iesb.sie.controller;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.iesb.sie.bean.UsuarioLogado;
import br.iesb.sie.entity.Endereco;
import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.Matricula;
import br.iesb.sie.entity.Turma;
import br.iesb.sie.model.Perfil;
import br.iesb.sie.service.CEPService;
import br.iesb.sie.service.EntidadeService;
import br.iesb.sie.service.MatriculaService;
import br.iesb.sie.service.TurmaService;
import br.iesb.sie.util.Attributes;

@Named
@ViewScoped
public class ManterMatriculaController extends BaseController {

    /**
     * 
     */
    private static final long serialVersionUID = 5709305336703459906L;

    @Inject
    private CEPService cepService;

    @Inject
    private EntidadeService entidadeService;

    @Inject
    private TurmaService turmaService;

    @Inject
    private UsuarioLogado usuarioLogado;

    @Inject
    private MatriculaService matriculaService;

    private Matricula matricula;

    private List<Turma> turmas;

    @PostConstruct
    public void init() {
        Long id = getFlashAttribute(Attributes.ID);

        if (id == null) {
            matricula = new Matricula();
            matricula.setEnderecoResponsavel(new Endereco());
        } else {
            matricula = matriculaService.buscarMatricula(id);
            carregarTurmas();
        }
    }

    public void salvar() {
        matriculaService.salvar(matricula);
        addInfoMessage("Dados salvos com sucesso!");
    }

    public void carregarEnderecoPorCEP() {
        matricula.setEnderecoResponsavel(cepService.buscarEnderecoPorCEP(matricula.getEnderecoResponsavel().getCep()));
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public List<Entidade> getAlunos() {
        return entidadeService.buscarEntidadesPorPerfil(Perfil.ALUNO);
    }

    public List<Entidade> getEscolasVinculadas() {
        if (usuarioLogado.isSecretaria()) {
            return entidadeService.buscarEscolasVinculadasAoFuncionario(usuarioLogado.getEntidade(), Perfil.SECRETARIA);
        } else if (usuarioLogado.isEscola()) {
            return Collections.singletonList(usuarioLogado.getEntidade());
        }
        return Collections.emptyList();
    }

    public void carregarTurmas() {
        if (matricula.getEscola() != null) {
            turmas = turmaService.buscarTurmas(null, getEscolasVinculadas());
        } else {
            turmas = Collections.emptyList();
        }
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}
