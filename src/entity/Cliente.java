package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name="cliente")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idCliente;
	private String apellido;
//	private String direccion;
//	private String dui;
	private String email;
//	private int estado;
//	private String genero;
//	private int idMunicipio;
	private String nombre;
	private String telefono;

	public Cliente() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente")
	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

//
//	public String getDireccion() {
//		return this.direccion;
//	}
//
//	public void setDireccion(String direccion) {
//		this.direccion = direccion;
//	}
//
//
//	public String getDui() {
//		return this.dui;
//	}
//
//	public void setDui(String dui) {
//		this.dui = dui;
//	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


//	public int getEstado() {
//		return this.estado;
//	}
//
//	public void setEstado(int estado) {
//		this.estado = estado;
//	}
//
//
//	public String getGenero() {
//		return this.genero;
//	}
//
//	public void setGenero(String genero) {
//		this.genero = genero;
//	}
//
//
//	@Column(name="id_municipio")
//	public int getIdMunicipio() {
//		return this.idMunicipio;
//	}
//
//	public void setIdMunicipio(int idMunicipio) {
//		this.idMunicipio = idMunicipio;
//	}
//

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}