package br.iesb.sie.dto;

import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.Turma;

public class PasseDTO {

    private Entidade escola;

    private Turma turma;

    public Entidade getEscola() {
        return escola;
    }

    public void setEscola(Entidade escola) {
        this.escola = escola;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
