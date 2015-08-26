package br.iesb.sie.model;

public enum Perfil {

    ESCOLA("ESCOLA", "Escola"),
    ALUNO("ALUNO", "Aluno(a)"),
    PROFESSOR("PROFESSOR", "Professor(a)"),
    SECRETARIA("SECRETARIA", "Secretária(o)");

    private String nome;
    private String nomeMF;

    Perfil(String nome, String nomeMF) {
        this.nome = nome;
        this.nomeMF = nomeMF;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeMF() {
        return nomeMF;
    }
}
