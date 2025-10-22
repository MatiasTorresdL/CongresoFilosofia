package congresoFilosofia;

import java.time.LocalDate;
import java.time.LocalTime;

public class Entrada {
	
	private int idEntrada;
	private String codIngreso;
	private LocalDate fechaCompra;
	private LocalTime horaCompra;
	private double precio;
	private Espectador espectador;
	private Conferencia conferencia;
	
	
	
	
	public Entrada(int idEntrada, String codIngreso, double precio,
			Espectador espectador, Conferencia conferencia) {
	
		this.idEntrada = idEntrada;
		this.codIngreso = codIngreso;
		this.fechaCompra = LocalDate.now();
		this.horaCompra = LocalTime.now();
		this.precio = precio;
		this.espectador = espectador;
		this.conferencia = conferencia;
	}
	public int getIdEntrada() {
		return idEntrada;
	}
	public void setIdEntrada(int idEntrada) {
		this.idEntrada = idEntrada;
	}
	public String getCodIngreso() {
		return codIngreso;
	}
	public void setCodIngreso(String codIngreso) {
		this.codIngreso = codIngreso;
	}
	public LocalDate getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public LocalTime getHoraCompra() {
		return horaCompra;
	}
	public void setHoraCompra(LocalTime horaCompra) {
		this.horaCompra = horaCompra;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Espectador getEspectador() {
		return espectador;
	}
	public void setEspectador(Espectador espectador) {
		this.espectador = espectador;
	}
	public Conferencia getConferencia() {
		return conferencia;
	}
	public void setConferencia(Conferencia conferencia) {
		this.conferencia = conferencia;
	}
	
	@Override
	public String toString() {
		return "\n Entrada [idEntrada=" + idEntrada + ", codIngreso=" + codIngreso + ", fechaCompra=" + fechaCompra
				+ ", horaCompra=" + horaCompra + ", precio=" + precio + ", espectador=" + espectador + ", conferencia="
				+ conferencia + "]";
	}
	
	
	public boolean equals(Entrada e) {
		
		return (e.getCodIngreso().equals(this.codIngreso));
	}
	
	

}
