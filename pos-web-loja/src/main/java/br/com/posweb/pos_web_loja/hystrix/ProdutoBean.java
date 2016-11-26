package br.com.posweb.pos_web_loja.hystrix;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.posweb.pos_web_loja.entidades.Produto;
import br.com.posweb.pos_web_loja.feign.ProdutosClient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class ProdutoBean {
	
	@Autowired
	private ProdutosClient produtosClient;

	@HystrixCommand(fallbackMethod = "cacheProdutos")
	public List<Produto> getProdutos(String id) {
		return produtosClient.getProdutos(id);
	}

	public List<Produto> cacheProdutos(String id) {
		return Arrays.asList(new Produto("Produto cache", Arrays.asList("123", "456", "789")));
	}
}
