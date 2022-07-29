package br.com.apipedidos.services;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ClienteServiceTest {
	@Autowired
    private MockMvc mockMvc;

	@Test
	void naodeveriaPermitirGravacaoDeClienteComDadosNulos() throws Exception {
		URI uri = new URI("/cliente");

		String json ="    {\r\n"
				+ "    \"nome\": \"\", \r\n"
				+ "    \"tipoPessoa\": \"FISICA\", \r\n"
				+ "    \"telefone\": \"(48)99999-5555\", \r\n"
				+ "    \"email\": \"\",\r\n"
				+ "    \"documento\": \"111.111.111-11\"\r\n"
				+ "    }";
		
		mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(400)); // BadRequest=erro 400
	}


}
