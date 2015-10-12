package br.iesb.sie.dto;

import br.iesb.sie.entity.Entidade;

public class EmailCadastroConcluidoDTO extends EmailDTO {

    public EmailCadastroConcluidoDTO(Entidade u, String senha) {
        super();

        StringBuilder conteudo = new StringBuilder();

        conteudo.append("Seu cadastro foi realizado com sucesso, dados para acesso:\n\n");
        conteudo.append(String.format("Login: %s\n", u.getLogin()));
        conteudo.append(String.format("Senha: %s\n", senha));

        addDestino(u.getEmail());
        addAssunto("[SIE] Cadastro Concluído com Sucesso !");
        addConteudo(conteudo.toString());
    }
}
