package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the vehiculo database table.
 * 
 */
@Entity
@Table(name = "vehiculo")
@NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v")
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idVehiculo;
	private String color;
	private String fecha;
	private byte[] fotografia;
	private int idTipoVehiculo;
	private String marca;
	private String modelo;
	private String placa;
	private List<Conductor> conductors;

	public Vehiculo() {
	}

	public Vehiculo(int idVehiculo, String placa, String marca, String modelo, String color, String fecha,
			int idTipoVehiculo) {
		super();
		this.idVehiculo = idVehiculo;
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.fecha = fecha;
		this.idTipoVehiculo = idTipoVehiculo;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vehiculo")
	public int getIdVehiculo() {
		return this.idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Lob
	public byte[] getFotografia() {
		return this.fotografia;
	}

	public void setFotografia(byte[] fotografia) {
		this.fotografia = fotografia;
	}

	@Column(name = "id_tipo_vehiculo")
	public int getIdTipoVehiculo() {
		return this.idTipoVehiculo;
	}

	public void setIdTipoVehiculo(int idTipoVehiculo) {
		this.idTipoVehiculo = idTipoVehiculo;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	// bi-directional many-to-one association to Conductor
	@OneToMany(mappedBy = "vehiculo")
	public List<Conductor> getConductors() {
		return this.conductors;
	}

	public void setConductors(List<Conductor> conductors) {
		this.conductors = conductors;
	}

	public Conductor addConductor(Conductor conductor) {
		getConductors().add(conductor);
		conductor.setVehiculo(this);

		return conductor;
	}

	public Conductor removeConductor(Conductor conductor) {
		getConductors().remove(conductor);
		conductor.setVehiculo(null);

		return conductor;
	}

}