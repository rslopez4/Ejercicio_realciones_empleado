
package dominio;

public class Empleado {
    private String nombre;
    private Fecha fechaN;
    private Fecha fechaI;

    public Empleado(String nombre, Fecha fechaN, Fecha fechaI) {
        this.nombre = nombre;
        this.fechaN = fechaN;
        this.fechaI = fechaI;
    }

    public Fecha getFechaN() {
        return fechaN;
    }

    public void setFechaN(Fecha fechaN) {
        this.fechaN = fechaN;
    }

    public Fecha getFechaI() {
        return fechaI;
    }

    public void setFechaI(Fecha fechaI) {
        this.fechaI = fechaI;
    }
   

    public Empleado(String nombre, int dia, int mes, int anio) {
        this.nombre = nombre;
 
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  
    
}