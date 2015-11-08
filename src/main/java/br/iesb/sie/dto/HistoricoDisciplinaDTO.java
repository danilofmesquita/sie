package br.iesb.sie.dto;

/**
 * Created by Danilo on 08/11/2015.
 */
public class HistoricoDisciplinaDTO {

    private String disciplina;
    private Double media;
    private String recuperacao;

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public String getRecuperacao() {
        return recuperacao;
    }

    public void setRecuperacao(String recuperacao) {
        this.recuperacao = recuperacao;
    }
}
