package br.iesb.sie.model;

public enum TipoAnalise {

    INDIVIDUAL("Individual"), COLETIVA("Coletiva");

    private String descricao;

    private TipoAnalise(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isColetiva(){
        return this.equals(COLETIVA);
    }

    public boolean isIndividial(){
        return this.equals(INDIVIDUAL);
    }
}
