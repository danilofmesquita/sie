package br.iesb.sie.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Danilo on 08/11/2015.
 */
public class HistoricoDTO {

    private String aluno;
    private String matricula;
    private String filiacao;
    private String cpf;
    private String endereco;
    private String numero;

    private List<HistoricoTurmaDTO> turmas = new ArrayList<>();

    public List<HistoricoTurmaDTO> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<HistoricoTurmaDTO> turmas) {
        this.turmas = turmas;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getFiliacao() {
        return filiacao;
    }

    public void setFiliacao(String filiacao) {
        this.filiacao = filiacao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
