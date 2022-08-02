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

import br.com.app.expandirvendas.dao.repository.ProdutoRepository;
import br.com.app.expandirvendas.model.Produto;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ProdutoControllerTestAPI {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void deveriaApenasSimularoMockeDevolverUmaListaVaziadeProdutos() {
		ProdutoRepository mock = Mockito.mock(ProdutoRepository.class);
		List<Produto> todosProdutos=mock.findAll();
		assertTrue(todosProdutos.isEmpty());
	}
	
	@Test
	void deveriaGravarProdutoViaRestRetornandoCodigoResponse() {
		try {
			URI uri = new URI("/produto");
			String json ="    {\r\n"
					+ "        \"nome_prod\": \"Mouse\",\r\n"
					+ "        \"imagem_prod\": \"https://images-na.ssl-images-amazon.com/images/I/51QKWGgl2rL._SY344_BO1,204,203,200_QL70_ML2_.jpg\",\r\n"
					+ "        \"preco_prod\": 1200.00\r\n"
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
	void naodeveriaGravarProdutoComCampoNomeNullo() {
		try {
			URI uri = new URI("/produto");
			String json ="    {\r\n"
					+ "        \"nome_prod\": \"\",\r\n"
					+ "        \"imagem_prod\": \"https://images-na.ssl-images-amazon.com/images/I/51QKWGgl2rL._SY344_BO1,204,203,200_QL70_ML2_.jpg\",\r\n"
					+ "        \"preco_prod\": 1200.00\r\n"
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
	void naoDeveriaPermitirGravarProdutoComCampoCaminhoImagemNullo() {
		try {
			URI uri = new URI("/produto");
			String json ="    {\r\n"
					+ "        \"nome_prod\": \"Mouse\",\r\n"
					+ "        \"imagem_prod\": \"\",\r\n"
					+ "        \"preco_prod\": 1200.00\r\n"
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
	void naoDeveriaGravarProdutoComValorZero() {
		try {
			URI uri = new URI("/produto");
			String json ="    {\r\n"
					+ "        \"nome_prod\": \"Mouse\",\r\n"
					+ "        \"imagem_prod\": \"https://images-na.ssl-images-amazon.com/images/I/51QKWGgl2rL._SY344_BO1,204,203,200_QL70_ML2_.jpg\",\r\n"
					+ "        \"preco_prod\": 0\r\n"
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
	void deveriaDeletarOProduto() {
		try {
			URI uri = new URI("/produto/del/1");

			mockMvc.perform(MockMvcRequestBuilders
				.delete(uri)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().is(200));
			
		}catch (Exception e) {
			System.out.println("Excessão: " + e.getMessage());
		}
	}
	
	@Test
	void naoDeveriaListarUmProdutoDeletado() {
		try {
			URI uri = new URI("/produto/1");

			mockMvc.perform(MockMvcRequestBuilders
				.get(uri)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().is(404));
			
		}catch (Exception e) {
			System.out.println("Excessão: " + e.getMessage());
		}
	}

	@Test
	void deveriaListarTodosOsProdutos() {
		try {
			URI uri = new URI("/produto");

			mockMvc.perform(MockMvcRequestBuilders
				.get(uri)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().is(200));
			
		}catch (Exception e) {
			System.out.println("Excessão: " + e.getMessage());
		}
	}
}
