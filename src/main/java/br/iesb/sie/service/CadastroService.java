package br.iesb.sie.service;

import br.iesb.sie.entidade.Usuario;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class CadastroService {

    @Inject
    private EntityManager entityManager;

    @Inject
    private SenhaService senhaService;

    @Inject
    private EmailService emailService;

    public void criarNovoUsuaro(Usuario u){
        String senha = senhaService.criarNovaSenha();
        //TODO Enviar email

        u.setSenha(senha);
        entityManager.persist(u);
    }


}
