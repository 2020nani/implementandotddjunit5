package br.com.alura.leilao.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String nome;
	
	

	public Aluno(@NotNull String nome) {
		super();
		this.nome = nome;
	}
	

	public Aluno() {
		super();
	}


	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}
	
	

}
