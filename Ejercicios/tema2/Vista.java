package tema2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class Vista {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "Earbis","pass.admin");
		Statement sentencia = conexion.createStatement();
		ArrayList<Boolean> lista = new ArrayList<>();
		//lista.add( sentencia.execute("CREATE VIEW empleados_en_madrid AS "
		//		+ "(SELECT *FROM empleados JOIN departamentos  ON empleados.dept_no = departamentos.dep_no WHERE departamentos.loc = 'Madrid');"));
		lista.add( sentencia.execute("CREATE VIEW empleadosMadrid AS (SELECT *FROM empleados where dept_no like "
				+ "(SELECT dep_no FROM departamentos WHERE loc = 'Madrid'))"));
		
			for (Iterator<Boolean> iterator = lista.iterator(); iterator.hasNext();) {
				Boolean valor = iterator.next();
				if(valor) {
					ResultSet rs =sentencia.getResultSet();
					while (rs.next()) {
						System.out.printf("%d, %s, %s %n", rs.getInt(1),rs.getString(2), rs.getString(3));
					}
					rs.close();
				}else {
					int f = sentencia.getUpdateCount();
					System.out.printf("Filas afectadas: %d %n", f);
				}
			}
		sentencia.close();
		conexion.close();
		
	}
}
