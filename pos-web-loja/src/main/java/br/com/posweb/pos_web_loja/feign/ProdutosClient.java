package br.com.posweb.pos_web_loja.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.posweb.pos_web_loja.entidades.Produto;

@FeignClient("produtos")
public interface ProdutosClient {
	@RequestMapping(method = RequestMethod.GET, value = "/lojas/{id}")
	List<Produto> getProdutos(@PathVariable("id") String id);
}
