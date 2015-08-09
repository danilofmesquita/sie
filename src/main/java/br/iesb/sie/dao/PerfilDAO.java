package br.iesb.sie.dao;

import br.iesb.sie.entidade.Perfil;
import org.hibernate.Query;

import javax.inject.Named;

@Named
public class PerfilDAO extends BaseDAO<Perfil, Long> {

    public PerfilDAO() {
        super(Perfil.class);
    }

    public Perfil buscarPerfil(String nome) {
        String hqlQuery = "select p from Perfil p where p.nome = :nome ";
        Query query = getSession().createQuery(hqlQuery);

        query.setParameter("nome", nome);
        Perfil perfil = (Perfil) query.uniqueResult();

        if (perfil == null) {
            getSession().save(new Perfil(nome));
            return buscarPerfil(nome);
        } else {
            return perfil;
        }
    }


}
