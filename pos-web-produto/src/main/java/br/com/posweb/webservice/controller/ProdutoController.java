package br.com.posweb.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.posweb.webservice.entidades.Produto;
import br.com.posweb.webservice.service.ProdutoService;

@RestController
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value = "/produtos", method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> listAllProdutos() {
		return new ResponseEntity< List<Produto> >(produtoService.listAllProdutos(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/produtos/{codigoProduto}", method = RequestMethod.GET)
	public ResponseEntity<Produto> getProduto(@PathVariable String codigoProduto) {
		
		Produto produto =  produtoService.getProdutoById(codigoProduto);
		
		return produto == null ? 
				new ResponseEntity<Produto>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}

	
	@RequestMapping(value="/produto", method = RequestMethod.POST)
	public ResponseEntity<String> criarProduto(@RequestBody Produto produto) {

		try {
			
			produtoService.salvar(produto);
			
			return new ResponseEntity<String>(HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/produto/{codigoProduto}", method = RequestMethod.PUT)
	public ResponseEntity<String> alterarProduto(@RequestBody Produto produto) {
		
		try {
			
			produtoService.update(produto);
			
			return new ResponseEntity<String>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/produto/{codigoProduto}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletarProduto(@PathVariable String codigoProduto) {
		
		try {
			
			produtoService.delete(codigoProduto);
			return new ResponseEntity<String>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
