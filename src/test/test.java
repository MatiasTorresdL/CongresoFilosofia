package test;

import java.time.LocalDate;

import congresoFilosofia.*;

public class test {

	public static void main(String[] args) {
		
		Congreso congreso = new Congreso();
		
		System.out.println("\n 1) agregar auspiciantes");
		try {
			
			congreso.agregarAuspiciante("1511111111", "unqui@edu.ar" , "Universidad Nacional de Quilmes", "30-11111111-9", 2000.0);
			congreso.agregarAuspiciante("1522222222", "undav@edu.ar" , "Universidad Nacional de Avellaneda", "30-22222222-9", 3000.0);
			congreso.agregarAuspiciante("1533333333", "unlz@edu.ar" , "Universidad Nacional de Lomas", "30-33333333-9", 1000.0);
			congreso.agregarAuspiciante("1544444444", "utnavellaneda@edu.ar" , "Universidad Tecnologíca de Avellaneda", "30-44444444-9", 4000.0);
			
		}catch (Exception e) {	System.out.println("Exception: "+e.getMessage()); }
		
		
		System.out.println(congreso.getLstPersonas());

		
		
		System.out.println("\n 2) agregar auspiciante con cuit 30-44444444-9");
		try {
			
			congreso.agregarAuspiciante("1599999999", "utnalanus@edu.ar" , "Universidad Tecnologíca de Lanus", "30-44444444-9", 2000.0);
			
		}catch (Exception e) {	System.out.println("Exception: "+ e.getMessage()); }		
		
	

		
		
		System.out.println("\n 3) agregar espectadores");
	     
		try {
			
			congreso.agregarEspectador("1555555555", "dperez@edu.com", "Dario", "Perez", "DNI", 55555555, "Universitario");
			congreso.agregarEspectador("1566666666", "dgonzalez@edu.com", "Diego", "Gonzalez", "DNI", 66666666, "Universitario");
			congreso.agregarEspectador("1577777777", "fmariscano@edu.com", "Franco", "Mariscano", "DNI", 77777777, "Postgrado");
			congreso.agregarEspectador("1588888888", "cmadero@edu.com", "Carolina", "Madero", "DNI", 88888888, "Postgrado");

			
		}catch (Exception e) {System.out.println("Exception:"+ e.getMessage());}
	
		System.out.println(congreso.getLstPersonas());
		
		
		
		System.out.println("\n 4) agregar conferencias");
		
		try {
			
			congreso.agregarConferencia("La BIGDATA en la Filosofía", LocalDate.of(2019, 10, 8), 12000.0);
			congreso.traerConferencia(1).agregarAuspiciante(congreso.traerAuspiciante("30-11111111-9"));
			congreso.traerConferencia(1).agregarAuspiciante(congreso.traerAuspiciante("30-22222222-9"));
			
			congreso.agregarConferencia("Ser o no ser en la era moderna", LocalDate.of(2019, 10, 8), 5000.0);
			congreso.traerConferencia(2).agregarAuspiciante(congreso.traerAuspiciante("30-33333333-9"));
						
			congreso.agregarConferencia("El ABC de la filosofía", LocalDate.of(2019, 10, 9), 8000.0);
			congreso.traerConferencia(3).agregarAuspiciante(congreso.traerAuspiciante("30-44444444-9"));
			
			
		}catch (Exception e) {System.out.println("Exception: "+ e.getMessage());}
		
		System.out.println(congreso.getLstconferencias());
		

		
		System.out.println("\n 5) agregar entradas");
		
		try {
			
		congreso.agregarEntrada("9561755", 500.0, congreso.traerEspectador(55555555),congreso.traerConferencia(1));
		congreso.agregarEntrada("8492747", 600.0, congreso.traerEspectador(55555555),congreso.traerConferencia(2));
		congreso.agregarEntrada("6472949", 900.0, congreso.traerEspectador(55555555),congreso.traerConferencia(3));
		congreso.agregarEntrada("2514741", 500.0, congreso.traerEspectador(66666666),congreso.traerConferencia(1));
		congreso.agregarEntrada("6738262", 600.0, congreso.traerEspectador(66666666),congreso.traerConferencia(2));
		congreso.agregarEntrada("8795638", 600.0, congreso.traerEspectador(77777777),congreso.traerConferencia(2));
		congreso.agregarEntrada("7462839", 600.0, congreso.traerEspectador(77777777),congreso.traerConferencia(3));
		congreso.agregarEntrada("6742459", 750.0, congreso.traerEspectador(77777777),congreso.traerConferencia(1));

		
		}catch (Exception e) {System.out.println("Exception: "+ e.getMessage());}
		
		System.out.println(congreso.getLstEntradas());
		System.out.println("\n 6) agregar entrada con codingreso 2257435 ");

		try {
			
			congreso.agregarEntrada("2257435", 1100.0, congreso.traerEspectador(77777777),congreso.traerConferencia(3));

			
		}catch (Exception e) {System.out.println("Exception: "+ e.getMessage());}
		
		System.out.println("\n 7)   Imprimir todas las entradas del dia 08/10/2019 ");
		
		System.out.println(congreso.traerEntradas(LocalDate.of(2019, 10, 8)));
		
		System.out.println("\n 8)   Imprimir todas las conferencias del dia 09/10/2019 ");

		
		System.out.println(congreso.traerConferencias(LocalDate.of(2019, 10, 9)));
		
			
		  System.out.println("\n 9) Calcular balance del Congreso del dia 08/10/2019");
		  
		  System.out.println("\n el balance del congreso en el dia es: "+ congreso.calcularBalance(LocalDate.of(2019, 10, 8)));

		
		
	}
	
	


}
