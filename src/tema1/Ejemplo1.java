package tema1;
import java.io.*;
public class Ejemplo1 {
	public static void main(String[] args) {
		String dir = ".";
		File f = new File(dir);
		String [] archivos = f.list();
		System.out.printf("Ficheros en el directorio"
				+ " act"
				+ "ual: %d %n", archivos.length);
		System.out.printf("Ficheros en el directorio"
				+ " act"
				+ "ual: %d %n", archivos.length);
		
		for (int i = 0; i < archivos.length; i++) {
			File f2 = new File(f, archivos[i]);
			System.out.printf("%nNombre: %s", archivos[i]);
			if (f2.isFile()) {
				System.out.printf("%nEs fichero" );
			} else {
				System.out.printf("%nEs directorio" );
			}
					
		}
	}
}

