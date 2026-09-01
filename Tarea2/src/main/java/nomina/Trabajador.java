package nomina;

public class Trabajador {

    private int numeroTrabajador;
    private String nombres;
    private String paterno;
    private String materno;
    private int horasExtra;
    private double sueldoBase;
    private int anioIngreso;

    public Trabajador(int numeroTrabajador, String nombres,
                      String paterno, String materno,
                      int horasExtra, double sueldoBase,
                      int anioIngreso) {

        this.numeroTrabajador = numeroTrabajador;
        this.nombres = nombres;
        this.paterno = paterno;
        this.materno = materno;
        this.horasExtra = horasExtra;
        this.sueldoBase = sueldoBase;
        this.anioIngreso = anioIngreso;
    }

    public int getNumeroTrabajador() {
        return numeroTrabajador;
    }

    public String getNombres() {
        return nombres;
    }

    public String getPaterno() {
        return paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public int calcularAntiguedad() {
        return 2026 - anioIngreso;
    }

    public double calcularSueldo() {

        double pagoHorasExtra = horasExtra * 276.50;

        double prestacionAntiguedad =
                sueldoBase * 0.03 * calcularAntiguedad();

        return sueldoBase + pagoHorasExtra + prestacionAntiguedad;
    }

    public void mostrarDatos() {

        System.out.println("Numero de trabajador: " + numeroTrabajador);
        System.out.println("Nombre: " + nombres + " "
                + paterno + " " + materno);
        System.out.println("Horas extra: " + horasExtra);
        System.out.println("Sueldo base: $" +
                String.format("%.2f", sueldoBase));
        System.out.println("Año de ingreso: " + anioIngreso);
        System.out.println("Antigüedad: " +
                calcularAntiguedad() + " años");
        System.out.println("Sueldo a pagar: $" +
                String.format("%.2f", calcularSueldo()));
    }
}