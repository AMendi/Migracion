package com.ipartek.formacion.utilidades;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilidades {

	private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String LETRAS_NIF = "TRWAGMYFPDXBNJZSQVHLCKE";

	/**
	 * Método para validar un email
	 * 
	 * @param email
	 *            Email a validar (<code>String</code>)
	 * @return <code>true</code> cuando el email es válido. Si no,
	 *         <code>false</code>.
	 */
	public static boolean validateEmail(String email) {

		// Compiles the given regular expression into a pattern.
		Pattern pattern = Pattern.compile(PATTERN_EMAIL);

		// Match the given input against this pattern
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	/**
	 * Metodo que valida si una cadena esta vacia
	 * 
	 * @param cadena
	 *            String
	 * @return <code>boolean</code>
	 */
	public static boolean isCadenaVacia(String cadena) {

		boolean resultado = false;
		if (cadena == null || cadena.equals("")) {
			resultado = true;
		}
		return resultado;
	}

	/**
	 * Metodo que valida si una cadena es un  número
	 * 
	 * @param cadena
	 *            String
	 * @return <code>boolean</code>
	 */
	public static boolean isNumber(String cadena) {

		boolean resultado = false;
		try {
			if (!isCadenaVacia(cadena)) {
				Integer.parseInt(cadena);
				resultado = true;
			}
		} catch (NumberFormatException e) {
			// La cadena no se puede convertir a entero
			resultado = false;
		}
		return resultado;
	}

	/**
	 * Metodo que valida si es correcto el DNI
	 * 
	 * @param nif
	 *            String
	 * @return <code>boolean</code>
	 */
	public static boolean isDniValido(String nif) {

		boolean resultado = false;

		try {
			String nif1 = nif.toUpperCase();
			if (nif1.matches("[0-9]{8}[" + LETRAS_NIF + "]")) {
				int dni = Integer.parseInt(nif1.substring(0, 8));
				char letraCalculada = LETRAS_NIF.charAt(dni % 23);
				if (letraCalculada == nif1.charAt(8)) {
					resultado = true;
				}
			}
		} catch (Exception e) {
			// Si ha habido algún error es porque hay algún parseo que tira bien.
			resultado = false;
		}

		return resultado;
	}
	
	public static int calcularEdad(String fecha){
	    Date fechaNac=null;
	        try {
	            /**Se puede cambiar la mascara por el formato de la fecha
	            que se quiera recibir, por ejemplo año mes día "yyyy-MM-dd"
	            en este caso es día mes año*/
	            fechaNac = new SimpleDateFormat("dd-MM-yyyy").parse(fecha);
	        } catch (Exception ex) {
	            System.out.println("Error:"+ex);
	        }
	        Calendar fechaNacimiento = Calendar.getInstance();
	        //Se crea un objeto con la fecha actual
	        Calendar fechaActual = Calendar.getInstance();
	        //Se asigna la fecha recibida a la fecha de nacimiento.
	        fechaNacimiento.setTime(fechaNac);
	        //Se restan la fecha actual y la fecha de nacimiento
	        int anyo = fechaActual.get(Calendar.YEAR)- fechaNacimiento.get(Calendar.YEAR);
	        int mes =fechaActual.get(Calendar.MONTH)- fechaNacimiento.get(Calendar.MONTH);
	        int dia = fechaActual.get(Calendar.DATE)- fechaNacimiento.get(Calendar.DATE);
	        //Se ajusta el año dependiendo el mes y el día
	        if(mes<0 || (mes==0 && dia<0)){
	            anyo--;
	        }
	        //Regresa la edad en base a la fecha de nacimiento
	        return anyo;
	    }

}
