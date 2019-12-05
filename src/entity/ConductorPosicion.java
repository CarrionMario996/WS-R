package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the conductor_posicion database table.
 * 
 */
@Entity
@Table(name="conductor_posicion")
@NamedQuery(name="ConductorPosicion.findAll", query="SELECT c FROM ConductorPosicion c")
public class ConductorPosicion implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idPosicion;
	private int estado;
	private Date hora;
	private String ultimaPosicion;

	public ConductorPosicion() {
	}

	public ConductorPosicion(int idPosicion, int estado, Date hora, String ultimaPosicion) {
		super();
		this.idPosicion = idPosicion;
		this.estado = estado;
		this.hora = hora;
		this.ultimaPosicion = ultimaPosicion;
	}


	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_posicion")
	public int getIdPosicion() {
		return this.idPosicion;
	}

	public void setIdPosicion(int idPosicion) {
		this.idPosicion = idPosicion;
	}


	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getHora() {
		return this.hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}


	@Column(name="ultima_posicion")
	public String getUltimaPosicion() {
		return this.ultimaPosicion;
	}

	public void setUltimaPosicion(String ultimaPosicion) {
		this.ultimaPosicion = ultimaPosicion;
	}

}