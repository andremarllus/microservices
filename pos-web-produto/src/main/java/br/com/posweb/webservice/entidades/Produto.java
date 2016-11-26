package br.com.posweb.webservice.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String descricao;

	private int codigo;

	private String categoria;

}
