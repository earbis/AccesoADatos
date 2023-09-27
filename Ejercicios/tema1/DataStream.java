package tema1;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStream {
	public static void main(String[] args) throws IOException {
		File archivo = new File(".\\FichData.dat");
		FileOutputStream fileout = new FileOutputStream(archivo);
		DataOutputStream datout = new DataOutputStream(fileout);
		String nombres[]= {"sAna", "Anae", "Anea", "Anas"};
		int edades[] = {18,19,20,21};
		for (int i = 0; i < edades.length; i++) {
			datout.writeUTF(nombres[i]);
			datout.writeInt(edades[i]);
		}
		datout.close();
	}
}