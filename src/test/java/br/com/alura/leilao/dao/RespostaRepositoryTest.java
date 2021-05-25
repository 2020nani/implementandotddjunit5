package br.com.alura.leilao.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Aluno;
import br.com.alura.leilao.model.Resposta;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;

class RespostaRepositoryTest {

	private RespostaRepository dao;

	@Test
	void testBuscaRespostaAlunoPorId() {
		EntityManager manager = JPAUtil.getEntityManager();
		this.dao = new RespostaRepository(manager);		
		Aluno aluno = new Aluno("fulano");
		manager.getTransaction().begin();
		manager.persist(aluno);
		manager.getTransaction().commit();
		
		Resposta resposta = new Resposta("consegui fazer este trem", aluno);
		Resposta resposta1 = new Resposta("consegui fazer este trem", aluno);
		Resposta resposta2 = new Resposta("consegui fazer este trem", aluno);
		Resposta resposta3 = new Resposta("consegui fazer este trem", aluno);
		Resposta resposta4 = new Resposta("consegui fazer este trem", aluno);
		manager.getTransaction().begin();
		manager.persist(resposta);
		manager.persist(resposta1);
		manager.persist(resposta2);
		manager.persist(resposta3);
		manager.persist(resposta4);
		manager.getTransaction().commit();
		
		Collection<Resposta> encontrado = this.dao.buscaRespostas(aluno.getId());
		
		Assert.assertEquals(encontrado.size(), 5);
		
	}

}
