package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;


public abstract class AbstractFacade<T> {
	public Class<T> entityClass;

	public AbstractFacade(Class<T> entityClass) {
		super();
		this.entityClass = entityClass;
	}

	protected abstract EntityManager getEntityManager();

	public boolean create(T entity) {
		EntityManager em = getEntityManager();
		boolean flag = false;
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			flag = true;
		} catch (Exception e) {
			if (em.getTransaction() != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em.isOpen() && em != null) {
				em.close();
			}
		}

		return flag;
	}

	public List<T> mostrar() {
		CriteriaQuery<T> cq = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
		return getEntityManager().createQuery(cq).getResultList();
	}



	public void update(T entity) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction() == null && em.isOpen()) {
				em.getTransaction().rollback();
			}
		}
	}

}
