package br.iesb.sie.service;

import br.iesb.sie.dao.RelatorioDAO;
import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.Relatorio;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class RelatorioService extends BaseService {

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
