package br.iesb.sie.service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.imageio.ImageIO;
import javax.inject.Inject;

import br.iesb.sie.dao.WorkDAO;
import br.iesb.sie.work.FillReportWork;
import net.sf.jasperreports.engine.*;

@Stateless
public class JasperReportsService extends BaseService {

    /**
     *
     */
    private static final long serialVersionUID = -3046705544671892769L;
    public static final String PASSE = "reports/passe.jrxml";
    public static final String BOLETIM = "reports/boletim.jrxml";
    public static final String HISTORICO = "reports/historico.jrxml";

    @Inject
    private Logger logger;

    @Inject
    private WorkDAO workDAO;

    public byte[] gerarRelatorio(String report, Map<String, Object> params) {

        InputStream reportTemplate = getClass().getClassLoader().getResourceAsStream(report);

        FillReportWork fillReportWork = new FillReportWork(reportTemplate, params);
        workDAO.doWork(fillReportWork);

        JasperPrint jasperPrint = fillReportWork.getJasperPrint();

        try {
            return JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (JRException e) {
            logger.log(Level.SEVERE, "erro ao gerar o relatorio", e);
        }

        return null;
    }

    public byte[] gerarRelatorio(String report, Map<String, Object> params, JRDataSource jrDataSource) {

        try (InputStream reportTemplate = getClass().getClassLoader().getResourceAsStream(report)) {

            addDefaultParams(params);

            JasperReport jasperReport = JasperCompileManager.compileReport(reportTemplate);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, jrDataSource);

            return JasperExportManager.exportReportToPdf(jasperPrint);

        } catch (JRException | IOException e) {
            logger.log(Level.SEVERE, "erro ao gerar o relatorio", e);
        }

        return null;
    }

    private void addDefaultParams(Map<String, Object> params) {
        try {
            // Sempre adiciona o logo do SIE aos params
            BufferedImage image = ImageIO.read(getClass().getResource("/reports/SIE.png"));
            params.put("LOGO", image);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Não foi possível adicionar o logo do SIE ao relatório.", e);
        }
    }


}
