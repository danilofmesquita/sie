package br.iesb.sie.model;

public enum Perfil {

    ESCOLA("Escola"), ALUNO("Aluno(a)"), PROFESSOR("Professor(a)"), SECRETARIA("Secretária(o)");

    private String nomeMF;

    Perfil(String nomeMF) {
        this.nomeMF = nomeMF;
    }

    public String getNomeMF() {
        return nomeMF;
    }
}
