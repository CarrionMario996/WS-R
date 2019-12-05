package dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import entity.Conductor;
import utils.JpaUtils;

public class ConductorFacade extends AbstractFacade<Conductor> implements Serializable {

	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public ConductorFacade() {
		super(Conductor.class);
		getEntityManager();
	}

	@Override
	protected EntityManager getEntityManager() {
		if (em == null) {
			em = JpaUtils.getEntityManagerFactory().createEntityManager();
		}
		return em;
	}

}
