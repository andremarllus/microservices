package br.com.posweb.pos_web_loja.entidades;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


public class LojaComProduto extends Loja {

	@Getter @Setter
	private List<Produto> produtos;

	public LojaComProduto(Loja loja, List<Produto> produtos) {
		super(loja.getId(), loja.getName());
		this.produtos = produtos;
	}
}

