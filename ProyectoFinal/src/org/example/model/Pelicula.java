package org.example.model;

import java.io.Serializable;

public class Pelicula implements Serializable {

    private static final long serialVersionUID = 1L;

    private String titulo;
    private String director;
    private String genero;
    private int anio;
    private double calificacion;
    private String comentario;
    private boolean favorita;
    private String formato;

    public Pelicula() {
    }

    public Pelicula(String titulo,
                    String director,
                    String genero,
                    int anio,
                    double calificacion,
                    String comentario,
                    boolean favorita,
                    String formato) {

        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.anio = anio;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.favorita = favorita;
        this.formato = formato;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public boolean isFavorita() {
        return favorita;
    }

    public void setFavorita(boolean favorita) {
        this.favorita = favorita;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    @Override
    public String toString() {
        return titulo;
    }
}