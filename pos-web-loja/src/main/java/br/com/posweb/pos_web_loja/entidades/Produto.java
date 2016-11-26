package br.com.posweb.pos_web_loja.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String descricao;

	private String codigo;

	private String categoria;
	
	@OneToOne
	@JoinColumn(name = "ID_LOJA")
	private Loja loja;
	
	@Transient
	private List<String> lojas;
	
	public Produto(String descricao, List<String> lojas) {
		super();
		this.descricao = descricao;
		this.lojas = lojas;
	}
}
