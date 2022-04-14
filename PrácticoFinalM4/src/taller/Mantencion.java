package taller;

import java.time.LocalDate;

public class Mantencion {

	//ATRIBUTOS
	private String mantencionRealizada;
	private String observaciones;
	private int montoServicio;
	private LocalDate fechaMantencion;
	private Vehiculo vehiculo;
	
	//CONSTRUCTORES
	public Mantencion() {
		
	}
	
	public Mantencion(String mantencionRealizada, String observaciones, int montoServicio, Vehiculo vehiculo, LocalDate fechaMantencion) {
		this.mantencionRealizada = mantencionRealizada;
		this.observaciones 	= observaciones;
		this.montoServicio 	= montoServicio;
		this.vehiculo 		= vehiculo;
		this.fechaMantencion = fechaMantencion;
	}

	//GETTERS Y SETTERS
	public String getMantencionRealizada() {
		return mantencionRealizada;
	}

	public void setMantencionRealizada(String mantencionRealizada) {
		this.mantencionRealizada = mantencionRealizada;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getMontoServicio() {
		return montoServicio;
	}

	public void setMontoServicio(int montoServicio) {
		this.montoServicio = montoServicio;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public LocalDate getFechaMantencion() {
		return fechaMantencion;
	}

	public void setFechaMantencion(LocalDate fechaMantencion) {
		this.fechaMantencion = fechaMantencion;
	}
		
}