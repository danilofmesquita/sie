package br.iesb.sie.service;

import br.iesb.sie.dto.HistoricoDTO;
import br.iesb.sie.dto.HistoricoDisciplinaDTO;
import br.iesb.sie.dto.HistoricoTurmaDTO;
import br.iesb.sie.entity.*;
import br.iesb.sie.model.Disciplina;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Stateless
public class HistoricoService {

    @Inject
    private TurmaService turmaService;


    public HistoricoDTO montarHistorico(Entidade aluno) {

        List<Turma> turmas = turmaService.buscarTurmasPorAluno(aluno);
        Map<Disciplina, List<Double>> disciplinasNotasMap = new LinkedHashMap<>();
        Map<Disciplina, Integer> aulasMap = new LinkedHashMap<>();
        Map<Disciplina, Integer> faltasMap = new LinkedHashMap<>();
        HistoricoDTO historicoDTO = new HistoricoDTO();

        historicoDTO.setAluno(aluno.getNomeCompleto());
        historicoDTO.setCpf(aluno.getCpfCnpj());
        historicoDTO.setMatricula(String.valueOf(aluno.getLogin()));
        historicoDTO.setNumero(aluno.getEndereco().getNumero());
        historicoDTO.setEndereco(aluno.getEndereco().getEndereco());
        historicoDTO.setFiliacao(aluno.getFiliacao());

        for (Turma t : turmas) {

            HistoricoTurmaDTO historicoTurmaDTO = new HistoricoTurmaDTO();

            historicoTurmaDTO.setNomeTurma(t.toString());
            historicoTurmaDTO.setEscola(t.getEscola().getRazaoSocial());
            historicoTurmaDTO.setAno(t.getAno());

            for (NotaLancamento nl : t.getNotaLancamentos()) {
                for (Nota n : nl.getNotas()) {
                    if (n.getAluno().getId().equals(aluno.getId())) {
                        if (!disciplinasNotasMap.containsKey(nl.getDisciplina())) {
                            disciplinasNotasMap.put(nl.getDisciplina(), new ArrayList<>());
                        }
                        disciplinasNotasMap.get(nl.getDisciplina()).add(n.getNota());
                    }
                }
            }

            for(FrequenciaLancamento fl : t.getFrequenciaLancamentos()){
                for (Frequencia f : fl.getFrequencias()){
                    if(f.getAluno().getId().equals(aluno.getId())){
                        if (!aulasMap.containsKey(fl.getDisciplina())) {
                            aulasMap.put(fl.getDisciplina(), 0);
                        }
                        if (!faltasMap.containsKey(fl.getDisciplina())) {
                            faltasMap.put(fl.getDisciplina(), 0);
                        }
                        aulasMap.put(fl.getDisciplina(), aulasMap.get(fl.getDisciplina())+1);
                        if(!f.isPresente()) {
                            faltasMap.put(fl.getDisciplina(), faltasMap.get(fl.getDisciplina())+1);
                        }
                    }
                }
            }

            for (Map.Entry<Disciplina, List<Double>> entry : disciplinasNotasMap.entrySet()) {
                HistoricoDisciplinaDTO historicoDisciplinaDTO = new HistoricoDisciplinaDTO();
                historicoDisciplinaDTO.setDisciplina(entry.getKey().getDescricao());

                Double somaNota = 0D;

                for (Double nota : entry.getValue()) {
                    somaNota += nota;
                }

                Double media = somaNota / entry.getValue().size();

                historicoDisciplinaDTO.setMedia(media);
                historicoDisciplinaDTO.setRecuperacao(media >= 5 ? "Não" : "Sim");

                if(aulasMap.containsKey(entry.getKey())){
                    historicoDisciplinaDTO.setAulas(aulasMap.get(entry.getKey()));
                }

                if(faltasMap.containsKey(entry.getKey())){
                    historicoDisciplinaDTO.setFaltas(faltasMap.get(entry.getKey()));
                }

                historicoTurmaDTO.getDisciplinas().add(historicoDisciplinaDTO);
            }

            disciplinasNotasMap.clear();
            aulasMap.clear();
            faltasMap.clear();
            if(!historicoTurmaDTO.getDisciplinas().isEmpty()) {
                historicoDTO.getTurmas().add(historicoTurmaDTO);
            }
        }

        return historicoDTO;
    }
}
