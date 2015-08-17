package br.iesb.sie.controller;

import br.iesb.sie.entidade.Funcionario;
import br.iesb.sie.util.Attributes;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ManterFuncionarioController extends BaseController {

    private Funcionario funcionario;

    public void init() {
        Long id = getFlashAttribute(Attributes.ID);

        if (id == null) {
            funcionario = new Funcionario();
        } else {
            funcionario = new Funcionario();
        }
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}
