package br.com.proj.controller;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.proj.model.Chat;
import br.com.proj.util.HibernateUtil;

public class ChatDB {
	
	EntityManager entityManager;
	
	public ChatDB() {
		entityManager = HibernateUtil.getEntityManager();
	}
	
	public boolean insert (Chat chat) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(chat);
			entityManager.getTransaction().commit();
			entityManager.close();	
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Chat> selectAll () {
		return entityManager.createQuery("FROM " + Chat.class.getName()).getResultList();
	}
	
}
