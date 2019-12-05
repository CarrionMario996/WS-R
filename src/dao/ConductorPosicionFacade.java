package dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import entity.ConductorPosicion;
import utils.JpaUtils;

public class ConductorPosicionFacade extends AbstractFacade<ConductorPosicion> implements Serializable {

	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public ConductorPosicionFacade() {
		super(ConductorPosicion.class);
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
