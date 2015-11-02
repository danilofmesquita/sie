package br.iesb.sie.service;

import br.iesb.sie.dao.TurmaDAO;
import br.iesb.sie.dto.GraficoBarrasDTO;
import br.iesb.sie.entity.*;
import br.iesb.sie.model.Disciplina;
import br.iesb.sie.model.TipoAnalise;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Stateless
public class AnaliseService extends BaseService {

    /**
     *
     */
    private static final long serialVersionUID = -4274795361628074599L;
    @Inject
    private TurmaDAO turmaDAO;

    public GraficoBarrasDTO buscarDadosGraficoFrequencia(Turma turma) {
        Turma t = turmaDAO.get(turma.getId());

        GraficoBarrasDTO graficoBarrasDTO = new GraficoBarrasDTO();

        Map<Long, String> ticksMap = new LinkedHashMap<>();
        Map<Long, Long> barMap = new LinkedHashMap<>();

        for (FrequenciaLancamento fl : t.getFrequenciaLancamentos()) {
            for (Frequencia f : fl.getFrequencias()) {
                if (!ticksMap.containsKey(f.getAluno().getId())) {
                    ticksMap.put(f.getAluno().getId(), f.getAluno().getPrimeiroNome());
                }
                if (f.isPresente()) {
                    if (!barMap.containsKey(f.getAluno().getId())) {
                        barMap.put(f.getAluno().getId(), 1L);
                    } else {
                        Long value = barMap.get(f.getAluno().getId());
                        barMap.put(f.getAluno().getId(), value + 1L);
                    }
                }
            }
        }

        graficoBarrasDTO.setTicks(new ArrayList<>(ticksMap.values()));
        graficoBarrasDTO.setBars(Collections.singletonList(new ArrayList<>(barMap.values())));

        return graficoBarrasDTO;
    }

    public GraficoBarrasDTO buscarDadosGraficoNota(TipoAnalise tipoAnalise, Turma turma, Entidade aluno,
                                                   Disciplina disciplina) {

        Turma t = turmaDAO.get(turma.getId());
        GraficoBarrasDTO graficoBarrasDTO = new GraficoBarrasDTO();
        Map<Object, String> ticksMap = new LinkedHashMap<>();
        Map<Object, Double> barMap = new LinkedHashMap<>();

        if (tipoAnalise.isColetiva()) {
            for (NotaLancamento nl : t.getNotaLancamentos()) {
                if (nl.getDisciplina().equals(disciplina)) {
                    for (Nota n : nl.getNotas()) {
                        if (!ticksMap.containsKey(n.getAluno().getId())) {
                            ticksMap.put(n.getAluno().getId(), n.getAluno().getPrimeiroNome());
                        }
                        if (!barMap.containsKey(n.getAluno().getId())) {
                            barMap.put(n.getAluno().getId(), n.getNota());
                        } else {
                            Double value = barMap.get(n.getAluno().getId());
                            barMap.put(n.getAluno().getId(), (value + n.getNota()) / 2);
                        }
                    }
                }
            }
        } else if (tipoAnalise.isIndividial()) {
            for (NotaLancamento nl : t.getNotaLancamentos()) {
                for (Nota n : nl.getNotas()) {
                    if (n.getAluno().getId().equals(aluno.getId())) {
                        if (!ticksMap.containsKey(n.getLancamento().getDisciplina())) {
                            ticksMap.put(n.getLancamento().getDisciplina(), n.getLancamento().getDisciplina().getDescricao());
                        }
                        if (!barMap.containsKey(n.getLancamento().getDisciplina())) {
                            barMap.put(n.getLancamento().getDisciplina(), n.getNota());
                        } else {
                            Double value = barMap.get(n.getLancamento().getDisciplina());
                            barMap.put(n.getLancamento().getDisciplina(), (value + n.getNota()) / 2);
                        }
                    }
                }
            }
        }

        graficoBarrasDTO.setTicks(new ArrayList<>(ticksMap.values()));
        graficoBarrasDTO.setBars(Collections.singletonList(new ArrayList<>(barMap.values())));

        return graficoBarrasDTO;
    }

}
