package br.iesb.sie.controller;

import br.iesb.sie.bean.UsuarioLogado;
import br.iesb.sie.dto.BoletimDTO;
import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.Turma;
import br.iesb.sie.service.EntidadeService;
import br.iesb.sie.service.JasperReportsService;
import br.iesb.sie.service.TurmaService;
import br.iesb.sie.util.DownloadUtil;
import net.sf.jasperreports.engine.JRException;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@ViewScoped
public class SolicitarBoletimController extends BaseController {

    /**
     * 
     */
    private static final long serialVersionUID = 2252480713587267602L;

    @Inject
    private EntidadeService entidadeService;

    @Inject
    private TurmaService turmaService;

    @Inject
    private UsuarioLogado usuarioLogado;

    @Inject
    private JasperReportsService jasperReportsService;

    private BoletimDTO boletimDTO;

    @PostConstruct
    public void init() {
        boletimDTO = new BoletimDTO();
    }

    public List<Entidade> getEscolasVinculadas() {
        return entidadeService.buscarEscolasVinculadasAoAluno(usuarioLogado.getEntidade());
    }

    public List<Turma> getTurmasVinculadas() {
        if (boletimDTO.getEscola() != null) {
            return turmaService.buscarTurmasPorEscolaAluno(boletimDTO.getEscola(),
                    usuarioLogado.getEntidade());
        } else {
            return Collections.emptyList();
        }
    }

    public void imprimir() throws JRException {
        Map<String, Object> params = new HashMap<>();

        params.put("ID_ALUNO", usuarioLogado.getEntidade().getId());
        params.put("ID_ESCOLA", boletimDTO.getEscola().getId());
        params.put("ID_TURMA", boletimDTO.getTurma().getId());

        byte[] bytes = jasperReportsService.gerarRelatorio(JasperReportsService.BOLETIM, params);

        new DownloadUtil().download(getFacesContext(), DownloadUtil.PDF_TYPE, bytes, "boletim.pdf");
    }

    public BoletimDTO getBoletimDTO() {
        return boletimDTO;
    }

    public void setBoletimDTO(BoletimDTO boletimDTO) {
        this.boletimDTO = boletimDTO;
    }

}