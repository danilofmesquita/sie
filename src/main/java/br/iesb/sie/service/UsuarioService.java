package br.iesb.sie.service;

import br.iesb.sie.dao.PerfilDAO;
import br.iesb.sie.dao.UsuarioDAO;
import br.iesb.sie.dto.EmailCadastroConcluidoDTO;
import br.iesb.sie.entidade.Usuario;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UsuarioService {

    @Inject
    private UsuarioDAO usuarioDAO;

    @Inject
    private SenhaService senhaService;

    @Inject
    private EmailService emailService;

    @Inject
    private PerfilDAO perfilDAO;

    public void criarNovoUsuaro(Usuario u) {

        String senha = senhaService.criarNovaSenha();

        u.setSenha(senhaService.codificarSenha(senha));
        u.setLogin(criarNovoLogin());
        u.getPerfis().add(perfilDAO.buscarPerfil("USUARIO"));

        if (u.getTipoPessoa().isJuridica()) {
            u.getPerfis().add(perfilDAO.buscarPerfil("ESCOLA"));
        }

        usuarioDAO.salvar(u);

        emailService.enviarEmail(new EmailCadastroConcluidoDTO(u, senha));
    }

    private Integer criarNovoLogin() {
        return usuarioDAO.buscarUltimoLogin() + 1;
    }

    public Usuario buscarUsuarioPorLogin(String login) {
        return usuarioDAO.buscarUsuarioPorLogin(login);
    }

    public Integer atualizarSenha(Usuario usuario, String senhaAnterior, String novaSenha) {
        if (usuario.getSenha().equals(senhaService.codificarSenha(senhaAnterior))) {
            usuario.setSenha(senhaService.codificarSenha(novaSenha));
            usuarioDAO.salvar(usuario);
            return 1;
        }

        return -1;
    }

}
