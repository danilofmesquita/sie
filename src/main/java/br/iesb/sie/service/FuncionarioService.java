package br.iesb.sie.service;

import br.iesb.sie.dao.EntidadeDAO;
import br.iesb.sie.dao.FuncionarioDAO;
import br.iesb.sie.entidade.Funcionario;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class FuncionarioService {

    @Inject
    private FuncionarioDAO funcionarioDAO;

    @Inject
    private EntidadeDAO entidadeDAO;

    public Funcionario buscarFuncionario(Long id) {
        return funcionarioDAO.get(id);
    }

    public void salvar(Funcionario funcionario) {
        funcionarioDAO.salvar(funcionario);
    }

    public List<Funcionario> buscarFuncionarios(Funcionario filtro) {
        return funcionarioDAO.buscarFuncionarios(filtro);
    }
}
