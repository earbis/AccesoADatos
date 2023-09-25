package tema1;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class Ejemplo5Reads {
	public static void main(String[] args) throws IOException{
		File fichero = new File(".\\LeerFicheroTexto.txt");
		fichero.createNewFile();
		FileReader fic = new FileReader(fichero);
		int i;
		while ((i = fic.read()) != -1) {
			System.out.print((char)i);}
		fic.close();
		
		File ficheros = new File(".\\Ejercicios\\Tema1\\Ejemplo1.java");
		fichero.createNewFile();
		FileReader fics = new FileReader(ficheros);
		int e;
		while ((e = fics.read()) != -1) {
			System.out.print((char)e);}
		fics.close();
		
		File ficheron = new File(".\\LeerFicheroTexto1.txt");
		ficheron.createNewFile();
		char b[] = new char[2];
		FileReader fi = new FileReader(ficheron);
		int a;
		while ((a = fi.read(b)) != -1) {
			System.out.print(b);}
		fi.close();
		
		}
	}
