package br.iesb.sie.dao;

import br.iesb.sie.entidade.Entidade;
import br.iesb.sie.entidade.Funcionario;
import br.iesb.sie.model.TipoPessoa;
import org.hibernate.Query;

import javax.inject.Named;
import java.util.List;

@Named
public class FuncionarioDAO extends BaseDAO<Funcionario, Long> {

    public FuncionarioDAO() {
        super(Funcionario.class);
    }

    public List<Entidade> buscarFuncionarios() {
        return getSession().createQuery(" select e from Entidade e where e.tipoPessoa = :pf ")
                .setParameter("pf", TipoPessoa.FISICA).list();
    }

    public List<Funcionario> buscarFuncionarios(Entidade escola) {
        String hql = " select f from Funcionario f ";

        if (escola != null) {
            hql += " where f.escola = :escola ";
        }

        Query query = getSession().createQuery(hql);

        if (escola != null) {
            query.setParameter("escola", escola);
        }

        return query.list();
    }
}
