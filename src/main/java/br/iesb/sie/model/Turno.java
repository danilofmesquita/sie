package br.iesb.sie.model;


public enum Turno {

    MATUTINO(1, "Matutino"),
    VESPERTINO(2, "Vespertino"),
    NOTURNO(3, "Noturno");

    private Integer codigo;
    private String descricao;

    Turno(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
