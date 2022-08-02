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

import br.com.app.expandirvendas.dao.repository.ClienteRepository;
import br.com.app.expandirvendas.model.Cliente;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ClienteControllerTestAPI {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void deveriaApenasSimularoMockeDevolverUmaListaVaziadeClientes() {
		ClienteRepository mock = Mockito.mock(ClienteRepository.class);
		List<Cliente> todosClientes=mock.findAll();
		assertTrue(todosClientes.isEmpty());
	}
	
	@Test
	void deveriaGravarClienteViaResteRetornandoCodigo() {
		try {
			URI uri = new URI("/cliente");
			String json ="{\r\n"
				+ "         \"nome_cli\": \"Jefferson Cesar de Souza\",\r\n"
				+ "        \"tipoPessoa_cli\": \"FISICA\",\r\n"
				+ "        \"telefone_cli\": \"(48) 99967-9641\",\r\n"
				+ "        \"email_cli\": \"ca.info@gmail.com\",\r\n"
				+ "        \"documento_cli\": \"122.051.112-12\"\r\n"
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
	void naoDeveriaGravarClienteViaRestComNomeNulo() {
		try {
			URI uri = new URI("/cliente");
			String json ="{\r\n"
				+ "         \"nome_cli\": \"\",\r\n"
				+ "        \"tipoPessoa_cli\": \"FISICA\",\r\n"
				+ "        \"telefone_cli\": \"(48) 99967-9641\",\r\n"
				+ "        \"email_cli\": \"ca.info@gmail.com\",\r\n"
				+ "        \"documento_cli\": \"122.051.112-12\"\r\n"
				+ "    }";

			mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().is(400));
			
		}catch (Exception e) {
			System.out.println("Excessão: " + e.getMessage());
		}
	}
	
	@Test
	void naoDeveriaGravarClienteComCampoTipoPessoaDiferenteDeFISICAeJURIDICA() {
		try {
			URI uri = new URI("/cliente");
			String json ="{\r\n"
				+ "         \"nome_cli\": Jefferson\"\",\r\n"
				+ "        \"tipoPessoa_cli\": \"FI\",\r\n"
				+ "        \"telefone_cli\": \"(48) 99967-9641\",\r\n"
				+ "        \"email_cli\": \"ca.info@gmail.com\",\r\n"
				+ "        \"documento_cli\": \"122.051.112-12\"\r\n"
				+ "    }";

			mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().is(400));
			
		}catch (Exception e) {
			System.out.println("Excessão: " + e.getMessage());
		}
	}
	@Test
	void naoDeveriaGravarClienteComCampoEmailInvalido() {
		try {
			URI uri = new URI("/cliente");
			String json ="{\r\n"
				+ "         \"nome_cli\": Jefferson\"\",\r\n"
				+ "        \"tipoPessoa_cli\": \"JURIDICA\",\r\n"
				+ "        \"telefone_cli\": \"(48) 99967-9641\",\r\n"
				+ "        \"email_cli\": \"invalido\",\r\n"
				+ "        \"documento_cli\": \"122.051.112-12\"\r\n"
				+ "    }";

			mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().is(400));
			
		}catch (Exception e) {
			System.out.println("Excessão: " + e.getMessage());
		}
	}
	@Test
	void naoDeveriaGravarClienteComCampoCPFNullo() {
		try {
			URI uri = new URI("/cliente");
			String json ="{\r\n"
				+ "         \"nome_cli\": Jefferson\"\",\r\n"
				+ "        \"tipoPessoa_cli\": \"FISICA\",\r\n"
				+ "        \"telefone_cli\": \"(48) 99967-9641\",\r\n"
				+ "        \"email_cli\": \"ca.info@gmail.com\",\r\n"
				+ "        \"documento_cli\": \"\"\r\n"
				+ "    }";

			mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().is(400));
			
		}catch (Exception e) {
			System.out.println("Excessão: " + e.getMessage());
		}
	}
	@Test
	void deveriaPermitirExcluirUmCliente() {
		try {
			URI uri = new URI("/cliente/del/1");
			mockMvc.perform(MockMvcRequestBuilders
				.delete(uri)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().is(200));
			
		}catch (Exception e) {
			System.out.println("Excessão: " + e.getMessage());
		}
	}
	@Test
	void confirmarSeoClienteFoiRealmenteExcluido() {
		try {
			URI uri = new URI("/cliente/del/1");
			mockMvc.perform(MockMvcRequestBuilders
				.delete(uri)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().is(500));
			
		}catch (Exception e) {
			System.out.println("Excessão: " + e.getMessage());
		}
	}
	@Test
	void deveriaListarTodosOsClientes() {
		try {
			URI uri = new URI("/cliente");

			mockMvc.perform(MockMvcRequestBuilders
				.get(uri)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().is(200));
			
		}catch (Exception e) {
			System.out.println("Excessão: " + e.getMessage());
		}
	}
	
	@Test
	void deveriaListaroClienteNumeroDois() {
		try {
			URI uri = new URI("/cliente/2");
			mockMvc.perform(MockMvcRequestBuilders
				.get(uri)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().is(200));
			
		}catch (Exception e) {
			System.out.println("Excessão: " + e.getMessage());
		}
	}



}
