package entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.math.BigDecimal;

import java.util.Date;

/**
 * The persistent class for the viaje database table.
 * 
 */
@XmlRootElement
@Entity
@Table(name = "viaje")
@NamedQuery(name = "Viaje.findAll", query = "SELECT v FROM Viaje v")
public class Viaje implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idViaje;
	private String destino;
	private Date fecha;
	private String origen;
	private BigDecimal precio;
	

	public Viaje() {
	}

	public Viaje(int idViaje, String destino, Date fecha, String origen, String origenDesc, BigDecimal precio) {
		super();
		this.idViaje = idViaje;
		this.destino = destino;

		this.fecha = fecha;

		this.origen = origen;

		this.precio = precio;

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

	public String getDestino() {
		return this.destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	@Temporal(TemporalType.DATE)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getOrigen() {
		return this.origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

}