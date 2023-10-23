package tema2;
import java.io.Serializable;

public class Persona implements Serializable {
	private String nombre;
	private int edad;
	private String loc;
	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad= edad;
		
	}
	public Persona() {
		this.nombre= null;
		
		
	}
	public Persona(String nombre, String loc) {
		this.nombre = nombre;
		this.loc = loc;
		
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public void SetNombre(String nombre) {
		this.nombre = nombre;}
	public String getNombre() {return this.nombre;}
	public void setEdad(int edad) {
		this.edad = edad;}
	public int getEdad() {return this.edad;}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
