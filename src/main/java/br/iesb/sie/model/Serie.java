package br.iesb.sie.model;

public enum Serie {

    PRIMEIRO_ANO("Primeiro Ano"),
    SEGUNDO_ANO("Segundo Ano"),
    TERCEIRO_ANO("Terceiro Ano"),
    QUARTO_ANO("Quarto Ano"),
    QUINTO_ANO("Quinto Ano"),
    SEXTO_ATO("Sexto Ano"),
    SETIMO_ANO("Sétimo Ano"),
    OITAVO_ANO("Oitavo Ano"),
    NOVO_ANO("Nono Ano"),
    PRIMEIRO_ANO_EM("Primeiro Ano do Ensino Médio"),
    SEGUNDO_ANO_EM("Segundo Ano do Ensino Médio"),
    TERCEIRO_ANO_EM("Terceiro Ano do Ensino Médio");

    private String descricao;

    Serie(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
