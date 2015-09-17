package br.iesb.sie.model;

public enum Disciplina {

    ARTES(1, "Artes"),
    BIOLOGIA(2, "Biologia"),
    CIENCIAS(3, "Ciências"),
    EDUCACAO_FISICA(4, "Educação Fisica"),
    ESTUDOS_SOCIAIS(5, "Estudos Sociais"),
    ESPANHOL(6, "Espanhol"),
    FILOSOFIA(7, "Filosofia"),
    FISICA(8, "Física"),
    GEOGRAFIA(9, "Geografia"),
    HISTORIA(10, "História"),
    INFORMATICA(11, "Informática"),
    INGLES(12, "Ingles"),
    LITERATURA(13, "Literatura"),
    MATEMATICA(14, "Matemática"),
    PORTUGUES(15, "Português"),
    QUIMICA(16, "Química"),
    REDACAO(17, "Redação"),
    SOCIOLOGIA(18, "Sociologia");

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

    @Override
    public String toString() {
        return descricao;
    }
}
