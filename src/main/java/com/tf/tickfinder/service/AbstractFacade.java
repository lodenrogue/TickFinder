package com.tf.tickfinder.service;

import java.util.List;

import org.hibernate.Session;

import com.tf.tickfinder.persistance.EntityManager;
import com.tf.tickfinder.web.Response;

public abstract class AbstractFacade<T> {
	private EntityManager<T> entityManager;

	protected AbstractFacade(Class<T> entityClass) {
		entityManager = new EntityManager<T>(entityClass);
	}

	public List<T> findAll() {
		return entityManager.getAll();
	}

	public T find(long id) {
		return entityManager.get(id);
	}

	public T create(T t) {
		return entityManager.create(t);
	}

	public T createIfNotExist(T t, String param) {
		Session session = entityManager.openSession();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
		T tQuery = (T) session.createQuery("FROM Post WHERE source=" + param);

		if (tQuery == null) {
			return create(t);
		}
		else {
			return tQuery;
		}
	}

	public Response update(T t) {
		return entityManager.update(t);
	}

	public Response delete(long id) {
		return entityManager.delete(id);
	}

}
