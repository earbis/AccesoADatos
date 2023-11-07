package practicaevaluable;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class MetadataDDL {
	public static void main(String[] args) {
		/*
		 * ESTE PROGRAMA DEVUELVE METAINFORMACION
		 */
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/library", "Earbis", "pass.admin");
			DatabaseMetaData db = conexion.getMetaData();
			ResultSet resul = null;
			String nombre = db.getDatabaseProductName();
			String driver = db.getDriverName();
			String url = db.getURL();
			String usuario = db.getUserName();
			System.out.println("Informacion Sobre la base de datos: ");
			System.out.println("===============================");
			System.out.printf("Nombre: %s %n", nombre);
			System.out.printf("Driver: %s %n", driver);
			System.out.printf("URL: %s %n", url);
			System.out.printf("Usuario: %s %n", usuario);
			
			
			
			resul= db.getTables(null, "library", null, null);
			while (resul.next()) {
				String catalogo = resul.getString(1);
				String esquema = resul.getString(2);
				String tabla = resul.getString(3);
				String tipo = resul.getString(4);
				System.out.printf("%s - Catalogo: %s, Esquema: %s, Nombre: %s %n", tipo, catalogo, esquema, tabla);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
