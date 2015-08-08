package br.iesb.sie.service;

import br.iesb.sie.dao.PerfilDAO;
import br.iesb.sie.dao.UsuarioDAO;
import br.iesb.sie.dto.EmailCadastroConcluidoDTO;
import br.iesb.sie.entidade.Usuario;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CadastroService {

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

		u.setSenha(senha);
		u.setLogin(criarNovoLogin());
		u.getPerfis().add(perfilDAO.buscarPerfil("USUARIO"));

		usuarioDAO.salvar(u);

		emailService.enviarEmail(new EmailCadastroConcluidoDTO(u, senha));
	}

	private Integer criarNovoLogin() {
		return usuarioDAO.buscarUltimoLogin() + 1;
	}

}
