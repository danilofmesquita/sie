package br.iesb.sie.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.iesb.sie.dao.TurmaDAO;
import br.iesb.sie.dto.FrequenciaDTO;
import br.iesb.sie.entity.Frequencia;
import br.iesb.sie.entity.FrequenciaLancamento;
import br.iesb.sie.entity.Turma;

@Stateless
public class AnaliseService extends BaseService {

    /**
     * 
     */
    private static final long serialVersionUID = -4274795361628074599L;
    @Inject
    private TurmaDAO turmaDAO;

    public FrequenciaDTO buscarDadosGraficoFrequencia(Turma turma) {
        Turma t = turmaDAO.get(turma.getId());

        FrequenciaDTO frequenciaDTO = new FrequenciaDTO();

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

        frequenciaDTO.setTicks(new ArrayList<>(ticksMap.values()));
        frequenciaDTO.setBars(Arrays.asList(new ArrayList<>(barMap.values())));

        return frequenciaDTO;
    }

}
