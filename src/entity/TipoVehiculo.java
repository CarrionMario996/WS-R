package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the tipo_vehiculo database table.
 * 
 */
@Entity
@Table(name = "tipo_vehiculo")
@NamedQuery(name = "TipoVehiculo.findAll", query = "SELECT t FROM TipoVehiculo t")
public class TipoVehiculo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idTipoVehiculo;
	private String nombre;

	public TipoVehiculo() {
	}

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_vehiculo")
	public int getIdTipoVehiculo() {
		return this.idTipoVehiculo;
	}

	public void setIdTipoVehiculo(int idTipoVehiculo) {
		this.idTipoVehiculo = idTipoVehiculo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}