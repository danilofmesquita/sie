package br.iesb.sie.model;

public enum Serie {

    PRIMEIRO_ANO(1, "Primeiro Ano"),
    SEGUNDO_ANO(2, "Segundo Ano"),
    TERCEIRO_ANO(3, "Terceiro Ano"),
    QUARTO_ANO(4, "Quarto Ano"),
    QUINTO_ANO(5, "Quinto Ano"),
    SEXTO_ATO(6, "Sexto Ano"),
    SETIMO_ANO(7, "Sétimo Ano"),
    OITAVO_ANO(8, "Oitavo Ano"),
    NOVO_ANO(9, "Nono Ano"),
    PRIMEIRO_ANO_EM(10, "Primeiro Ano do Ensino Médio"),
    SEGUNDO_ANO_EM(11, "Segundo Ano do Ensino Médio"),
    TERCEIRO_ANO_EM(12, "Terceiro Ano do Ensino Médio");


    private Integer codigo;
    private String descricao;

    Serie(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
