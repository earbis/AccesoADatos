package practicaevaluable;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InfoColumnsDDL {
	/*
	 *  ESTA CLASE PRODUCE EL CONTENIDO DE LAS TABLAS
	 */
	String tablar;
	public InfoColumnsDDL(String tablar) {
		this.tablar=tablar;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/library", "Earbis", "pass.admin");
			DatabaseMetaData db = conexion.getMetaData();
			
			System.out.printf("				COLUMNAS DE %s: %n", tablar.toUpperCase() );
			System.out.println("			    ===========================");
			ResultSet columnas = null;
			columnas = db.getColumns(null, "library", tablar, null);
			while (columnas.next()) {
				String nombCol = columnas.getString("Column_name");
				String tipoCol = columnas.getString("Type_name");
				String tamCol= columnas.getString("COLUMN_SIZE");
				String nula = columnas.getString("IS_NULLABLE");
				System.out.printf("Columna %s, Tipo: %s, Tamaño: %s, ¿Puede ser nula? %s %n", nombCol, tipoCol, tamCol, nula);
			}
			ResultSet pk = db.getPrimaryKeys(null, "library", tablar);
			String pkDep=" ", separador = " ";
			while(pk.next()) {
				pkDep = pkDep+separador+pk.getString("Column_name");
			}
			System.out.println("Clave primaria: " + pkDep);
			
			ResultSet fk = db.getExportedKeys(null, "library", tablar);
			while (fk.next()) {
				String fk_name = fk.getString("FKCOLUMN_NAME");
				String pk_name = fk.getString("PKCOLUMN_NAME");
				String pk_tablename = fk.getString("PKTABLE_NAME");
				String fk_tablename = fk.getString("FKTABLE_NAME");
				System.out.printf("Tabla PK: %s, Clave Primaria: %s %n", pk_tablename, pk_name);
				System.out.printf("Tabla FK: %s, Clave Foranea: %s %n%n", fk_tablename, fk_name);
				
				
			}
			
			
		} catch (SQLException|ClassNotFoundException e) {
			e.getMessage();
		}
	}
}
