package br.iesb.sie.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Danilo on 08/11/2015.
 */
public class HistoricoTurmaDTO {

    private List<HistoricoDisciplinaDTO> disciplinas = new ArrayList<>();

    private String escola;
    private String nomeTurma;
    private Integer ano;

    public List<HistoricoDisciplinaDTO> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<HistoricoDisciplinaDTO> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public String getEscola() {
        return escola;
    }

    public void setEscola(String escola) {
        this.escola = escola;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
}
