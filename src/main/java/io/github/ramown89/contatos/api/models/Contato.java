package io.github.ramown89.contatos.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table
@Data
public class Contato {
	
	@Id
    @SequenceGenerator(name="seq",sequenceName="Firebird_seq")        
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")  
	private long id;
	
	@Column(length=100)
	private String nome;
	
	@Column(length=20)
	private String telefone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
