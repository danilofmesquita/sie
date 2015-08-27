package br.iesb.sie.service;

import br.iesb.sie.dao.EntidadeDAO;
import br.iesb.sie.dao.FuncionarioDAO;
import br.iesb.sie.entidade.Entidade;
import br.iesb.sie.entidade.Funcionario;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Stateless
public class FuncionarioService {

    @Inject
    private FuncionarioDAO funcionarioDAO;

    @Inject
    private EntidadeDAO entidadeDAO;

    public Funcionario buscarFuncionario(Long id){
        return funcionarioDAO.get(id);
    }

    public List<Entidade> buscarFuncionarios(){
        return funcionarioDAO.buscarFuncionarios();
    }

    public List<Entidade> buscarEscolas() {
        return entidadeDAO.buscarEscolas();
    }

    public void salvar(Funcionario funcionario) {
        funcionarioDAO.salvar(funcionario);
    }

    public List<Funcionario> buscarFuncionarios(Entidade escola) {
        return funcionarioDAO.buscarFuncionarios(escola);
    }
}
