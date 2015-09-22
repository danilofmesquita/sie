package br.iesb.sie.model;

public enum Bimestre {

    PRIMEIRO(1, "1º Bimestre"),
    SEGUNDO(2, "2º Bimestre"),
    TERCEIRO(3, "3º Bimestre"),
    QUARTO(4, "4º Bimestre");

    Bimestre(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    private Integer codigo;
    private String descricao;


    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
