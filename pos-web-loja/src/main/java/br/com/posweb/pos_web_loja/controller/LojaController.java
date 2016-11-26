package br.com.posweb.pos_web_loja.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.posweb.pos_web_loja.entidades.Loja;
import br.com.posweb.pos_web_loja.entidades.LojaComProduto;
import br.com.posweb.pos_web_loja.hystrix.ProdutoBean;
import br.com.posweb.pos_web_loja.service.LojaService;

@RestController
public class LojaController {

	@Autowired
	private ProdutoBean produtoBean;
	
	@Autowired
	private LojaService lojaService;

	
	@RequestMapping(value = "/lojas", method = RequestMethod.GET)
	public ResponseEntity<List<Loja>> listAllProdutos() {
		return new ResponseEntity< List<Loja> >(lojaService.listAllLojas(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/lojas/{codigoLoja}", method = RequestMethod.GET)
	public ResponseEntity<Loja> getLoja(@PathVariable String codigoLoja) {
		
		Loja loja =  lojaService.getLojaById(codigoLoja);
		
		return loja == null ? 
				new ResponseEntity<Loja>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Loja>(loja, HttpStatus.OK);
	}
	
	@RequestMapping(value="/loja", method = RequestMethod.POST)
	public ResponseEntity<String> criarLoja(@RequestBody Loja produto) {

		try {
			
			lojaService.salvar(produto);
			
			return new ResponseEntity<String>(HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/loja/{codigoLoja}", method = RequestMethod.PUT)
	public ResponseEntity<String> alterarLoja(@RequestBody Loja loja) {
		
		try {
			
			lojaService.update(loja);
			
			return new ResponseEntity<String>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/loja/{codigoLoja}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletarProduto(@PathVariable String codigoLoja) {
		
		try {
			
			lojaService.delete(codigoLoja);
			return new ResponseEntity<String>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	public LojaController() {
	}

	@RequestMapping("/")
	public List<Loja> getLojas() {
		return lojaService.listAllLojas();
	}

//	
//	@RequestMapping("/produtos")
//	public List<LojaComProduto> getLojasComProdutos() {
//		List<LojaComProduto> returnLojas = new ArrayList<LojaComProduto>();
//		
//		lojas = lojaService.listAllLojas();
//		
//		for (Loja loja : lojas) {
//			returnLojas.add(new LojaComProduto(loja, produtoBean.getProdutos(loja.getId())));
//		}
//		
//		return returnLojas;
//	}
//	
//	@RequestMapping("/lojas/{codigoLoja}/produtos")
//	public List<LojaComProduto> obterLojasComProdutos(@PathVariable String codigoLoja) {
//		List<LojaComProduto> returnLojas = new ArrayList<LojaComProduto>();
//		
//		lojas = lojaService.listAllLojas();
//		
//		for (Loja loja : lojas) {
//			returnLojas.add(new LojaComProduto(loja, produtoBean.getProdutos(loja.getId())));
//		}
//		
//		return returnLojas;
//	}
}
