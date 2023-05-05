package ar.edu.unlam.tallerweb1.delivery;

public class EjemploTDD {
	/*
	 * Crear un metodo que nos diga si la contrasenia es fuerte, mediano o debil
	 * Condicion 1: Que tenga como minimo 8 caracteres.
	 * Condicion 2: Que al menos dos caracteres sea una letra
	 * 
	 * Debil: Sino cumple ninguna condicion
	 * Mediana Si cumple alguna de las dos
	 * Fuerte: Si cumple ambas condiciones.
	 * 
	 * */
	
	public String EvaluarContrasenia(String contrasenia) {
		if (contrasenia == null || contrasenia== "")
			return "DEBIL";
		boolean alMenos8Caracteres = tieneAlMenos8Caracteres(contrasenia);
		boolean alMenos2Letras = tieneAlMenos2Letras(contrasenia);
		
		if (alMenos8Caracteres && alMenos2Letras)
			return "FUERTE";
		if (alMenos8Caracteres || alMenos2Letras) 
			return "MEDIANA";
		return "DEBIL";
	}
	
	private boolean tieneAlMenos8Caracteres(String contrasenia) {
		return contrasenia.length()>7;
	}
	
	private boolean tieneAlMenos2Letras(String contrasenia) {
		return contrasenia.matches(".*[a-zA-Z].*[a-zA-Z].*");
	}
}
