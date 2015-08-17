package br.iesb.sie.controller;

import br.iesb.sie.entidade.Funcionario;
import br.iesb.sie.jsf.Paginator;
import br.iesb.sie.jsf.PaginatorFilter;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ListarFuncionariosController extends BaseController implements Paginator<Funcionario> {

    @Override
    public Integer contarRegistros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Funcionario> consultarRegistros(int first, int pageSize, PaginatorFilter filter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
