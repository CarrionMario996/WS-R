package dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import entity.TipoVehiculo;
import utils.JpaUtils;

public class TipoVehiculoFacade extends AbstractFacade<TipoVehiculo> implements Serializable {

	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public TipoVehiculoFacade() {
		super(TipoVehiculo.class);
		getEntityManager();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		if (em == null) {
			em = JpaUtils.getEntityManagerFactory().createEntityManager();
		}
		return em;
	}

}
