package taller;

public class Vehiculo {
	
	//ATRIBUTOS
	private String ppu;
	private String marca;
	private String modelo;
	private boolean mantenido;
	private int fecha;
	private Cliente due�o;
	
	//CONSTRUCTORES
	public Vehiculo(){
	}
	
	public Vehiculo(String ppu, String marca, String modelo, int fecha, Cliente due�o, boolean mantenido) {
		super();
		this.fecha 	= fecha;
		this.ppu 	= ppu;
		this.marca	= marca;
		this.modelo	= modelo;
		this.due�o	= due�o;
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

	public Cliente getDue�o() {
		return due�o;
	}

	public void setPropietario(Cliente due�o) {
		this.due�o = due�o;
	}

	public boolean isMantenido() {
		return mantenido;
	}

	public void setMantenido(boolean mantenido) {
		this.mantenido = mantenido;
	}
	
}