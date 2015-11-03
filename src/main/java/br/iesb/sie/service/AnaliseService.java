package br.iesb.sie.service;

import br.iesb.sie.dao.TurmaDAO;
import br.iesb.sie.dto.GraficoBarrasDTO;
import br.iesb.sie.entity.*;
import br.iesb.sie.model.Disciplina;
import br.iesb.sie.model.TipoAnalise;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

@Stateless
public class AnaliseService extends BaseService {

    /**
     *
     */
    private static final long serialVersionUID = -4274795361628074599L;

    @Inject
    private TurmaDAO turmaDAO;

    public GraficoBarrasDTO buscarDadosGraficoFrequencia(TipoAnalise tipoAnalise, Turma turma, Entidade aluno,
                                                         Disciplina disciplina) {
        Turma t = turmaDAO.get(turma.getId());

        GraficoBarrasDTO graficoBarrasDTO = new GraficoBarrasDTO();

        Map<Object, String> ticksMap = new LinkedHashMap<>();
        Map<Object, Double> barMap = new LinkedHashMap<>();

        if (tipoAnalise.isColetiva()) {

            Double totalAulas = (double) t.getFrequenciaLancamentos().stream()
                    .filter((fl) -> fl.getDisciplina().equals(disciplina)).collect(Collectors.toList()).size();

            for (FrequenciaLancamento fl : t.getFrequenciaLancamentos()) {
                if (fl.getDisciplina().equals(disciplina)) {
                    for (Frequencia f : fl.getFrequencias()) {
                        if (!ticksMap.containsKey(f.getAluno().getId())) {
                            ticksMap.put(f.getAluno().getId(), f.getAluno().getPrimeiroNome());
                        }
                        if (f.isPresente()) {
                            if (!barMap.containsKey(f.getAluno().getId())) {
                                barMap.put(f.getAluno().getId(), calcularPercentual(totalAulas, 1D, 100D));
                            } else {
                                Double value = barMap.get(f.getAluno().getId());
                                barMap.put(f.getAluno().getId(), value + calcularPercentual(totalAulas, 1D, 100D));
                            }
                        }
                    }
                }
            }
        } else if (tipoAnalise.isIndividial()) {
            for (FrequenciaLancamento fl : t.getFrequenciaLancamentos()) {

                Double totalAulas = (double) t.getFrequenciaLancamentos().stream()
                        .filter((_fl) -> _fl.getDisciplina().equals(fl.getDisciplina())).collect(Collectors.toList()).size();

                for (Frequencia f : fl.getFrequencias()) {
                    if (f.getAluno().getId().equals(aluno.getId())) {
                        if (!ticksMap.containsKey(f.getLancamento().getDisciplina())) {
                            ticksMap.put(f.getLancamento().getDisciplina(), f.getLancamento().getDisciplina().getDescricao());
                        }
                        if (f.isPresente()) {
                            if (!barMap.containsKey(f.getLancamento().getDisciplina())) {
                                barMap.put(f.getLancamento().getDisciplina(), calcularPercentual(totalAulas, 1D, 100D));
                            } else {
                                Double value = barMap.get(f.getLancamento().getDisciplina());
                                barMap.put(f.getLancamento().getDisciplina(), value + calcularPercentual(totalAulas, 1D, 100D));
                            }
                        }
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

    public GraficoBarrasDTO buscarDadosGraficoFrequenciaNota(TipoAnalise tipoAnalise, Turma turma, Entidade aluno,
                                                             Disciplina disciplina) {

        Turma t = turmaDAO.get(turma.getId());
        GraficoBarrasDTO graficoBarrasDTO = new GraficoBarrasDTO();
        Map<Object, String> ticksMap = new LinkedHashMap<>();
        Map<Object, Double> barNotasMap = new LinkedHashMap<>();
        Map<Object, Double> barFreqenciaMap = new LinkedHashMap<>();

        if (tipoAnalise.isColetiva()) {
            for (NotaLancamento nl : t.getNotaLancamentos()) {
                if (nl.getDisciplina().equals(disciplina)) {
                    for (Nota n : nl.getNotas()) {
                        if (!ticksMap.containsKey(n.getAluno().getId())) {
                            ticksMap.put(n.getAluno().getId(), n.getAluno().getPrimeiroNome());
                        }
                        if (!barNotasMap.containsKey(n.getAluno().getId())) {
                            barNotasMap.put(n.getAluno().getId(), n.getNota());
                        } else {
                            Double value = barNotasMap.get(n.getAluno().getId());
                            barNotasMap.put(n.getAluno().getId(), (value + n.getNota()) / 2);
                        }
                    }
                }
            }

            Double totalAulas = (double) t.getFrequenciaLancamentos().stream()
                    .filter((fl) -> fl.getDisciplina().equals(disciplina)).collect(Collectors.toList()).size();

            for (FrequenciaLancamento fl : t.getFrequenciaLancamentos()) {
                if (fl.getDisciplina().equals(disciplina)) {
                    for (Frequencia f : fl.getFrequencias()) {
                        if (f.isPresente()) {
                            if (!ticksMap.containsKey(f.getAluno().getId())) {
                                ticksMap.put(f.getAluno().getId(), f.getAluno().getPrimeiroNome());
                            }
                            if (!barFreqenciaMap.containsKey(f.getAluno().getId())) {
                                barFreqenciaMap.put(f.getAluno().getId(), calcularPercentual(totalAulas, 1D, 10D));
                            } else {
                                Double value = barFreqenciaMap.get(f.getAluno().getId());
                                barFreqenciaMap.put(f.getAluno().getId(), calcularPercentual(totalAulas, 1D, 10D) + value);
                            }
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
                        if (!barNotasMap.containsKey(n.getLancamento().getDisciplina())) {
                            barNotasMap.put(n.getLancamento().getDisciplina(), n.getNota());
                        } else {
                            Double value = barNotasMap.get(n.getLancamento().getDisciplina());
                            barNotasMap.put(n.getLancamento().getDisciplina(), (value + n.getNota()) / 2);
                        }
                    }
                }
            }

            for (FrequenciaLancamento fl : t.getFrequenciaLancamentos()) {

                Double totalAulas = (double) t.getFrequenciaLancamentos().stream()
                        .filter((_fl) -> _fl.getDisciplina().equals(fl.getDisciplina())).collect(Collectors.toList()).size();

                for (Frequencia f : fl.getFrequencias()) {
                    if (f.getAluno().getId().equals(aluno.getId()) && f.isPresente()) {
                        if (!ticksMap.containsKey(f.getAluno().getId())) {
                            ticksMap.put(f.getLancamento().getDisciplina(), f.getLancamento().getDisciplina().getDescricao());
                        }
                        if (!barFreqenciaMap.containsKey(f.getLancamento().getDisciplina())) {
                            barFreqenciaMap.put(f.getLancamento().getDisciplina(), calcularPercentual(totalAulas, 1D, 10D));
                        } else {
                            Double value = barFreqenciaMap.get(f.getLancamento().getDisciplina());
                            barFreqenciaMap.put(f.getLancamento().getDisciplina(), calcularPercentual(totalAulas, 1D, 10D) + value);
                        }
                    }
                }
            }
        }

        graficoBarrasDTO.setTicks(new ArrayList<>(ticksMap.values()));
        graficoBarrasDTO.setBars(Arrays.asList(new ArrayList<>(barFreqenciaMap.values()), new ArrayList<>(barNotasMap.values())));

        return graficoBarrasDTO;
    }

    private Double calcularPercentual(Double total, Double valor, Double base) {
        return valor * base / total;
    }

}
