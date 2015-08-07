package br.iesb.sie.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.iesb.sie.dao.UsuarioDAO;
import br.iesb.sie.dto.EmailCadastroConcluidoDTO;
import br.iesb.sie.entidade.Usuario;

@Stateless
public class CadastroService {

	@Inject
	private UsuarioDAO usuarioDAO;

	@Inject
	private SenhaService senhaService;

	@Inject
	private EmailService emailService;

	public void criarNovoUsuaro(Usuario u) {

		String senha = senhaService.criarNovaSenha();

		u.setSenha(senha);
		u.setLogin(criarNovoLogin());

		adicionarPerfilBasico(u);

		usuarioDAO.salvar(u);

		emailService.enviarEmail(new EmailCadastroConcluidoDTO(u, senha));
	}

	private Integer criarNovoLogin() {
		return usuarioDAO.buscarUltimoLogin() + 1;
	}

	private void adicionarPerfilBasico(Usuario u) {

	}

}
