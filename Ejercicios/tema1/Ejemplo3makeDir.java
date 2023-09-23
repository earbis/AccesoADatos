package tema1;
import java.io.File;
import java.io.IOException;
public class Ejemplo3makeDir {
	public static void main(String[] args) {
		File d = new File("NUEVODIR");
		File f1 = new File(d,"Fichero1.txt");
		File f2 = new File(d,"fichero2.txt");
		d.mkdir();
		try {
			if (f1.createNewFile()) {
				System.out.println("lo ha creado");
			} else {
				System.out.println("no lo ha creado");
			}
			if (f2.createNewFile()) {
				System.out.println("lo ha creado");
			} else {
				System.out.println("no lo ha creado");
			}
		} catch (IOException e) {	
			e.printStackTrace();
		}
	}
}
