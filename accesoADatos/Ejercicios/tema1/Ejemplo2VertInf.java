package tema1;
import java.io.File;
public class Ejemplo2VertInf {
	public static void main(String[] args) {
		System.out.println("Informacion sobre el fichero:");
		File f = new File("C:\\Users\\MICHAEL");
		if (f.exists()) {
			System.out.println("Nombre del fichero: "+f.getName());
			System.out.printf("Ruta: "+f.getPath());
			System.out.printf("%nRuta absoluta: "+f.getAbsolutePath());
			System.out.println("%nSe puede leer: "+f.canRead());
			System.out.printf("%nSe puede Escribir: "+f.canWrite());
			System.out.printf("%nTamaño: "+f.length()+" bytes");
			System.out.printf("%nEs un directorio: "+f.isDirectory());
			System.out.printf("%nEs un fichero: "+f.isFile());
			System.out.printf("%nNombre del directorio padre: "+f.getParent());
		}
		else System.out.println("No existe.");
	}
}
