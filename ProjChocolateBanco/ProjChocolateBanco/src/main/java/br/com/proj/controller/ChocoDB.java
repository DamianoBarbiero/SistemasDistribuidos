package br.com.proj.controller;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.proj.model.Choco;
import br.com.proj.util.HibernateUtil;

public class ChocoDB {

	EntityManager entityManager;

	public ChocoDB() {
		entityManager = HibernateUtil.getEntityManager();
	}

	public boolean insert(Choco choco) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(choco);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean update(Choco choco) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(choco);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean delete (Choco choco) {
		try {
			entityManager.getTransaction().begin();
			choco = entityManager.find(Choco.class, choco.getCodigo());
			entityManager.remove(choco);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public Choco selectTo (int codigo) {
		try {
			entityManager.getTransaction().begin();
			Choco choco = entityManager.find(Choco.class, codigo);
			entityManager.getTransaction().commit();
			entityManager.close();
			return choco;
		} catch (Exception e) {
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Choco> selectAll () {
		return entityManager.createQuery("FROM " + Choco.class.getName()).getResultList();
	}
}
