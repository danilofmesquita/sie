package br.iesb.sie.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.iesb.sie.dao.FuncionarioDAO;
import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.Funcionario;
import br.iesb.sie.model.Perfil;

@Stateless
public class FuncionarioService extends BaseService {

    /**
     * 
     */
    private static final long serialVersionUID = 31760306067865237L;

    @Inject
    private FuncionarioDAO funcionarioDAO;

    public Funcionario buscarFuncionario(Long id) {
        return funcionarioDAO.get(id);
    }

    public void salvar(Funcionario funcionario) {
        funcionarioDAO.salvar(funcionario);
    }

    public List<Funcionario> buscarFuncionarios(Funcionario filtro) {
        return funcionarioDAO.buscarFuncionarios(filtro);
    }

    public boolean possuiEscolaVinculada(Perfil perfil, Entidade entidade) {
        return funcionarioDAO.buscarFuncionarioPorPerfil(perfil, entidade).size() > 0;
    }
}
