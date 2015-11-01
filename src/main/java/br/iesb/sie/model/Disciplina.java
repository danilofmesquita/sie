package br.iesb.sie.model;

public enum Disciplina {

    ARTES("Artes"), BIOLOGIA("Biologia"), CIENCIAS("Ciências"), EDUCACAO_FISICA("Educação Fisica"), ESTUDOS_SOCIAIS(
            "Estudos Sociais"), ESPANHOL("Espanhol"), FILOSOFIA("Filosofia"), FISICA("Física"), GEOGRAFIA(
                    "Geografia"), HISTORIA("História"), INFORMATICA("Informática"), INGLES("Ingles"), LITERATURA(
                            "Literatura"), MATEMATICA("Matemática"), PORTUGUES("Português"), QUIMICA(
                                    "Química"), REDACAO("Redação"), SOCIOLOGIA("Sociologia");

    private String descricao;

    Disciplina(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
