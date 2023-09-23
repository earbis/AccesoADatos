package tema1;
import java.io.File;

public class Ejercicio1 {
	public static void main(String[] args) {
		String dir =".";
		File f = new File(dir);
		File[] lista = f.listFiles();
		
		System.out.println(f.isFile());
		
	}
}
