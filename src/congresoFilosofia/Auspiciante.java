package congresoFilosofia;

public class Auspiciante extends Persona{

	private String razonSocial;
	private String cuit;
	private double montoaportado;
	
	
	public Auspiciante(int idPersona, String movil, String mail, String razonSocial, String cuit,
			double montoaportado) {
		
		super(idPersona, movil, mail);
		
		this.razonSocial = razonSocial;
		this.cuit = cuit;
		this.montoaportado = montoaportado;
	}


	public String getRazonSocial() {
		return razonSocial;
	}


	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}


	public String getCuit() {
		return cuit;
	}


	public void setCuit(String cuit) {
		this.cuit = cuit;
	}


	public double getMontoaportado() {
		return montoaportado;
	}


	public void setMontoaportado(double montoaportado) {
		this.montoaportado = montoaportado;
	}


	@Override
	public String toString() {
		return "\n Auspiciante [ idPersona=" + idPersona + ", movil=" + movil + ", mail=" + mail 
				+ ", razonSocial=" + razonSocial + ", cuit=" + cuit + ", montoaportado=" + montoaportado
				+"]";
	}
	
	
	public boolean equals(Auspiciante a) {
		
		return (a.getCuit().equals(this.cuit));
		
	}
	
}
