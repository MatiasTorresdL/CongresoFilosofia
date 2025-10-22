package congresoFilosofia;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class Conferencia {
	
	private int idConferencia;
	private String titulo;
	private LocalDate dia;
	private double costo;
	private List<Auspiciante> lstAuspiciantes;
	
	public Conferencia(int idConferencia, String titulo, LocalDate dia, double costo) {

		this.idConferencia = idConferencia;
		this.titulo = titulo;
		this.dia = dia;
		this.costo = costo;
		this.lstAuspiciantes = new ArrayList<Auspiciante>();
	}

	public int getIdConferencia() {
		return idConferencia;
	}

	public void setIdConferencia(int idConferencia) {
		this.idConferencia = idConferencia;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public List<Auspiciante> getLstAuspiciantes() {
		return lstAuspiciantes;
	}

	@Override
	public String toString() {
		return "\n Conferencia [idConferencia=" + idConferencia + ", titulo=" + titulo + ", dia=" + dia + ", costo="
				+ costo + ", lstAuspiciantes=" + lstAuspiciantes + "]\n";
	}
	
	public boolean equals(Conferencia c) {
		
		return (c.getTitulo().equalsIgnoreCase(this.titulo) && c.getDia().isEqual(this.dia)
				&& c.getCosto() == this.costo);
		
	}
	
	
	public boolean agregarAuspiciante (Auspiciante auspiciante) throws Exception{

		if(lstAuspiciantes.contains(auspiciante)) {
		
			throw new Exception("el auspiciante ya esta en la lista");
		}
		
		
			return lstAuspiciantes.add(auspiciante);
		
	}
	
	
	public double calcularCostoReal() {
		
		double costoReal = this.costo;
		
		for(Auspiciante a : lstAuspiciantes) {
			
			costoReal -= a.getMontoaportado();
			
		}
		
		return costoReal;
	}
	
	

}
