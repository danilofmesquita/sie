package br.iesb.sie.util;

import br.iesb.sie.model.*;

import javax.enterprise.inject.Model;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Model
public class FactoryUtil {

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
}
