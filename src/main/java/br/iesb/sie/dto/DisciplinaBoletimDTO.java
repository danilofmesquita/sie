package br.iesb.sie.dto;

public class DisciplinaBoletimDTO {

    private String disciplina;
    private Integer aulas;
    private Integer faltas;
    private Double nota1bimestre = 0D;
    private Double nota2bimestre = 0D;
    private Double nota3bimestre = 0D;
    private Double nota4bimestre = 0D;
    private Double somaTotal = 0D;
    private Double mediaAnual = 0D;
    private String recuperacao;
    private Integer divisor = 0;


    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
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

    public Double getNota1bimestre() {
        return nota1bimestre;
    }

    public void setNota1bimestre(Double nota1bimestre) {
        this.nota1bimestre = nota1bimestre;
    }

    public Double getNota2bimestre() {
        return nota2bimestre;
    }

    public void setNota2bimestre(Double nota2bimestre) {
        this.nota2bimestre = nota2bimestre;
    }

    public Double getNota3bimestre() {
        return nota3bimestre;
    }

    public void setNota3bimestre(Double nota3bimestre) {
        this.nota3bimestre = nota3bimestre;
    }

    public Double getNota4bimestre() {
        return nota4bimestre;
    }

    public void setNota4bimestre(Double nota4bimestre) {
        this.nota4bimestre = nota4bimestre;
    }

    public Double getSomaTotal() {
        return somaTotal;
    }

    public void setSomaTotal(Double somaTotal) {
        this.somaTotal = somaTotal;
    }

    public Double getMediaAnual() {
        return mediaAnual;
    }

    public void setMediaAnual(Double mediaAnual) {
        this.mediaAnual = mediaAnual;
    }

    public String getRecuperacao() {
        return recuperacao;
    }

    public void setRecuperacao(String recuperacao) {
        this.recuperacao = recuperacao;
    }

    public Integer getDivisor() {
        return divisor;
    }

    public void setDivisor(Integer divisor) {
        this.divisor = divisor;
    }
}
