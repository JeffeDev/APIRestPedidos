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
class ProdutoServiceTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void naodeveriaPermitirGravacaoDeProdutoComDadosNulos() throws Exception {
		// Como o @RequestMapping("/auth") nossa URI também sera
		URI uri = new URI("/produto");
		String json ="    {\r\n"
				+ "        \"nome\": \"\",\r\n"
				+ "        \"image\": \"https://m.media-amazon.com/images/I/41x3zWFV9xL.jpg\",\r\n"
				+ "        \"preco\": 39.99\r\n"
				+ "    }";
		
		mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(400)); // BadRequest=erro 400
	}

}
