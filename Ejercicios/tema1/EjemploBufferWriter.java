package tema1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EjemploBufferWriter {
	public static void main(String[] args) {
		File fichero = new File(".\\LeerFicheroDeTexto.txt");
		
		try {
			FileReader fr= new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			
			
		} catch (IOException io) {
			io.getMessage();
		} 
	}
}
