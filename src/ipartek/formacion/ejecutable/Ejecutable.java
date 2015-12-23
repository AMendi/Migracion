package ipartek.formacion.ejecutable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import com.ipartek.formacion.modelo.DbConnection;
import com.ipartek.formacion.modelo.PersonaDAO;
import com.ipartek.formacion.pojo.Persona;
import com.ipartek.formacion.utilidades.Utilidades;

public class Ejecutable {
	
	static int contadorInsercciones = 0;
	static int contadorErrores = 0;
	static String msgErrores = "";

	public static void main(String[] args) throws IOException {
		
		System.out.println("Comenzamos migracion....");
		
		String ruta = "personas.txt";
		if(args.length>0){
			ruta=args[0];
		}

		ArrayList array = new ArrayList();
		String linea = "";

		// Procesamos el archivo de texto a leer
		File archivo = new File(ruta);
		FileReader leerArchivo;		
		BufferedReader buffer;
		// Abrir conexión
		PersonaDAO pDAO=new PersonaDAO();
		try {
			// Leer cada linea
			leerArchivo = new FileReader(archivo);
			buffer = new BufferedReader(leerArchivo);
			while ((linea = buffer.readLine()) != null){
				// Por cada linea procesamos los campos
				String [] campos= linea.split(",");
				// Comprobamos que el número de campos es 7
				if(campos.length==7){
					String nombre= campos[0] + campos[1] + campos[2];
					String dni= campos[5];
					String observaciones= campos[6];
					String email= campos[4];
					// Comprobamos que el dni y el email sean de formato válido con la clase Utilidades
					if((Utilidades.isDniValido(dni))&&(Utilidades.validateEmail(email))){
						Persona p= new Persona(nombre, dni, observaciones, email);
						// Insertamos el registro válido y aumentamos el contador de las inserciones
						pDAO.insert(p);
						contadorInsercciones++;
				// Si no es válido, guardamos la linea y incrementamos el contador de fallos
					}else{
						contadorErrores++;
						msgErrores += linea + " \n";
					}
				}else{
					contadorErrores++;
					msgErrores += linea + " \n";
				}
			} 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			// Cerramos conexión
			pDAO.closeConn();
			// Escribimos los resultados 
			System.out.println("Resumen:");
			System.out.println("------------------------------------------");
			System.out.println("Correctos: "+ contadorInsercciones);
			System.out.println("Fallos: "+ contadorErrores +" \n");
			System.out.println("En los registros:"+" \n" + msgErrores);
		}
	}

}
