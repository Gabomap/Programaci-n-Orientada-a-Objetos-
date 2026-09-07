package vida;

public class Main {

    public static void main(String[] args)
            throws Exception {

        JuegoDeLaVida juego =
                new JuegoDeLaVida(
                        "src/main/resources/poblacion.csv"
                );

        for (int generacion = 0;
             generacion < 10;
             generacion++) {


            System.out.println();
            System.out.println(
                    "================================"
            );

            System.out.println(
                    "       GENERACION "
                            + generacion
            );

            System.out.println(
                    "================================"
            );


            juego.mostrar();


            if (generacion < 9) {

                juego.siguienteGeneracion();
            }
        }
    }
}