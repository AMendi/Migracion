package ipartek.formacion.ejecutable;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import com.ipartek.formacion.modelo.DbConnection;
import com.ipartek.formacion.modelo.PersonaDAO;

public class Ejecutable {

	public static void main(String[] args) {
		String ruta = "personas.txt";

		ArrayList array = new ArrayList();
		String linea = "";

		File archivo = new File(ruta);
		FileReader leerArchivo;		
		BufferedReader buffer;
		try {
			leerArchivo = new FileReader(archivo);
			buffer = new BufferedReader(leerArchivo);
			
			while ((linea = buffer.readLine()) != null){
				String [] campos= linea.split(",");
				if(campos.length==7){
					Persona p= new Persona()
				}
			} 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
