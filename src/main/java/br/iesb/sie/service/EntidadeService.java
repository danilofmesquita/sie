package br.iesb.sie.service;

import br.iesb.sie.dao.PerfilDAO;
import br.iesb.sie.dao.EntidadeDAO;
import br.iesb.sie.dto.EmailCadastroConcluidoDTO;
import br.iesb.sie.entidade.Entidade;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EntidadeService {

    @Inject
    private EntidadeDAO entidadeDAO;

    @Inject
    private SenhaService senhaService;

    @Inject
    private EmailService emailService;

    @Inject
    private PerfilDAO perfilDAO;

    public void criarNovoUsuaro(Entidade u) {

        String senha = senhaService.criarNovaSenha();

        u.setSenha(senhaService.codificarSenha(senha));
        u.setLogin(criarNovoLogin());
        u.getPerfis().add(perfilDAO.buscarPerfil("USUARIO"));

        if (u.getTipoPessoa().isJuridica()) {
            u.getPerfis().add(perfilDAO.buscarPerfil("ESCOLA"));
        }

        entidadeDAO.salvar(u);

        emailService.enviarEmail(new EmailCadastroConcluidoDTO(u, senha));
    }

    private Integer criarNovoLogin() {
        return entidadeDAO.buscarUltimoLogin() + 1;
    }

    public Entidade buscarEntidadePorLogin(String login) {
        return entidadeDAO.buscarEntidadePorLogin(login);
    }

    public Integer atualizarSenha(Entidade entidade, String senhaAnterior, String novaSenha) {
        if (entidade.getSenha().equals(senhaService.codificarSenha(senhaAnterior))) {
            entidade.setSenha(senhaService.codificarSenha(novaSenha));
            entidadeDAO.salvar(entidade);
            return 1;
        }

        return -1;
    }

}
