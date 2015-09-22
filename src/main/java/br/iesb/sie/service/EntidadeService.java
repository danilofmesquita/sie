package br.iesb.sie.service;

import br.iesb.sie.dao.EntidadeDAO;
import br.iesb.sie.dto.EmailCadastroConcluidoDTO;
import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.Telefone;
import br.iesb.sie.model.Perfil;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Iterator;
import java.util.List;

@Stateless
public class EntidadeService {

    @Inject
    private EntidadeDAO entidadeDAO;

    @Inject
    private SenhaService senhaService;

    @Inject
    private EmailService emailService;

    public void criarNovoUsuaro(Entidade u) {

        String senha = senhaService.criarNovaSenha();
        ajustarTelefones(u);
        u.setSenha(senhaService.codificarSenha(senha));
        u.setLogin(criarNovoLogin());
        entidadeDAO.salvar(u);

        emailService.enviarEmail(new EmailCadastroConcluidoDTO(u, senha));
    }

    private Integer criarNovoLogin() {
        return entidadeDAO.buscarUltimoLogin() + 1;
    }

    public Entidade buscarEntidadePorLogin(String login) {
        return entidadeDAO.buscarEntidadePorLogin(login);
    }

    public Integer atualizarSenha(Entidade entidade, String senhaAnterior,
                                  String novaSenha) {

        if (entidade.getSenha().equals(senhaService.codificarSenha(senhaAnterior))) {
            entidade.setSenha(senhaService.codificarSenha(novaSenha));
            entidadeDAO.salvar(entidade);
            return 1;
        }

        return -1;
    }

    public List<Entidade> buscarEntidadesPorPerfil(Perfil perfil) {
        return entidadeDAO.buscarEntidadesPorPerfil(perfil);
    }

    public List<Entidade> buscarProfessores(Entidade escola) {
        return entidadeDAO.buscarProfessores(escola);
    }

    public List<Entidade> buscarEscolasVinculadas(Entidade funcionario, Perfil perfil) {
        return entidadeDAO.buscarEscolasVinculadas(funcionario, perfil);
    }

    public List<Entidade> buscarAlunosVinculados(List<Entidade> escolasVinculadas) {
        return entidadeDAO.buscarAlunosVinculados(escolasVinculadas);
    }

    private void ajustarTelefones(Entidade u) {
        Iterator<Telefone> it = u.getTelefones().iterator();
        while (it.hasNext()) {
            Telefone telefone = it.next();
            if (telefone.getNumero() == null) {
                it.remove();
            }
        }
    }
}
