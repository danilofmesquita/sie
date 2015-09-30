package br.iesb.sie.service;

import br.iesb.sie.work.FillReportWork;
import br.iesb.sie.dao.WorkDAO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.InputStream;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class JasperReportsService extends BaseService  {

    public static final String PASSE = "reports/passe.jrxml";

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

}
