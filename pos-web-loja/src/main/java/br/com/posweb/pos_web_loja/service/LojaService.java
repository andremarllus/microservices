package br.com.posweb.pos_web_loja.service;

import java.util.List;

import br.com.posweb.pos_web_loja.entidades.Loja;

public interface LojaService {
	Loja salvar(Loja loja);

	Loja getLojaById(String id);
	
	Loja update(Loja loja);
	
	void delete(String id);
	
	List<Loja> listAllLojas();
}
