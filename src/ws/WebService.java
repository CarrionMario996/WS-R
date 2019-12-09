package ws;

import java.sql.Time;
import java.text.DecimalFormat;
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

import dao.ClienteFacade;
import dao.ConductorFacade;

import dao.VehiculoFacade;
import dao.ViajeFacade;
import dao.ViajeFinalizadoFacade;
import entity.Cliente;
import entity.Conductor;

import entity.Vehiculo;
import entity.Viaje;
import entity.ViajeFinalizado;
import sun.security.util.Length;

@Path("/driver")
public class WebService {
	private Vehiculo v;
	private VehiculoFacade vf;
	private Conductor c;
	private ConductorFacade cf;
	private Viaje vl;
	private ViajeFacade vfl;
	private ViajeFinalizadoFacade vff;
	private ViajeFinalizado vfc;
	private Cliente cl;
	private ClienteFacade clf;

	public WebService() {
		vf = new VehiculoFacade();
		v = new Vehiculo();
		c = new Conductor();
		cf = new ConductorFacade();
		vl = new Viaje();
		vfl = new ViajeFacade();
		vff = new ViajeFinalizadoFacade();
		vfc = new ViajeFinalizado();
		cl = new Cliente();
		clf = new ClienteFacade();

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

		if (dui != null) {
			v.setPlaca(placa);
			v.setMarca(marca);
			v.setModelo(modelo);
			v.setColor(color);
			v.setFecha(fecha);
			v.setIdTipoVehiculo(id_tipo_vehiculo);
			vf.create(v);
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

		} else {
			return "error al ingresar datos";
		}

	}

	@GET
	@Path("/listaClienteJson")
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
	@Path("/listaClienteXml")
	@Produces(MediaType.APPLICATION_XML)
	public List<Viaje> getCliente(@QueryParam(value = "telefono") String telefono) {
		List<Viaje> name = null;
		name = (List<Viaje>) vfl.findByTelefono(telefono);
		return name;
	}

	/*
	 * .header("Access-Control-Allow-Origin", "*")
	 * .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
	 * .header("Access-Control-Allow-Headers",
	 * "Content-Type, Accept, X-Requested-With").build();
	 */

	@POST
	@Path("/calculoViajes")
	@Produces(MediaType.APPLICATION_JSON)
	public void viajesAll(@QueryParam(value = "hora_actual") Time hora_actual) {
		List<ViajeFinalizado> lista = new ArrayList<ViajeFinalizado>();
		lista = vff.mostrarViajes();

		for (ViajeFinalizado obj : lista) {
			long resultado = (((obj.getHoraInicio().getTime() - hora_actual.getTime()) / (60 * 1000)) * (-1));

			if (resultado > 5) {

				vfc.setIdViaje(obj.getIdViaje());
				vfc.setEstado(5);
				vfc.setHoraInicio(obj.getHoraInicio());

				vff.update(vfc);

			}
		}
	}

//	@GET
//	@Path("/coordenadasViaje")
//	@Produces(MediaType.APPLICATION_JSON)
//	public void coordenadasViaje() {
//		String re = "";
//		DecimalFormat df = new DecimalFormat("#.000000");
//		double j, c;
//		int k;
//		String nombre = "JUANITO", apellido = "PEREZ", email = "test@gmail.com";
//		String a[] = { "2005" };
	// movimiento de coordenada POSITIVAS /// 13.701608, -89.223683
	// Si una persona esta fuera del pais que lo maneje mejor del lado de android
//		for (c = -89.223683; c <= -96; c += 0.003) {
//		}
//		for (j = 13; j <= 20; j += 0.003) {
//		for (k = 2001; k <= nombre.length(); k++) {
//				System.out.println((k) + " " + df.format((j += 0.003)) + " " + df.format((c += 0.003)));

//			cl.setNombre(nombre);
//			cl.setApellido(apellido);
//			cl.setEmail(email);
//			cl.setTelefono(String.valueOf(k));
//			clf.create(cl);
//
//		}
//		}

//	}

//	@GET
//	@Path("/insertTelefono")
//	@Produces(MediaType.APPLICATION_JSON)
//	public void insertarTelefonos() {
//
//		List<Cliente> lista = clf.mostrar();
//			for (Cliente obj : lista) {
//				for (int i = 0; i <= 3; i++) {
//				cl.setIdCliente(obj.getIdCliente());
//				cl.setNombre("Juanita");
//				cl.setApellido("Perez");
//				cl.setEmail("jp@gmail.com");
//				cl.setTelefono("7000000" + i);
//				clf.create(cl);
//				System.out.println(i);
//			}
//		}
//	}
}
