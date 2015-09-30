package br.iesb.sie.model;

public enum Parentesco {

    PAI("Pai"),
    MAE("Mãe"),
    TIO("Tio(a)"),
    AVO("Avô(ó)"),
    PADRINHO("Padrinho(a)"),
    IRMAO("Irmão(ã)"),
    PRIMO("Primo(a)");

    private String descricao;

    Parentesco(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
