package br.iesb.sie.model;

public enum Disciplina {

    MATEMATICA(1, "Matemática"),
    PORTUGUES(2, "Português");

    private Integer codigo;
    private String descricao;

    Disciplina(Integer codigo, String descricao) {
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
