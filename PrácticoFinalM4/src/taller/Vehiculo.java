package taller;

public class Vehiculo {
	
	//ATRIBUTOS
	private String ppu;
	private String marca;
	private String modelo;
	private boolean mantenido;
	private int fecha;
	private Cliente dueño;
	
	//CONSTRUCTORES
	public Vehiculo(){
	}
	
	public Vehiculo(String ppu, String marca, String modelo, int fecha, Cliente dueño, boolean mantenido) {
		super();
		this.fecha 	= fecha;
		this.ppu 	= ppu;
		this.marca	= marca;
		this.modelo	= modelo;
		this.dueño	= dueño;
		this.setMantenido(mantenido);
		
	}

	//GETTERS Y SETTERS
	public String getPpu() {
		return ppu;
	}

	public void setPpu(String ppu) {
		this.ppu = ppu;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getFecha() {
		return fecha;
	}
	
	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	public Cliente getDueño() {
		return dueño;
	}

	public void setPropietario(Cliente dueño) {
		this.dueño = dueño;
	}

	public boolean isMantenido() {
		return mantenido;
	}

	public void setMantenido(boolean mantenido) {
		this.mantenido = mantenido;
	}
	
}