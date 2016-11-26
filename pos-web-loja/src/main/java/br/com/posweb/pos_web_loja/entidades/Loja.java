package br.com.posweb.pos_web_loja.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Loja implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_LOJA")
	private String id;
	
	private String name;

	public Loja() {

	}

	public Loja(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
