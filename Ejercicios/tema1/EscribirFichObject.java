package tema1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EscribirFichObject {
	public static void main(String[] args) throws IOException {
		Persona persona;
		File fichero = new File("FichPersona.dat");
		FileOutputStream fileout = new FileOutputStream(fichero);
		ObjectOutputStream dataOs = new ObjectOutputStream(fileout);
		String nombres[]= {"Ana","Manuel","Juan","Pedro","Anas","Manuels","Juans","Pedros"};
		int edades[]= {14, 18, 19, 43, 34, 34, 53, 23};
		for(int i = 0 ; i< edades.length; i++) {
			persona = new Persona(nombres[i], edades[i]);
			dataOs.writeObject(persona);
		}
		dataOs.close();
	}
}
