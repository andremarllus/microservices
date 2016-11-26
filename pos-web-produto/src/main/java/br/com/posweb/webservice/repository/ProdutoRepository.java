package br.com.posweb.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.posweb.webservice.entidades.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
	
}
