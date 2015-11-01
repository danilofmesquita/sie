package br.iesb.sie.model;

public enum Turno {

    MATUTINO("Matutino"), VESPERTINO("Vespertino"), NOTURNO("Noturno");

    private String descricao;

    Turno(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
