package br.com.alura.leilao.dao;

import java.util.Collection;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.alura.leilao.model.Aluno;
import br.com.alura.leilao.model.Resposta;

@Repository
public class RespostaRepository {
	   private EntityManager manager;
	   
	   @Autowired
	   public RespostaRepository(EntityManager manager){
	        this.manager = manager;
	   }
	   
	   public Collection<Resposta> buscaRespostas(Long idAluno){
	       return manager.createQuery("select r from Resposta r where r.aluno.id =    :idAluno",Resposta.class)
	                     .setParameter("idAluno",idAluno)
	                     .getResultList();
	   }

	}
