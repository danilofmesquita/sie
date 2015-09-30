package br.iesb.sie.util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DownloadUtil {

    public static final String PDF_TYPE = "application/pdf";
    private static final Logger LOGGER = Logger.getLogger(DownloadUtil.class.getName());

    public void download(FacesContext facesContext, String contentType, byte[] file, String fileName) {


        ExternalContext ec = facesContext.getExternalContext();

        ec.responseReset();
        ec.setResponseContentType(contentType);
        ec.setResponseContentLength(file.length);
        ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");


        try (OutputStream output = ec.getResponseOutputStream()) {
            output.write(file);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }

        facesContext.responseComplete();
    }
}
