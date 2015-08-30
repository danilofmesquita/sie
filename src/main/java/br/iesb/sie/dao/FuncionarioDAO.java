package br.iesb.sie.dao;

import br.iesb.sie.entidade.Funcionario;
import org.hibernate.Query;

import javax.inject.Named;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
public class FuncionarioDAO extends BaseDAO<Funcionario, Long> {

    public FuncionarioDAO() {
        super(Funcionario.class);
    }

    public List buscarFuncionarios(Funcionario filtro) {

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

}