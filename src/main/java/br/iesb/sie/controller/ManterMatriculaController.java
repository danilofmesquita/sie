package br.iesb.sie.controller;

import br.iesb.sie.bean.UsuarioLogado;
import br.iesb.sie.entity.*;
import br.iesb.sie.model.Perfil;
import br.iesb.sie.service.*;
import br.iesb.sie.util.Attributes;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collections;
import java.util.List;

@Named
@ViewScoped
public class ManterMatriculaController extends BaseController {

    @Inject
    private CEPService cepService;

    @Inject
    private EntidadeService entidadeService;

    @Inject
    private FuncionarioService funcionarioService;

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
            return entidadeService.buscarEscolasVinculadas(usuarioLogado.getEntidade(), Perfil.SECRETARIA);
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
