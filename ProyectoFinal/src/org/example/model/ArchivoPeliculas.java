package org.example.model;

import java.io.*;
import java.util.ArrayList;

public class ArchivoPeliculas {

    private static final String NOMBRE_ARCHIVO = "peliculas.dat";

    public void guardar(ArrayList<Pelicula> peliculas) {

        try (ObjectOutputStream salida =
                     new ObjectOutputStream(
                             new FileOutputStream(NOMBRE_ARCHIVO))) {

            salida.writeObject(peliculas);

        } catch (IOException e) {

            System.out.println("Error al guardar el archivo");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Pelicula> cargar() {

        File archivo = new File(NOMBRE_ARCHIVO);

        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream entrada =
                     new ObjectInputStream(
                             new FileInputStream(NOMBRE_ARCHIVO))) {

            return (ArrayList<Pelicula>) entrada.readObject();

        } catch (IOException | ClassNotFoundException e) {

            System.out.println("Error al cargar el archivo");
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}