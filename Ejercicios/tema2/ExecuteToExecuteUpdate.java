package tema2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class ExecuteToExecuteUpdate {
	/*
	 * solo para DManipulationL y DDefinitionL
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "Earbis","pass.admin");
		Statement sentencia = conexion.createStatement();
		ArrayList<Integer> lista = new ArrayList<>();
		lista.add( sentencia.executeUpdate("INSERT INTO departamentos( `dnombre`, `loc`) VALUES ('RRHH','Madrid')"));
		lista.add( sentencia.executeUpdate("UPDATE `departamentos` SET `loc`='Madrid' "));
		lista.add( sentencia.executeUpdate("DELETE FROM departamentos WHERE dep_no = 2"));
		lista.add( sentencia.executeUpdate("ALTER TABLE departamentos ADD fecha_contratacion DATE;"));
		
			for (Iterator<Integer> iterator = lista.iterator(); iterator.hasNext();) {
				Integer valor = iterator.next();
				System.out.printf("Filas afectadas: %d %n", valor);	
				
			}
		sentencia.close();
		conexion.close();
		
	}
}
