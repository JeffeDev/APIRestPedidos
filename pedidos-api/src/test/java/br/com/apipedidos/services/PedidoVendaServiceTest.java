package br.com.apipedidos.services;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@Profile("test")
class PedidoVendaServiceTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void naodeveriaPermitirGravacaoDePedidoComDadosNulos() throws Exception {
		// Como o @RequestMapping("/auth") nossa URI também sera
		URI uri = new URI("/pedido");
		String json ="    {\r\n"
				+ "        \"numeroPedido\": \"1\",\r\n"
				+ "        \"cliente_id\": \"62e0378984f341c4527629d3\",\r\n"
				+ "        \"dataEmissao\": \"2022-07-28\",\r\n"
				+ "        \"dataEntrega\": \"2022-07-28\",\r\n"
				+ "        \"totalPedido\": \"39.99\"\n"
				+ "    }";
		
		mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(400)); // BadRequest=erro 400
	}


}
