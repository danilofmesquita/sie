package br.iesb.sie.work;

import net.sf.jasperreports.engine.*;
import org.hibernate.jdbc.Work;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FillReportWork implements Work {

    private static final Logger logger = Logger.getLogger(FillReportWork.class.getName());

    private final InputStream reportTemplateAsStream;

    private final Map<String, Object> params;

    private JasperPrint jasperPrint;

    public FillReportWork(InputStream reportTemplateAsStream, Map<String, Object> params) {
        this.reportTemplateAsStream = reportTemplateAsStream;
        this.params = params;
    }

    @Override
    public void execute(Connection connection) throws SQLException {
        try {
            addDefaultParams();
            JasperReport jasperReport = JasperCompileManager.compileReport(reportTemplateAsStream);
            jasperPrint = JasperFillManager.fillReport(jasperReport, params, connection);
        } catch (JRException e) {
            logger.log(Level.SEVERE, "Não foi possivel preencher o relatorio");
        }
    }

    private void addDefaultParams() {
        try {
            //Sempre adiciona o logo do SIE aos params
            BufferedImage image = ImageIO.read(getClass().getResource("/reports/SIE.png"));
            params.put("LOGO", image);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Não foi adicionar o logo do SIE ao relatorio.");
        }
    }

    public JasperPrint getJasperPrint() {
        return jasperPrint;
    }
}
