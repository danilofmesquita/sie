package br.iesb.sie.jsf;

import java.util.List;

public interface Paginator<T> {

    Integer contarRegistros();

    List<T> consultarRegistros(int first, int pageSize, PaginatorFilter filter);

}
