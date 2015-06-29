package br.iesb.sie.model;

public enum TipoPessoa {

    FISICA('F', "Física"),
    JURIDICA('J', "Júridica");

    private Character codigo;
    private String descricao;

    TipoPessoa(Character codigo, String descricao) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public Character getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isJuridica(){
        return this == TipoPessoa.JURIDICA;
    }

    public boolean isFisica(){
        return this == TipoPessoa.FISICA;
    }
}
