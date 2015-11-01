package br.iesb.sie.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.hibernate.Query;

import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.Funcionario;
import br.iesb.sie.model.Perfil;

@Named
public class FuncionarioDAO extends BaseDAO<Funcionario, Long> {

    public FuncionarioDAO() {
        super(Funcionario.class);
    }

    @SuppressWarnings("unchecked")
    public List<Funcionario> buscarFuncionarios(Funcionario filtro) {

        StringBuilder hql = new StringBuilder();
        Map<String, Object> params = new HashMap<>();

        hql.append(" select f from Funcionario f ");
        hql.append(" where 1=1 ");

        if (filtro.getFuncionario() != null) {
            hql.append(" and f.funcionario = :funcionario ");
            params.put("funcionario", filtro.getFuncionario());
        }

        if (filtro.getEscola() != null) {
            hql.append(" and f.escola = :escola");
            params.put("escola", filtro.getEscola());

        }

        if (filtro.getPerfil() != null) {
            hql.append(" and f.perfil = :perfil");
            params.put("perfil", filtro.getPerfil());
        }

        Query query = getSession().createQuery(hql.toString());

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        return query.list();
    }

    @SuppressWarnings("unchecked")
    public List<Funcionario> buscarFuncionarioPorPerfil(Perfil perfil, Entidade funcionario) {
        String hql = " select f from Funcionario f";

        hql += " where f.funcionario = :funcionario ";
        hql += " and f.perfil = :perfil ";
        hql += " and f.vinculoAtivo is true ";

        return getSession().createQuery(hql)
                .setParameter("funcionario", funcionario)
                .setParameter("perfil", perfil)
                .list();
    }
}