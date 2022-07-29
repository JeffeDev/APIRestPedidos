package br.com.apipedidos.services;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@Profile("test")
class PedidoItemServiceTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
