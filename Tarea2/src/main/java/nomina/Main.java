package nomina;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Array empleados = new Array(100);

        String archivo = "src/main/resources/junio.dat";

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader(archivo)
            );

            String linea;

            br.readLine();

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                int numero = Integer.parseInt(datos[0].trim());

                String nombres = datos[1].trim();

                String paterno = datos[2].trim();

                String materno = datos[3].trim();

                int horasExtra =
                        Integer.parseInt(datos[4].trim());

                double sueldoBase =
                        Double.parseDouble(datos[5].trim());

                int anioIngreso =
                        Integer.parseInt(datos[6].trim());

                Trabajador trabajador = new Trabajador(
                        numero,
                        nombres,
                        paterno,
                        materno,
                        horasExtra,
                        sueldoBase,
                        anioIngreso
                );

                empleados.insertar(trabajador);
            }

            br.close();

        } catch (IOException e) {

            System.out.println(
                    "Error al leer el archivo: " + e.getMessage()
            );

            return;
        }


        Trabajador mayorAntiguedad = empleados.obtener(0);
        Trabajador menorAntiguedad = empleados.obtener(0);

        for (int i = 1; i < empleados.getCantidad(); i++) {

            Trabajador trabajador = empleados.obtener(i);

            if (trabajador.getAnioIngreso()
                    < mayorAntiguedad.getAnioIngreso()) {

                mayorAntiguedad = trabajador;
            }

            if (trabajador.getAnioIngreso()
                    > menorAntiguedad.getAnioIngreso()) {

                menorAntiguedad = trabajador;
            }
        }

        System.out.println();
        System.out.println("TRABAJADOR CON MAYOR ANTIGÜEDAD");

        mayorAntiguedad.mostrarDatos();

        System.out.println();
        System.out.println("TRABAJADOR CON MENOR ANTIGÜEDAD");

        menorAntiguedad.mostrarDatos();

        System.out.println();
        System.out.println("NOMINA COMPLETA DE TRABAJADORES");

        for (int i = 0; i < empleados.getCantidad(); i++) {

            System.out.println();
            System.out.println("------------------------------------------");

            Trabajador trabajador = empleados.obtener(i);

            trabajador.mostrarDatos();
        }
    }
}