package tema1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LeerFichdata {
	public static void main(String[] args) throws IOException {
		File archivo = new File(".\\FichData.dat");
		FileInputStream filein = new FileInputStream(archivo);
		DataInputStream datin = new DataInputStream(filein);
		String n;
		int i;
		while((i = datin.read())!=-1) {
			n = datin.readUTF();
			i = datin.readInt();
			System.out.println("Nombre: "+n+"   Edad:"+i);
		}
			
	}
}
