package br.iesb.sie.model;

public enum Perfil {

    ESCOLA("Escola", "Escola"),
    ALUNO("Aluno", "Aluno(a)"),
    PROFESSOR("Professor", "Professor(a)"),
    SECRETARIA("Secretária", "Secretária(o)");

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
