package br.iesb.sie.service;

import br.iesb.sie.dto.EmailCadastroConcluidoDTO;
import br.iesb.sie.entidade.Usuario;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class CadastroService {

    @Inject
    private EntityManager entityManager;

    @Inject
    private SenhaService senhaService;

    @Inject
    private EmailService emailService;

    public void criarNovoUsuaro(Usuario u) {
        String senha = senhaService.criarNovaSenha();

        u.setSenha(senha);
        u.setLogin(criarNovoLogin());

        entityManager.persist(u);
        emailService.enviarEmail(new EmailCadastroConcluidoDTO(u, senha));
    }


    private Integer criarNovoLogin() {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Usuario> c = cb.createQuery(Usuario.class);
        Root<Usuario> root = c.from(Usuario.class);

        c.select(root);
        c.orderBy(cb.desc(root.get("login")));

        TypedQuery<Usuario> query = entityManager.createQuery(c);

        List<Usuario> resultList = query.getResultList();

        if (resultList.isEmpty()) {
            return 1;
        } else {
            return resultList.get(0).getLogin() + 1;
        }

    }
}
