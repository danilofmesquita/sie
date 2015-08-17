package br.iesb.sie.controller;

import br.iesb.sie.entidade.Disciplina;
import br.iesb.sie.entidade.filter.DisciplinaFilter;
import br.iesb.sie.jsf.Paginator;
import br.iesb.sie.jsf.PaginatorFilter;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ListarDisciplinaController extends BaseController implements Paginator<Disciplina> {

    @Override
    public Integer contarRegistros() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Disciplina> consultarRegistros(int first, int pageSize, PaginatorFilter filter) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
