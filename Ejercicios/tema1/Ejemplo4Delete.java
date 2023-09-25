package tema1;
import java.io.File;
public class Ejemplo4Delete {
	public static void main(String[] args) {
		File f1 = new File(".\\NUEVODIR\\Fichero1.txt");
		File f2 = new File(".\\NUEVODIR\\fichero2.txt");
		f1.delete();
		f2.delete();
		
	}
}
