package br.iesb.sie.controller;

import br.iesb.sie.bean.UsuarioLogado;
import br.iesb.sie.dto.PasseDTO;
import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.Turma;
import br.iesb.sie.service.EntidadeService;
import br.iesb.sie.service.JasperReportsService;
import br.iesb.sie.service.TurmaService;
import br.iesb.sie.util.DownloadUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;

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
public class SolicitarPasseController extends BaseController {

    @Inject
    private EntidadeService entidadeService;

    @Inject
    private TurmaService turmaService;

    @Inject
    private UsuarioLogado usuarioLogado;

    @Inject
    private JasperReportsService jasperReportsService;

    private PasseDTO passeDTO;

    @PostConstruct
    public void init() {
        passeDTO = new PasseDTO();
    }

    public List<Entidade> getEscolasVinculadas() {
        return entidadeService.buscarEscolasVinculadasAoAluno(usuarioLogado.getEntidade());
    }

    public List<Turma> getTurmasVinculadas() {
        if (passeDTO.getEscola() != null) {
            return turmaService.buscarTurmasVinculadasAEscolaEAluno(passeDTO.getEscola(), usuarioLogado.getEntidade());
        } else {
            return Collections.emptyList();
        }
    }

    public void imprimir() throws JRException {
        Map<String, Object> params = new HashMap<>();

        params.put("ID_ALUNO", usuarioLogado.getEntidade().getId());
        params.put("ID_ESCOLA", passeDTO.getEscola().getId());
        params.put("ID_TURMA", passeDTO.getTurma().getId());

        byte[] bytes = jasperReportsService.gerarRelatorio(JasperReportsService.PASSE, params);

        new DownloadUtil().download(getFacesContext(), DownloadUtil.PDF_TYPE, bytes, "declaracao.pdf");
    }

    public PasseDTO getPasseDTO() {
        return passeDTO;
    }

    public void setPasseDTO(PasseDTO passeDTO) {
        this.passeDTO = passeDTO;
    }

}
