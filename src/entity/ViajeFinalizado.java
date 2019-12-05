package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the viaje database table.
 * 
 */
@Entity
@Table(name="viaje")
@NamedQuery(name="ViajeFinalizado.findAll", query="SELECT v FROM ViajeFinalizado v")
public class ViajeFinalizado implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idViaje;
	private String destino;
	private String destinoDesc;
	private int distancia;
	private int estado;
	private Date fecha;
	private String genero;
	private Time horaFinal;
	private Time horaInicio;
	private int idCliente;
	private int idConductor;
	private int idTipoVehiculo;
	private String origen;
	private String origenDesc;
	private BigDecimal precio;
	private int tiempo;

	public ViajeFinalizado() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_viaje")
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


	@Column(name="destino_desc")
	public String getDestinoDesc() {
		return this.destinoDesc;
	}

	public void setDestinoDesc(String destinoDesc) {
		this.destinoDesc = destinoDesc;
	}


	public int getDistancia() {
		return this.distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}


	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}


	@Temporal(TemporalType.DATE)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	@Column(name="Genero")
	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}


	@Column(name="hora_final")
	public Time getHoraFinal() {
		return this.horaFinal;
	}

	public void setHoraFinal(Time horaFinal) {
		this.horaFinal = horaFinal;
	}


	@Column(name="hora_inicio")
	public Time getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}


	@Column(name="id_cliente")
	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	@Column(name="id_conductor")
	public int getIdConductor() {
		return this.idConductor;
	}

	public void setIdConductor(int idConductor) {
		this.idConductor = idConductor;
	}


	@Column(name="id_tipo_vehiculo")
	public int getIdTipoVehiculo() {
		return this.idTipoVehiculo;
	}

	public void setIdTipoVehiculo(int idTipoVehiculo) {
		this.idTipoVehiculo = idTipoVehiculo;
	}


	public String getOrigen() {
		return this.origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}


	@Column(name="origen_desc")
	public String getOrigenDesc() {
		return this.origenDesc;
	}

	public void setOrigenDesc(String origenDesc) {
		this.origenDesc = origenDesc;
	}


	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}


	public int getTiempo() {
		return this.tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

}