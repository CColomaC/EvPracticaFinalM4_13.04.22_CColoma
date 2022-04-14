package taller;

import java.util.ArrayList;

public class Cliente {
	
	//ATRIBUTOS
	private String nombres;
	private String apellidos;
	private String rut;
	private String correo;
	private String fono;
	private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
	
	//CONSTRUCTORES
	public Cliente() {
		
	}
	
	public Cliente(String nombres, String apellidos, String rut, String correo, String fono) {
		this.nombres 	= nombres;
		this.apellidos 	= apellidos;
		this.rut 		= rut;
		this.correo 	= correo;
		this.fono 		= fono;
	}

	//GETTERS Y SETTERS
	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFono() {
		return fono;
	}

	public void setFono(String fono) {
		this.fono = fono;
	}

	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	public String vehiculosCliente() {

		String vehiculosCliente = "";
		for (Vehiculo vehiculo : this.vehiculos) {
			vehiculosCliente += "| PPU: "+vehiculo.getPpu()+" |\n"
						  + "| Marca: "+vehiculo.getMarca()+" |\n"
						  + "| Modelo: "+vehiculo.getModelo()+" |\n"
						  + "| Año: "+vehiculo.getFecha()+" |\n"
						  + "___________________________\n";
		}
		return vehiculosCliente;
	}
	public void addVehiculo(Vehiculo vehiculo) {
		this.vehiculos.add(vehiculo);
	}
}