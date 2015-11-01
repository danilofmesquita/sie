package br.iesb.sie.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.iesb.sie.dao.RelatorioDAO;
import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.Relatorio;

@Stateless
public class RelatorioService extends BaseService {

    /**
     * 
     */
    private static final long serialVersionUID = -3383922181255447427L;
    @Inject
    private RelatorioDAO relatorioDAO;

    public void salvar(Relatorio relatorio) {
        relatorioDAO.salvar(relatorio);
    }

    public List<Relatorio> buscarRelatorios(Relatorio relatorio, List<Entidade> escolas) {
        return relatorioDAO.buscarRelatorios(relatorio, escolas);
    }

    public Relatorio buscarRelatorio(Long id) {
        return relatorioDAO.get(id);
    }
}
