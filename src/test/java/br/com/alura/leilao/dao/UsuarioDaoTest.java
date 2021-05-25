package br.com.alura.leilao.dao;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;

class UsuarioDaoTest {

	private UsuarioDao dao;

	@Test
	void testeBuscaDeUsuarioPeloUsername() {
		EntityManager em = JPAUtil.getEntityManager();
		this.dao = new UsuarioDao(em);
		
		Usuario usuario = new Usuario("fulano", "fulano@email.com", "12345678");
		Usuario usuario2 = new Usuario("fulano2", "fulano2@email.com", "12345678");
		em.getTransaction().begin();
		em.persist(usuario);
		em.persist(usuario2);
		em.getTransaction().commit();
		
		Usuario encontrado = this.dao.buscarPorUsername(usuario.getNome());
		Usuario encontrado2 = this.dao.buscarPorUsername(usuario2.getNome());
		Assert.assertNotNull(encontrado);
		Assert.assertNotNull(encontrado2);
	}

}
