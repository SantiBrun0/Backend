package model;

import java.io.Serializable;

public record Contacto(String nombre, String mail, String telefono) implements Serializable {
}
