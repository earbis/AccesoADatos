package tema1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class EscribirFichBytes {
	public static void main(String[] args) throws IOException {
		File fichero = new File(".\\FichBytes.dat");	
		FileOutputStream fileout = new FileOutputStream(fichero);
		FileInputStream filein = new FileInputStream(fichero);
		int i;
		for ( i = 1; i < 100; i++) {
			fileout.write(i);
		}
		fileout.close();
		while (( i= filein.read()) !=-1) {
			System.out.println(i);}
		
		
		//añadir
		FileOutputStream newFileout = new FileOutputStream(fichero, true);
		newFileout.write(100);
	}
}
