package entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the conductor database table.
 * 
 */
@Entity
@Table(name = "conductor")
@NamedQuery(name = "Conductor.findAll", query = "SELECT c FROM Conductor c")
public class Conductor implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idConductor;
	private String apellido;
	private String direccion;
	private String dui;
	private String email;
	private int estado;
	private byte[] fotografia;
	private int idMunicipio;
	private String nombre;
	private String numLicencia;
	private String telefono;
	private Vehiculo vehiculo;

	public Conductor() {
		
	}
	

	public Conductor(int idConductor, String nombre, String apellido, String dui, String numLicencia, String direccion,
			int idMunicipio,Vehiculo id_vehiculo, String email, String telefono,int estado) {
		super();
		this.idConductor = idConductor;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dui = dui;
		this.numLicencia = numLicencia;
		this.direccion = direccion;
		this.idMunicipio = idMunicipio;
		this.vehiculo=id_vehiculo;
		this.email = email;
		this.telefono = telefono;
		this.estado=estado;
		
	}

	
	




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conductor")
	public int getIdConductor() {
		return this.idConductor;
	}

	public void setIdConductor(int idConductor) {
		this.idConductor = idConductor;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDui() {
		return this.dui;
	}

	public void setDui(String dui) {
		this.dui = dui;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Lob
	public byte[] getFotografia() {
		return this.fotografia;
	}

	public void setFotografia(byte[] fotografia) {
		this.fotografia = fotografia;
	}

	@Column(name = "id_municipio")
	public int getIdMunicipio() {
		return this.idMunicipio;
	}

	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "num_licencia")
	public String getNumLicencia() {
		return this.numLicencia;
	}

	public void setNumLicencia(String numLicencia) {
		this.numLicencia = numLicencia;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	// bi-directional many-to-one association to Vehiculo
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_vehiculo")
	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

}