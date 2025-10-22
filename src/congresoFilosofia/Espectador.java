package congresoFilosofia;

public class Espectador extends Persona {
	
	private String nombre;
	private String apellido;
	private String tipoDocumento;
	private long nroDocumento;
	private String nivelEstudio;
	
	public Espectador(int idPersona, String movil, String mail, String nombre, String apellido, String tipoDocumento,
			long nroDocumento, String nivelEstudio) {
		
		super(idPersona, movil, mail);
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.nivelEstudio = nivelEstudio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public long getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(long nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getNivelEstudio() {
		return nivelEstudio;
	}

	public void setNivelEstudio(String nivelEstudio) {
		this.nivelEstudio = nivelEstudio;
	}

	@Override
	public String toString() {
		return "\n Espectador [nombre=" + nombre + ", apellido=" + apellido + ", tipoDocumento=" + tipoDocumento
				+ ", nroDocumento=" + nroDocumento + ", nivelEstudio=" + nivelEstudio + ", idPersona=" + idPersona
				+ ", movil=" + movil + ", mail=" + mail + "]";
	}
	
	
	public boolean equals(Espectador e) {
		
		return (e.getNroDocumento() == this.nroDocumento);
		
	}
	
	
	

}
