package br.iesb.sie.model;

public enum Parentesco {

    PAI(1, "Pai"),
    MAE(2, "Mãe"),
    TIO(3, "Tio(a)"),
    AVO(4, "Avô(ó)"),
    PADRINHO(5, "Padrinho(a)"),
    IRMAO(6, "Irmão(ã)"),
    PRIMO(7, "Primo(a)");

    private Integer codigo;
    private String descricao;

    Parentesco(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
}
