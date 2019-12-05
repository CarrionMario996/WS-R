package dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import entity.Vehiculo;
import utils.JpaUtils;

public class VehiculoFacade extends AbstractFacade<Vehiculo> implements Serializable {

	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public VehiculoFacade() {
		super(Vehiculo.class);
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
