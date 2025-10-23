package congresoFilosofia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Congreso {
	
	private List<Persona> lstPersonas;
	private List<Conferencia> lstConferencias;
	private List<Entrada> lstEntradas;
	
	public Congreso() {
		
		this.lstPersonas = new ArrayList<Persona>();
		this.lstConferencias = new ArrayList<Conferencia>();
		this.lstEntradas = new ArrayList<Entrada>();
		
	}

	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}

	public List<Conferencia> getLstconferencias() {
		return lstConferencias;
	}

	public List<Entrada> getLstEntradas() {
		return lstEntradas;
	}

	@Override
	public String toString() {
		return "\n Congreso [lstPersonas=" + lstPersonas + ", lstconferencias=" + lstConferencias + ", lstEntradas="
				+ lstEntradas + "]\n";
	}
	
	public boolean equals(Congreso c) {
		
		return (c.getLstPersonas().equals(this.lstPersonas) 
				&& c.getLstconferencias().equals(this.lstConferencias)
				&& c.getLstEntradas().equals(this.lstEntradas));
		
	}
	
	
	//metodos cu
	
	public List<Auspiciante> traerAuspiciantes(){
		
		List<Auspiciante> lstAuspiciantes = new ArrayList<Auspiciante>();
		
		for(Persona p : lstPersonas) {
			
			if (p instanceof Auspiciante) {
				
				Auspiciante a = (Auspiciante) p;
				
				lstAuspiciantes.add(a);
			}
			
		}
		
		return lstAuspiciantes;
	}	
	
	
	public Auspiciante traerAuspiciante(String cuit) {
		
		int i = 0;
		Auspiciante a = null;
		List<Auspiciante> lstAuspiciantes = traerAuspiciantes();
		
		while(a == null && i < lstAuspiciantes.size()) {
			
			if(lstAuspiciantes.get(i).getCuit().equals(cuit)) {
				
				a = lstAuspiciantes.get(i);

			}
			
			i++;
		}
		
		return a;
	}
	
	
	public boolean agregarAuspiciante(String movil, String mail, String razonSocial, 
			                          String cuit, double montoAportado)throws Exception {
		
		  if(traerAuspiciante(cuit) != null) {
			
			throw new Exception ("Auspiciante con cuit "+ cuit + " ya está registrado");
		}
		
		int id = 1;
		if(!lstPersonas.isEmpty()) {
			
		id = lstPersonas.get(lstPersonas.size()-1).getIdPersona() + 1 ;
		
		}		
		
		
		return lstPersonas.add(new Auspiciante(id, movil, mail, razonSocial,cuit,montoAportado));
	}
	
	
	public List<Espectador> traerEspectadores(){
		
		List<Espectador> lista = new ArrayList<Espectador>();
		
		
		for(Persona p : lstPersonas) {
			
			if(p instanceof Espectador) {
				
				Espectador e = (Espectador) p;
				lista.add(e);
			}
			
		}
		
		
		return lista;
	}
	
	public Espectador traerEspectador(long nroDocumento) {
		
		Espectador espectador = null;
		int i = 0 ;
		
		List<Espectador> lstEspectadores = traerEspectadores();
		
		while(espectador == null && i < lstEspectadores.size()) {
			
			if(lstEspectadores.get(i).getNroDocumento() == nroDocumento) {
				
				espectador = lstEspectadores.get(i);
				
			}
			i++;
		}
		
		
		return espectador;
	}
	
	
	public boolean agregarEspectador(String movil, String mail, String nombre, String apellido,
			String tipoDocumento, long nroDocumento, String nivelEstudio) throws Exception {
		
		if(traerEspectador(nroDocumento) != null ) {
			throw new Exception ("el espectador con nroDocumento "+nroDocumento+" ya existe");
		}
		
		int id = 1;
		if(!lstPersonas.isEmpty()) {
			
			id = lstPersonas.get(lstPersonas.size()-1).getIdPersona() +1;
		}
		
		return lstPersonas.add(new Espectador(id,movil,mail,nombre,apellido,tipoDocumento,nroDocumento,nivelEstudio));
	}
	
	
	
	public boolean agregarConferencia(String titulo, LocalDate dia, double costo) {
		
		int id = 1;
		
		if(!lstConferencias.isEmpty()) {
			
			id = lstConferencias.get(lstConferencias.size()-1).getIdConferencia()+1;
		}
		
		return lstConferencias.add(new Conferencia(id,titulo,dia,costo));
		
		
	}
	
	public Conferencia traerConferencia(int idConferencia) {
		
		Conferencia c = null;
		int i = 0; 
		
		while(c == null && i < lstConferencias.size()) {
			
			if(lstConferencias.get(i).getIdConferencia() == idConferencia) {
				
				c = lstConferencias.get(i);
				
			}
			
			i++;
		}
		
		return c;
	}
	
	
	public boolean agregarEntrada(String codIngreso, double precio, Espectador espectador, Conferencia conferencia)throws Exception {
		
		if(!esCodIngresoValido(codIngreso)) {
			
			throw new Exception("el codigo de ingreso es invalido"); 
		}
		
		int id = 1;
		
		if(!lstEntradas.isEmpty()) {
			
			id = lstEntradas.get(lstEntradas.size()-1).getIdEntrada() +1;
		}
		
		return lstEntradas.add(new Entrada(id,codIngreso,precio,espectador,conferencia));
		
		
	}
	
	
	
	public int calcularDigitoVerificador(String codIngreso) {
		
		return (Character.getNumericValue(codIngreso.charAt(6)));
	}
	
	
	
	
	public boolean esCodIngresoValido(String codIngreso) throws Exception{
	
		
		   if (codIngreso == null || codIngreso.length() != 7) {
		       throw new Exception("el codigo de ingreso es invalido (debe tener 7 Caracteres)");
		    }
		
	int suma = 0;
		
		for(int i = 0; i < codIngreso.length()-1 ; i++) {
			
			if(i>=0 && i<3) {
			suma += Character.getNumericValue(codIngreso.charAt(i)) * 2;
			}
			
			if( i>=3 && i<6) {
				
			 suma += Character.getNumericValue(codIngreso.charAt(i)) * 5;

			}
		}
			
		   suma -= calcularDigitoVerificador(codIngreso);
		   
		  return ((suma % 10) == 0);
		  
	}
	
	
	
	
	
	public List<Conferencia> traerConferencias(LocalDate dia){
		
		List<Conferencia> lista = new ArrayList<Conferencia>();
		
		for(Conferencia c : lstConferencias){
			
			if(c.getDia().isEqual(dia)) {
				
				lista.add(c);
				
			}
		}
		
		
		
		return lista;
	}
	
	
	public List<Entrada> traerEntradas(LocalDate dia){
		
		List<Entrada> lista = new ArrayList<Entrada>();
		
		for(Entrada e : lstEntradas) {
			
			if(e.getConferencia().getDia().isEqual(dia)) {
				
				lista.add(e);
				
			}
			
		}
		
		return lista;
	}
	
	
	public double calcularBalance(LocalDate dia) {
		
		double balance = 0;
		
		for(Conferencia c : lstConferencias) {
			
			if(c.getDia().isEqual(dia)) {
				
			balance += c.calcularCostoReal();
			
			}
			
		}
		
		return balance;
	}

	
	
	
}
