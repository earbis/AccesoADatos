package tema1;
import java.io.File;
import java.util.ArrayList;
public class Ejercicio1_1 {
	public static void main(String[] args) {
		String dir =".";
		File fichero = new File(dir);
		File[] lista = fichero.listFiles();
		
		
		// 1 de 2 soluciones
		for (int i = 0; i < lista.length; i++) {
			System.out.println(lista[i]);
		}
		
		
		//2 de 2 soluciones (usando Collections)
		ArrayList<File> lista2 = new ArrayList<>();
		for (int i = 0; i < lista.length; i++) {
			lista2.add(lista[i]);
		}
		System.out.println(lista2);
		
		
	}
}
