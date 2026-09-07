package vida;

public class Array2D<T> {

    private int renglones;
    private int columnas;
    private Object[][] datos;

    public Array2D(int renglones, int columnas) {

        if (renglones < 1 || columnas < 1) {
            throw new IllegalArgumentException(
                    "Las dimensiones deben ser mayores que cero."
            );
        }

        this.renglones = renglones;
        this.columnas = columnas;

        datos = new Object[renglones][columnas];
    }

    public void set(int renglon, int columna, T valor) {

        if (renglon < 0 || renglon >= renglones) {
            throw new IndexOutOfBoundsException(
                    "Renglon fuera de rango."
            );
        }

        if (columna < 0 || columna >= columnas) {
            throw new IndexOutOfBoundsException(
                    "Columna fuera de rango."
            );
        }

        datos[renglon][columna] = valor;
    }

    @SuppressWarnings("unchecked")
    public T get(int renglon, int columna) {

        if (renglon < 0 || renglon >= renglones) {
            throw new IndexOutOfBoundsException(
                    "Renglon fuera de rango."
            );
        }

        if (columna < 0 || columna >= columnas) {
            throw new IndexOutOfBoundsException(
                    "Columna fuera de rango."
            );
        }

        return (T) datos[renglon][columna];
    }

    public int getRenglones() {
        return renglones;
    }

    public int getColumnas() {
        return columnas;
    }
}