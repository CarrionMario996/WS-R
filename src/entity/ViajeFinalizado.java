package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;

/**
 * The persistent class for the viaje database table.
 * 
 */
@Entity
@Table(name = "viaje")
@NamedQuery(name = "ViajeFinalizado.findAll", query = "SELECT v FROM ViajeFinalizado v")
public class ViajeFinalizado implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idViaje;
	private int estado;
	private Time horaInicio;

	public ViajeFinalizado() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_viaje")
	public int getIdViaje() {
		return this.idViaje;
	}

	public void setIdViaje(int idViaje) {
		this.idViaje = idViaje;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Column(name = "hora_inicio")
	public Time getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

}
