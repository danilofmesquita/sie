package br.iesb.sie.controller;

import br.iesb.sie.bean.UsuarioLogado;
import br.iesb.sie.dto.HistoricoDTO;
import br.iesb.sie.service.HistoricoService;
import br.iesb.sie.service.JasperReportsService;
import br.iesb.sie.util.DownloadUtil;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Named
@ViewScoped
public class HistoricoController extends BaseController {

    @Inject
    private HistoricoService historicoService;

    @Inject
    private JasperReportsService jasperReportsService;

    @Inject
    private UsuarioLogado usuarioLogado;

    public void imprimir(){
        HistoricoDTO historicoDTO = historicoService.montarHistorico(usuarioLogado.getEntidade());

        Map<String, Object> params = new HashMap<>();
        byte[] bytes = jasperReportsService.gerarRelatorio(JasperReportsService.HISTORICO, params,
                new JRBeanCollectionDataSource(Collections.singletonList(historicoDTO)));


        new DownloadUtil().download(getFacesContext(), DownloadUtil.PDF_TYPE, bytes, "historico.pdf");

    }

}
