package tema2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EjemploDatabaseMetadata {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "Earbis", "pass.admin");
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
			
			
			
			
			resul= db.getTables(null, "prueba", null, null);
			while (resul.next()) {
				String catalogo = resul.getString(1);
				String esquema = resul.getString(2);
				String tabla = resul.getString(3);
				String tipo = resul.getString(4);
				System.out.printf("%s - Catalogo: %s, Esquema: %s, Nombre: %s %n", tipo, catalogo, esquema, tabla);
			}
			
			
			
			
			System.out.println("COLUMNAS DEPARTAMENTOS:");
			System.out.println("===========================");
			ResultSet columnas = null;
			columnas = db.getColumns(null, "prueba", "departamentos", null);
			while (columnas.next()) {
				String nombCol = columnas.getString("Column_name");
				String tipoCol = columnas.getString("Type_name");
				String tamCol= columnas.getString("COLUMN_SIZE");
				String nula = columnas.getString("IS_NULLABLE");
				System.out.printf("Columna %s, Tipo: %s, Tamaño: %s, ¿Puede ser nula? %s %n", nombCol, tipoCol, tamCol, nula);
			}
			
			
			
			ResultSet pk = db.getPrimaryKeys(null, "prueba", "departamentos");
			String pkDep=" ", separador = " ";
			while(pk.next()) {
				pkDep = pkDep+separador+pk.getString("Column_name");
			}
			System.out.println("Clave primaria: " + pkDep);
			
			
			
			ResultSet fk = db.getExportedKeys(null, "prueba", "departamentos");
			while (fk.next()) {
				String fk_name = fk.getString("FKCOLUMN_NAME");
				String pk_name = fk.getString("PKCOLUMN_NAME");
				String pk_tablename = fk.getString("PKTABLE_NAME");
				String fk_tablename = fk.getString("FKTABLE_NAME");
				System.out.printf("Tabla PK: %s, Clave Primaria: %s %n", pk_tablename, pk_name);
				System.out.printf("Tabla FK: %s, Clave Foranea: %s %n", fk_tablename, fk_name);
				
				
			}
			
			conexion.close();
			} catch (ClassNotFoundException|SQLException e) {
			e.getMessage();
		}
	}
	
}
