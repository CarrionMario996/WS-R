package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import calculos.AregloConductores;
import calculos.FormulaHaversine;
import calculos.SolicitudViaje;
import entity.ConductorPosicion;
import entity.Viaje;
import entity.ViajeFinalizado;

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

	@SuppressWarnings("unchecked")
	public List<T> mostrarViajes() {
		return getEntityManager().createNativeQuery("SELECT * FROM ride.viaje where estado=1 ", ViajeFinalizado.class)
				.getResultList();
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

	public static SolicitudViaje getConductor(Viaje viaje, List<ConductorPosicion> listaConductorPosicion) {
		double x1, x2, y1, y2, distanciaFormulaHaversine;
		int contador = 0;
		List<AregloConductores> listaAregloConductores = new ArrayList<AregloConductores>();
		String origenCliente = viaje.getOrigen();
		String[] origenClientePartes = origenCliente.split(",");
		x1 = Double.valueOf(origenClientePartes[0]);
		y1 = Double.valueOf(origenClientePartes[1]);
		for (int i = 0; i < listaConductorPosicion.size(); i++) {
			String origenConductor = listaConductorPosicion.get(i).getUltimaPosicion();
			String[] origenConductorPartes = origenConductor.split(",");
			x2 = Double.valueOf(origenConductorPartes[0]);
			y2 = Double.valueOf(origenConductorPartes[1]);
			distanciaFormulaHaversine = FormulaHaversine.getDistance(x1, y1, x2, y2);
			if (distanciaFormulaHaversine < 2.0) {
				listaAregloConductores.add(new AregloConductores(listaConductorPosicion.get(i).getIdPosicion(),
						distanciaFormulaHaversine, x2, y2));
				contador++;
				if (contador == 3) {
					break;
				}

			}
		}
		if (listaAregloConductores.size() > 0) {
			AregloConductores[] aregloConductores = new AregloConductores[listaAregloConductores.size()];
			for (int i = 0; i < listaAregloConductores.size(); i++) {
				aregloConductores[i] = new AregloConductores(listaAregloConductores.get(i).getId(),
						listaAregloConductores.get(i).getDistancia(), listaAregloConductores.get(i).getLatitud(),
						listaAregloConductores.get(i).getLongitud());
			}
			Arrays.sort(aregloConductores);
			SolicitudViaje solicitudViaje = new SolicitudViaje();
			solicitudViaje.setIdViaje(viaje.getIdViaje());
			solicitudViaje.setIdConductor(aregloConductores[0].getId());
			return solicitudViaje;
		} else {
			return null;
		}
	}
	

}
