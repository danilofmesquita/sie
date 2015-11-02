package br.iesb.sie.util;

import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.Turma;
import br.iesb.sie.model.*;
import br.iesb.sie.service.TurmaService;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Model
public class FactoryUtil {

    @Inject
    private TurmaService turmaService;

    public List<TipoPessoa> getTiposPessoa() {
        return Arrays.asList(TipoPessoa.values());
    }

    public List<UF> getUFs() {
        return Arrays.asList(UF.values());
    }

    public List<Perfil> getPerfisCPF() {
        return Arrays.asList(Perfil.ALUNO, Perfil.PROFESSOR, Perfil.SECRETARIA);
    }

    public List<Perfil> getPerfisCNPJ() {
        return Collections.singletonList(Perfil.ESCOLA);
    }

    public List<Perfil> getCargos() {
        return Arrays.asList(Perfil.PROFESSOR, Perfil.SECRETARIA);
    }

    public List<Disciplina> getDisciplinas() {
        return Arrays.asList(Disciplina.values());
    }

    public List<Serie> getSeries() {
        return Arrays.asList(Serie.values());
    }

    public List<Turno> getTurnos() {
        return Arrays.asList(Turno.values());
    }

    public List<Parentesco> getParentescos() {
        return Arrays.asList(Parentesco.values());
    }

    public List<Bimestre> getBimestres() {
        return Arrays.asList(Bimestre.values());
    }

    public List<TipoAnalise> getTiposAnalise() {
        return Arrays.asList(TipoAnalise.values());
    }

    public List<Entidade> buscarAlunos(Turma turma) {
        if (turma != null) {
            return turmaService.buscarAlunos(turma);
        } else {
            return Collections.emptyList();
        }
    }

    public List<Disciplina> buscarDisciplinas(Turma turma) {
        if (turma != null) {
            return turmaService.buscarDisciplinasPorTurma(turma.getId());
        } else {
            return Collections.emptyList();
        }
    }
}
