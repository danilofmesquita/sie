package br.iesb.sie.util;

import br.iesb.sie.model.Perfil;
import br.iesb.sie.model.TipoPessoa;
import br.iesb.sie.model.UF;

import javax.enterprise.inject.Model;
import java.util.Arrays;
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
        return Arrays.asList(Perfil.ESCOLA);
    }
}
