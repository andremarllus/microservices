package br.com.posweb.pos_web_loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.posweb.pos_web_loja.entidades.Loja;

public interface LojaRepository extends JpaRepository<Loja, String> {
	
}