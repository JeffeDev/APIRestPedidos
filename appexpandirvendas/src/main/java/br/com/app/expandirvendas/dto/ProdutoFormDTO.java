package br.com.app.expandirvendas.dto;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import br.com.app.expandirvendas.dao.repository.ProdutoRepository;
import br.com.app.expandirvendas.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProdutoFormDTO {
	
	@NotEmpty(message = "Por favor, informe o nome do cliente")
	private String nome_prod;
	
	@NotEmpty(message = "Por favor, informe o path da imagem")
	private String imagem_prod;
	
	@Min(value=0, message = "Por favor, informe o preço do produto")
	@DecimalMin(value = "0.1")
	private BigDecimal preco_prod;
	
	public ProdutoFormDTO() {
	}

	public Produto converter(ProdutoRepository produtoRepository) {
		return new Produto(nome_prod, imagem_prod, preco_prod);
	}

}
