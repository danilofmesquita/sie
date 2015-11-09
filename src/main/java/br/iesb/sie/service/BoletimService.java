package br.iesb.sie.service;


import br.iesb.sie.dto.DisciplinaBoletimDTO;
import br.iesb.sie.dto.ImpressaoBoletimDTO;
import br.iesb.sie.entity.*;
import br.iesb.sie.model.Disciplina;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.LinkedHashMap;
import java.util.Map;

@Stateless
public class BoletimService extends BaseService {

    @Inject
    private TurmaService turmaService;

    public ImpressaoBoletimDTO montarBoletim(Entidade escola, Entidade aluno, Long idTurma) {

        Turma turma = turmaService.buscarTurma(idTurma);
        ImpressaoBoletimDTO impressaoBoletimDTO = new ImpressaoBoletimDTO();
        Map<Disciplina, DisciplinaBoletimDTO> disciplinas = new LinkedHashMap<>();
        Map<Disciplina, Integer> aulasMap = new LinkedHashMap<>();
        Map<Disciplina, Integer> faltasMap = new LinkedHashMap<>();

        impressaoBoletimDTO.setAluno(aluno.getNomeCompleto());
        impressaoBoletimDTO.setMatricula(String.valueOf(aluno.getLogin()));
        impressaoBoletimDTO.setCpf(aluno.getCpfCnpj());
        impressaoBoletimDTO.setEndereco(aluno.getEndereco().getEndereco());
        impressaoBoletimDTO.setEscola(escola.getRazaoSocial());
        impressaoBoletimDTO.setFiliacao(aluno.getFiliacao());
        impressaoBoletimDTO.setNumero(aluno.getEndereco().getNumero());
        impressaoBoletimDTO.setTurma(turma.toString());
        impressaoBoletimDTO.setTurno(turma.getTurno().getDescricao());

        for (NotaLancamento nl : turma.getNotaLancamentos()) {
            if (!disciplinas.containsKey(nl.getDisciplina())) {
                disciplinas.put(nl.getDisciplina(), new DisciplinaBoletimDTO());
            }
            for (Nota n : nl.getNotas()) {
                if (n.getAluno().getId().equals(aluno.getId())) {
                    Double somaAtual = disciplinas.get(nl.getDisciplina()).getSomaTotal();
                    Integer divisorAtual = disciplinas.get(nl.getDisciplina()).getDivisor();
                    disciplinas.get(nl.getDisciplina()).setSomaTotal(somaAtual + n.getNota());
                    disciplinas.get(nl.getDisciplina()).setDivisor(divisorAtual + 1);
                    switch (nl.getBimestre()) {
                        case PRIMEIRO:
                            disciplinas.get(nl.getDisciplina()).setNota1bimestre(n.getNota());
                            break;
                        case SEGUNDO:
                            disciplinas.get(nl.getDisciplina()).setNota2bimestre(n.getNota());
                            break;
                        case TERCEIRO:
                            disciplinas.get(nl.getDisciplina()).setNota3bimestre(n.getNota());
                            break;
                        case QUARTO:
                            disciplinas.get(nl.getDisciplina()).setNota4bimestre(n.getNota());
                            break;
                    }
                }
            }
        }

        for (FrequenciaLancamento fl : turma.getFrequenciaLancamentos()) {
            for (Frequencia f : fl.getFrequencias()) {
                if (f.getAluno().getId().equals(aluno.getId())) {
                    if (!aulasMap.containsKey(fl.getDisciplina())) {
                        aulasMap.put(fl.getDisciplina(), 0);
                    }
                    if (!faltasMap.containsKey(fl.getDisciplina())) {
                        faltasMap.put(fl.getDisciplina(), 0);
                    }
                    aulasMap.put(fl.getDisciplina(), aulasMap.get(fl.getDisciplina()) + 1);
                    if (!f.isPresente()) {
                        faltasMap.put(fl.getDisciplina(), faltasMap.get(fl.getDisciplina()) + 1);
                    }
                }
            }
        }

        for (Map.Entry<Disciplina, DisciplinaBoletimDTO> entry : disciplinas.entrySet()) {
            DisciplinaBoletimDTO db = entry.getValue();
            db.setDisciplina(entry.getKey().getDescricao());
            db.setMediaAnual(db.getSomaTotal() / db.getDivisor());
            if (db.getMediaAnual() <= 5) {
                db.setRecuperacao("Sim");
            } else {
                db.setRecuperacao("Não");
            }

            if (aulasMap.containsKey(entry.getKey())) {
                db.setAulas(aulasMap.get(entry.getKey()));
            }

            if (faltasMap.containsKey(entry.getKey())) {
                db.setFaltas(faltasMap.get(entry.getKey()));
            }

            impressaoBoletimDTO.getDisciplinas().add(db);
        }

        return impressaoBoletimDTO;
    }
}
