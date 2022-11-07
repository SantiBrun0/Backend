package service;

import model.Contacto;

import java.io.*;
import java.util.List;

public class ContatoIO {

    private static final String FILENAME = "contactos.txt";

    public static void write(List<Contacto> contacto) {
        try (var fo = new FileOutputStream(FILENAME); var objStream = new ObjectOutputStream(fo)) {
            objStream.writeObject(contacto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @SuppressWarnings("unchecked")
    public static List<Contacto> read() {
        try (var fi = new FileInputStream(FILENAME); var objStream = new ObjectInputStream(fi)) {
            return (List<Contacto>) objStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
