package nomina;

public class Array {

    private Trabajador[] trabajadores;
    private int cantidad;

    public Array(int capacidad) {
        trabajadores = new Trabajador[capacidad];
        cantidad = 0;
    }

    public void insertar(Trabajador trabajador) {

        if (cantidad < trabajadores.length) {
            trabajadores[cantidad] = trabajador;
            cantidad++;
        } else {
            System.out.println("El Array está lleno.");
        }
    }

    public Trabajador obtener(int posicion) {
        return trabajadores[posicion];
    }

    public int getCantidad() {
        return cantidad;
    }
}