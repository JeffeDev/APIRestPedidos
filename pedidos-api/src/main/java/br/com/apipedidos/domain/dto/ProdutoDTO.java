package br.com.apipedidos.domain.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.apipedidos.domain.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProdutoDTO {
	
	private Long id_prod;
	private String nome_prod;
	private String imagem_prod;
	private BigDecimal preco_prod;
	
	public ProdutoDTO(Produto produto) {
		this.id_prod = produto.getId_prod();
		this.nome_prod = produto.getNome_prod();
		this.imagem_prod = produto.getImagem_prod();
		this.preco_prod = produto.getPreco_prod();
	}
	
	public static List<ProdutoDTO> converter(List<Produto> produto) {
		return produto.stream().map(ProdutoDTO::new).collect(Collectors.toList());
	}

}
