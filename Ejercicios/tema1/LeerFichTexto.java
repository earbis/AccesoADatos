package tema1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichTexto {
	public static void main(String[] args) throws IOException {
		File fichero = new File("C:\\Users\\Earbis\\eclipse-workspace\\programacionyServicios\\ejercicios\\tema1");
		FileReader fic = new FileReader(fichero);
		int i;
		while ((i=fic.read())!=-1) {
			System.out.println((char) i);
			fic.close();
		}
	}
}
