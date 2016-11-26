package br.com.posweb.webservice.service;

import java.util.List;

import br.com.posweb.webservice.entidades.Produto;

public interface ProdutoService {
	Produto salvar(Produto produto);

	Produto getProdutoById(String id);
	
	Produto update(Produto produto);
	
	void delete(String id);
	
	List<Produto> listAllProdutos();
}
