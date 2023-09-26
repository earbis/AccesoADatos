package tema1;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Ejemplo5Reads {
	public static void main(String[] args) throws IOException{
		//lee el contenido de un fichero	
		File fichero = new File(".\\LeerFicheroTexto.txt");
		fichero.createNewFile();
		FileReader fic = new FileReader(fichero);
		int i;
		while ((i = fic.read()) != -1) {
			System.out.print((char)i);}
		fic.close();
		// otro ejemplo del mismo concepto
		File ficheros = new File(".\\Ejercicios\\Tema1\\Ejemplo1.java");
		ficheros.createNewFile();
		FileReader fics = new FileReader(ficheros);
		File Texto = new File(".\\Texto.txt");
		Texto.createNewFile();
		FileWriter escritor = new FileWriter(Texto);
		
		int e;
		while ((e = fics.read()) != -1) {
			System.out.print((char)e);
			escritor.append((char) e);

			}
		escritor.close();
		/*
		 * 
		 
		File ficheron = new File(".\\LeerFicheroTexto1.txt");
		ficheron.createNewFile();
		char b[] = new char[20];
		FileReader fi = new FileReader(ficheron);
		int a;
		while (( a = fi.read(b)) != -1) {
			System.out.println(b);}
		fi.close();
		
		*/
		
		// Ahora voy a trastear con el writer
		
		
		}
	}
