package calculos;

public class AregloConductores implements Comparable<AregloConductores> {
	private int id;
	private double distancia;
	private double latitud;
	private double longitud;

	public AregloConductores() {
		super();
	}

	public AregloConductores(int id, double distancia, double latitud, double longitud) {

		super();
		this.id = id;
		this.distancia = distancia;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	@Override
	public int compareTo(AregloConductores o) {
		if (distancia < o.distancia) {
			return -1;
		}
		if (distancia > o.distancia) {
			return -1;
		}
		return 0;
	}

}
