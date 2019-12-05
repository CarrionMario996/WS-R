package dao;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import entity.Viaje;
import utils.JpaUtils;

public class ViajeFacade extends AbstractFacade<Viaje> implements Serializable {

	private EntityManager em;
	private static final long serialVersionUID = 1L;

	public ViajeFacade() {
		super(Viaje.class);
		getEntityManager();
	}

	@Override
	protected EntityManager getEntityManager() {
		if (em == null) {
			em = JpaUtils.getEntityManagerFactory().createEntityManager();
		}
		return em;
	}

	public List<?> findByTelefono(String telefono) {
		getEntityManager();

		String sql = "select v.* from viaje v inner join conductor c on v.id_conductor=c.id_conductor where c.telefono='"
				+ telefono + "';";

		List<?> listaViaje = null;
		try {
			listaViaje = em.createNativeQuery(sql, Viaje.class).getResultList();
			for (Object o : listaViaje) {
				o.toString();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (listaViaje == null) {
			listaViaje = new ArrayList<Viaje>();
		}
		return listaViaje;
	}

}
