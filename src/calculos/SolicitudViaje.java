package calculos;

public class SolicitudViaje {
	private int idConductor;
	private int idViaje;

	public SolicitudViaje() {
		super();
	}

	public SolicitudViaje(int idConductor, int idViaje) {
		super();
		this.idConductor = idConductor;
		this.idViaje = idViaje;
	}

	public int getIdConductor() {
		return idConductor;
	}

	public void setIdConductor(int idConductor) {
		this.idConductor = idConductor;
	}

	public int getIdViaje() {
		return idViaje;
	}

	public void setIdViaje(int idViaje) {
		this.idViaje = idViaje;
	}

}
