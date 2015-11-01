package br.iesb.sie.model;

public enum Bimestre {

    PRIMEIRO("1º Bimestre"), SEGUNDO("2º Bimestre"), TERCEIRO("3º Bimestre"), QUARTO("4º Bimestre");

    Bimestre(String descricao) {
        this.descricao = descricao;
    }

    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
