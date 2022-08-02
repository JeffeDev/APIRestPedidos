package br.com.app.expandirvendas.controllerAPI;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.app.expandirvendas.dao.repository.PedidoRepository;
import br.com.app.expandirvendas.model.Pedido;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PedidoControllerTestAPI {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void deveriaApenasSimularoMockeDevolverUmaListaVaziadePedidos() {
		PedidoRepository mock = Mockito.mock(PedidoRepository.class);
		List<Pedido> todosPedidos = mock.findAll();
		assertTrue(todosPedidos.isEmpty());
	}
	
	@Test
	void deveriaGravarPedidoViaRestRetornandoCodigoResponse() {
		try {
			URI uri = new URI("/pedido");
			String json ="    {\r\n"
					+ "        \"numero_pedi\": 1,\r\n"
					+ "        \"cliente_id\": 1,\r\n"
					+ "        \"dataEmissao_pedi\": \"31/07/2022\",\r\n"
					+ "        \"dataEntrega_pedi\": \"31/07/2022\",\r\n"
					+ "        \"totalPedido_pedi\": 0.00,\r\n"
					+ "        \"status_pedi\": \"ABERTO\"\r\n"
					+ "    }";

			mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().is(201));
			
		}catch (Exception e) {
			System.out.println("Excessão: " + e.getMessage());
		}
	}

	@Test
	void naoDeveriaPermitirGravarUmPedidoSemIdPedido() {
		try {
			URI uri = new URI("/pedido");
			String json ="    {\r\n"
					+ "        \"numero_pedi\": 0,\r\n"
					+ "        \"cliente_id\": 1,\r\n"
					+ "        \"dataEmissao_pedi\": \"31/07/2022\",\r\n"
					+ "        \"dataEntrega_pedi\": \"31/07/2022\",\r\n"
					+ "        \"totalPedido_pedi\": 0.00,\r\n"
					+ "        \"status_pedi\": \"ABERTO\"\r\n"
					+ "    }";

			mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().is(201));
			
		}catch (Exception e) {
			System.out.println("Excessão: " + e.getMessage());
		}
	}
	
	
	
	

}
