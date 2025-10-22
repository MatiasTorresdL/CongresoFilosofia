package congresoFilosofia;

public abstract class Persona {
	
	protected int idPersona;
	protected String movil;
	protected String mail;
	
	
	public Persona(int idPersona, String movil, String mail) {
	
		this.idPersona = idPersona;
		this.movil = movil;
		this.mail = mail;
	}


	public int getIdPersona() {
		return idPersona;
	}


	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}


	public String getMovil() {
		return movil;
	}


	public void setMovil(String movil) {
		this.movil = movil;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	@Override
	public String toString() {
		return "\n Persona [idPersona=" + idPersona + ", movil=" + movil + ", mail=" + mail + "]";
	}
	
	public boolean equals(Persona p) {
		
		return (p.getMail().equals(this.mail));
	}
	

}
