package br.iesb.sie.dto;

/**
 * Created by Danilo on 08/11/2015.
 */
public class HistoricoDisciplinaDTO {

    private String disciplina;
    private Double media;
    private String recuperacao;
    private Integer aulas = 0;
    private Integer faltas = 0;

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

    public Integer getAulas() {
        return aulas;
    }

    public void setAulas(Integer aulas) {
        this.aulas = aulas;
    }

    public Integer getFaltas() {
        return faltas;
    }

    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }
}
