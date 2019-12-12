package ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import dao.ConductorFacade;

import dao.VehiculoFacade;
import dao.ViajeFacade;

import entity.Conductor;

import entity.Vehiculo;
import entity.Viaje;

@Path("/driver")
public class WebService {
	private Vehiculo v;
	private VehiculoFacade vf;
	private Conductor c;
	private ConductorFacade cf;
	private Viaje vl;
	private ViajeFacade vfl;

	public WebService() {
		vf = new VehiculoFacade();
		v = new Vehiculo();
		c = new Conductor();
		cf = new ConductorFacade();
		vl = new Viaje();
		vfl = new ViajeFacade();

	}

	@POST
	@Path("/guardarDatos")
	@Produces({ MediaType.APPLICATION_JSON })
	public String guardarDatos(@QueryParam("placa") String placa, @QueryParam("marca") String marca,
			@QueryParam("modelo") String modelo, @QueryParam("color") String color, @QueryParam("fecha") String fecha,
			@QueryParam("id_tipo_vehiculo") int id_tipo_vehiculo, @QueryParam("nombre") String nombre,
			@QueryParam("apellido") String apellido, @QueryParam("dui") String dui,
			@QueryParam("numLicencia") String num_licencia, @QueryParam("direccion") String direccion,
			@QueryParam("id_municipio") int id_municipio, @QueryParam("email") String email,
			@QueryParam("telefono") String telefono, @QueryParam("estado") int estado) {

		v.setPlaca(placa);
		v.setMarca(marca);
		v.setModelo(modelo);
		v.setColor(color);
		v.setFecha(fecha);
		v.setIdTipoVehiculo(id_tipo_vehiculo);

		vf.create(v);

		/***************************/
		c.setNombre(nombre);
		c.setApellido(apellido);
		c.setDui(dui);
		c.setNumLicencia(num_licencia);
		c.setDireccion(direccion);
		c.setIdMunicipio(id_municipio);
		c.setVehiculo(v);
		c.setEmail(email);
		c.setTelefono(telefono);
		c.setEstado(estado);
		cf.create(c);

		return "datos ingresados exitosamente";

	}

	@GET
	@Path("/historialViaje")
	@Produces(MediaType.APPLICATION_JSON)
	public String clientesAll(@QueryParam("telefono") String telefono) {

		List<?> lista = new ArrayList<Viaje>();

		lista = vfl.findByTelefono(telefono);
		if (telefono.isEmpty()) {
			return "telefono no se ingreso";
		}
		if (!lista.isEmpty()) {
			Gson gson = new Gson();
			String data = gson.toJson(lista);
			JsonArray jsonArray = new JsonParser().parse(data).getAsJsonArray();
			String resultado = gson.toJson(jsonArray);
			return resultado;

		} else {
			return "no hay datos";

		}

	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("/historialViajeXml")
	@Produces(MediaType.APPLICATION_XML)
	public List<Viaje> getCliente(@QueryParam(value = "telefono") String telefono) {
		List<Viaje> name = null;
		name = (List<Viaje>) vfl.findByTelefono(telefono);
		return name;
	}

}
