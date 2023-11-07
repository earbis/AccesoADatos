package practicaevaluable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Vista {
	/*
	 * ESTE PROGRAMA CREA UNA VISTA EN LA QUE SE VISUALIZA DE FORMA COMODA TODA LA INFORMACION DISPONIBLE SOBRE LOS LIBROS
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/library", "Earbis","pass.admin");
		Statement sentencia = conexion.createStatement();
		boolean valor= sentencia.execute("CREATE VIEW Book AS "
				+ "(SELECT books.book_name as libro, books.book_genre as genero, books.author_name as autor, publishedbooks.publisher_name as editorial, publishedbooks.book_release as fechaPublicacion "
				+ "FROM books JOIN publishedbooks on books.book_id = publishedbooks.book_id "
				+ "order by books.book_name, publishedbooks.book_release ASC);");
		
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

		sentencia.close();
		conexion.close();
		
	}
}
