package ajedrez;

public class Array2D<T> {

    private int renglones;
    private int columnas;
    private Object[][] datos;

    public Array2D(int renglones, int columnas) {

        this.renglones = renglones;
        this.columnas = columnas;

        datos = new Object[renglones][columnas];
    }

    public void set(int renglon, int columna, T valor) {

        datos[renglon][columna] = valor;
    }

    @SuppressWarnings("unchecked")
    public T get(int renglon, int columna) {

        return (T) datos[renglon][columna];
    }

    public int getRenglones() {

        return renglones;
    }

    public int getColumnas() {

        return columnas;
    }
}