package Clase1Playground;

public class Persona {

    private String nombre;
    private String apellido;
    private String email;
    private Integer edad;

    public Persona(String nombre, String apellido, String email, Integer edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.edad = edad;
    }

    public String  mostrarNombre() {
        return this.nombre + ' ' + this.apellido;
    }

    public Boolean esMayorDe18() {
        return this.edad > 18;
    }

}
