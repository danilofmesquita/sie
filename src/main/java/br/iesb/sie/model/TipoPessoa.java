package br.iesb.sie.model;

public enum TipoPessoa {

    FISICA("Física"), JURIDICA("Júridica");
    private String descricao;

    TipoPessoa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isJuridica() {
        return this == TipoPessoa.JURIDICA;
    }

    public boolean isFisica() {
        return this == TipoPessoa.FISICA;
    }
}
