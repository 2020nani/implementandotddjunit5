package br.com.alura.leilao.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
@Entity
public class Resposta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String resposta;
	
	@NotNull
	@ManyToOne
	private Aluno aluno;
	
	

	public Resposta() {
		super();
	}



	public Resposta(@NotNull String resposta, @NotNull Aluno aluno) {
		super();
		this.resposta = resposta;
		this.aluno = aluno;
	}
	
	

}
