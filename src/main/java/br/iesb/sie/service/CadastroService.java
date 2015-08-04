package br.iesb.sie.service;

import br.iesb.sie.dto.EmailCadastroConcluidoDTO;
import br.iesb.sie.entidade.Usuario;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

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

        u.setSenha(senha);
        u.setLogin(criarNovoLogin());

        entityManager.persist(u);
        emailService.enviarEmail(new EmailCadastroConcluidoDTO(u,senha));
    }


    private Integer criarNovoLogin(){
        StringBuilder hql = new StringBuilder();

        hql.append(" SELECT U.login FROM ").append(Usuario.class.getName()).append(" U ");
        hql.append(" ORDER BY U.login DESC ");

        List<Integer> resultList = entityManager.createQuery(hql.toString()).setMaxResults(1).getResultList();


        if(resultList.isEmpty()){
            return 1;
        } else {
            return resultList.get(0) + 1;
        }

    }
}
