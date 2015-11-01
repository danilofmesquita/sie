package br.iesb.sie.service;

import java.io.StringReader;

import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import br.iesb.sie.entity.Endereco;
import br.iesb.sie.model.UF;

@Stateless
public class CEPService extends BaseService {

    /**
     * 
     */
    private static final long serialVersionUID = -6398775136475374261L;

    public Endereco buscarEnderecoPorCEP(Integer cep) {

        Endereco endereco = new Endereco();

        try {

            Client client = ClientBuilder.newClient();

            Response response = client.target("http://cep.republicavirtual.com.br/web_cep.php").queryParam("cep", cep)
                    .queryParam("formato", "json").request().get();

            JsonReader reader = Json.createReader(new StringReader(response.readEntity(String.class)));
            JsonObject jsonObject = reader.readObject();

            endereco.setCep(cep);
            endereco.setBairro(jsonObject.getString("bairro"));
            endereco.setMunicipio(jsonObject.getString("cidade"));
            endereco.setEndereco(jsonObject.getString("logradouro"));
            endereco.setUf(UF.valueOf(jsonObject.getString("uf").toUpperCase()));

            return endereco;

        } catch (Exception e) {
            endereco = new Endereco();
            endereco.setCep(cep);
        }

        return endereco;
    }
}
