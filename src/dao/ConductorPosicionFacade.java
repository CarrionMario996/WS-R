package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;



import entity.ConductorPosicion;
import entity.ViajeFinalizado;
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
/*	public List<ViajeFinalizado> getViajeByEstado(Estado estado) {
		List<Viaje> list = new ArrayList<Viaje>();

		try {
			TypedQuery<Viaje> q = em.createQuery("SELECT c FROM Viaje c WHERE c.estadoBean = :estado", Viaje.class);
			q.setParameter("estado", estado);

			list = q.getResultList();
		} catch (Exception e) {
			ErrorHistorialFacade errorHistorialFacade = new ErrorHistorialFacade();
			
			ErrorHistorial errorHistorial = new ErrorHistorial();
			errorHistorial.setFechaHora(new Date());
			errorHistorial.setDescripcionError(e.getMessage());
			errorHistorial.setMetodo("BOT2.dao.ViajeFacade.getViajeByEstado");

			errorHistorialFacade.create(errorHistorial);
			e.printStackTrace();
		}

		return list;
	}*/

}
