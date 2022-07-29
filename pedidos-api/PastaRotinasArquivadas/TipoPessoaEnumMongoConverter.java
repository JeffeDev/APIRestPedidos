package br.com.apipedidos;

import org.springframework.core.convert.converter.Converter;

import br.com.apipedidos.domain.entity.TipoPessoaEnum;

public class TipoPessoaEnumMongoConverter implements Converter<String, TipoPessoaEnum> {
	
	@Override
	public TipoPessoaEnum convert(final String source) {
		for (final TipoPessoaEnum TipoPessoaEnum : TipoPessoaEnum.values()) {
			if (TipoPessoaEnum.name().equals(source)) {
				return TipoPessoaEnum;
			}
		}
		return null;
	}
}