package br.iesb.sie.service;

import br.iesb.sie.entidade.Usuario;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class CadastroService {

    @Inject
    private EntityManager entityManager;

    public void salvar(Usuario usuario){
        entityManager.persist(usuario);
    }

}
