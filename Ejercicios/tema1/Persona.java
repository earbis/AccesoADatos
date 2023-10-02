package tema1;

public class Persona {
	private String nombre;
	private int edad;
	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad= edad;
		
	}
	public Persona() {
		this.nombre= null;
		
		
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
