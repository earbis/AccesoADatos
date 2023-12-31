package tema2JasperReports;

/**
 * @see https://www.jc-mouse.net
 * @author mouse
 */
public class Empleado {
    
    private String nombre;
    private String email;

    public Empleado() {
    }
    
    public Empleado(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    
    
}