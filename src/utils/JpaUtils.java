package utils;

import java.io.*;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
	private static final String NOMBRE_UNIDAD_PERSISTENCIA = "RIDE-WS-DEV";
	private static EntityManagerFactory emf;

	/*public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory(NOMBRE_UNIDAD_PERSISTENCIA);
		}
		return emf;
	}*/

	public static EntityManagerFactory getEntityManagerFactory() {
		String sep = File.separator;
		// ruta local
		Path path = Paths.get(sep + "Users" + sep + "Dell" + sep + "conexion" + sep + "conexion.txt");
		// ruta en el servidor
		// Path path =
		// Paths.get(sep+"home"+sep+"ubuntu"+sep+"BOTS"+sep+"conexion"+sep+"conexion.txt");
		try {
			FileReader reader = new FileReader(path.toString());
			BufferedReader buffer = new BufferedReader(reader);
			String linea = buffer.readLine();
			String texto = linea;
			String[] indice = texto.split(",");

			if (emf == null) {
				Map<String, String> properties = new HashMap<String, String>();

				properties.put("javax.persistence.jdbc.url", indice[0]);
				properties.put("javax.persistence.jdbc.user", indice[1]);
				properties.put("javax.persistence.jdbc.password", indice[2]);
				properties.put("javax.persistence.jdbc.driver", indice[3]);
				emf = Persistence.createEntityManagerFactory(NOMBRE_UNIDAD_PERSISTENCIA, properties);
			}
		} catch (Exception e) {
			System.out.println("Error en JPAUtils para conectar a la BD");
		}
		System.out.println("Conexion exitosa en el bot-2");
		return emf;
	}

}
