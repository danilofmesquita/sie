package br.iesb.sie.controller;

import br.iesb.sie.entidade.Disciplina;
import br.iesb.sie.util.Attributes;

public class ManterDisciplinaController extends BaseController {

    private Disciplina disciplina;

    public void init() {
        Long id = getFlashAttribute(Attributes.ID);

        if (id == null) {
            disciplina = new Disciplina();
        } else {
            disciplina = new Disciplina();
        }
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

}
