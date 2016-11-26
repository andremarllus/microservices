package br.com.posweb.webservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.posweb.webservice.entidades.Produto;
import br.com.posweb.webservice.repository.ProdutoRepository;

@Service
@Validated
public class ProdutoServiveImpl implements ProdutoService{

	@Autowired
	private ProdutoRepository repository;
	
	public Produto salvar(Produto produto) {
		return repository.save(produto);
	}

	public Produto getProdutoById(String id) {
		return repository.findOne(id);
	}

	public List<Produto> listAllProdutos() {
		return repository.findAll();
	}

	public Produto update(Produto produto) {
		return repository.save(produto);
	}

	public void delete(String id) {
		repository.delete(id);
	}

}
