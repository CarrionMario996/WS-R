package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import entity.Viaje;
import entity.ViajeFinalizado;
import utils.JpaUtils;

public class ViajeFinalizadoFacade extends AbstractFacade<ViajeFinalizado> implements Serializable {

	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public ViajeFinalizadoFacade() {
		super(ViajeFinalizado.class);
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
