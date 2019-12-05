package utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
private static final String NOMBRE_UNIDAD_PERSISTENCIA="RIDE-WS-DEV";
private static EntityManagerFactory emf;
public static EntityManagerFactory getEntityManagerFactory() {
	if(emf==null) {
		emf=Persistence.createEntityManagerFactory(NOMBRE_UNIDAD_PERSISTENCIA);
	}
	return emf;
}

}
