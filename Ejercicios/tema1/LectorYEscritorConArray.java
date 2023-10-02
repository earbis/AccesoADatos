package tema1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LectorYEscritorConArray {
	public static void main(String[] args) throws IOException {
		File fichero = new File(".\\LeerFicheroTexto.txt");
			File copia = new File(".\\CopiaFicheroTexto.txt");
			FileReader fic = new FileReader(fichero);
			FileWriter cop =new FileWriter(copia);
			char b[] = new char[2];
			int i;
			while ((i = fic.read(b)) != -1) {
				System.out.println(b);
				cop.append((char) b[i-1]);}
			fic.close();
			cop.close();
		}
	}
