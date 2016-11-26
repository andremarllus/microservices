package br.com.posweb.pos_web_loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.posweb.pos_web_loja.entidades.Loja;
import br.com.posweb.pos_web_loja.repository.LojaRepository;

@Service
@Validated
public class LojaServiceImpl implements LojaService{

	@Autowired
	private LojaRepository repository;
	
	public Loja salvar(Loja loja) {
		return repository.save(loja);
	}

	public Loja getLojaById(String id) {
		return repository.findOne(id);
	}

	public Loja update(Loja loja) {
		return repository.save(loja);
	}

	public void delete(String id) {
		repository.delete(id);
	}

	public List<Loja> listAllLojas() {
		return repository.findAll();
	}

}
