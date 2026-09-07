package vida;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JuegoDeLaVida {

    private Array2D<Integer> tablero;

    public JuegoDeLaVida(String archivo) throws IOException {

        tablero = leerCSV(archivo);
    }

    private Array2D<Integer> leerCSV(String archivo)
            throws IOException {

        BufferedReader lector =
                new BufferedReader(
                        new FileReader(archivo)
                );

        String primeraLinea = lector.readLine();

        if (primeraLinea == null) {

            lector.close();

            throw new IOException(
                    "El archivo CSV está vacío."
            );
        }

        String[] primeraFila =
                primeraLinea.split(",");

        int columnas = primeraFila.length;

        int renglones = 1;

        while (lector.readLine() != null) {
            renglones++;
        }

        lector.close();

        if (renglones < 10 || columnas < 10) {

            throw new IOException(
                    "El tablero debe tener al menos 10 renglones y 10 columnas."
            );
        }


        Array2D<Integer> resultado =
                new Array2D<>(
                        renglones,
                        columnas
                );

        lector =
                new BufferedReader(
                        new FileReader(archivo)
                );


        for (int renglon = 0;
             renglon < renglones;
             renglon++) {

            String linea =
                    lector.readLine();

            String[] valores =
                    linea.split(",");


            if (valores.length != columnas) {

                lector.close();

                throw new IOException(
                        "Todas las filas deben tener el mismo número de columnas."
                );
            }


            for (int columna = 0;
                 columna < columnas;
                 columna++) {

                int valor =
                        Integer.parseInt(
                                valores[columna].trim()
                        );


                if (valor != 0 && valor != 1) {

                    lector.close();

                    throw new IOException(
                            "El CSV solamente puede contener 0 y 1."
                    );
                }


                resultado.set(
                        renglon,
                        columna,
                        valor
                );
            }
        }


        lector.close();

        return resultado;
    }

    public void mostrar() {

        for (int renglon = 0;
             renglon < tablero.getRenglones();
             renglon++) {

            for (int columna = 0;
                 columna < tablero.getColumnas();
                 columna++) {

                if (tablero.get(renglon, columna) == 1) {

                    System.out.print("■ ");

                } else {

                    System.out.print("· ");
                }
            }

            System.out.println();
        }
    }

    public void siguienteGeneracion() {

        Array2D<Integer> siguiente =
                new Array2D<>(
                        tablero.getRenglones(),
                        tablero.getColumnas()
                );


        for (int renglon = 0;
             renglon < tablero.getRenglones();
             renglon++) {

            for (int columna = 0;
                 columna < tablero.getColumnas();
                 columna++) {

                int vecinos =
                        contarVecinos(
                                renglon,
                                columna
                        );

                int estado =
                        tablero.get(
                                renglon,
                                columna
                        );


                int nuevoEstado;

                if (estado == 1) {

                    if (vecinos == 2 ||
                            vecinos == 3) {

                        nuevoEstado = 1;

                    } else {

                        nuevoEstado = 0;
                    }

                } else {

                    if (vecinos == 3) {

                        nuevoEstado = 1;

                    } else {

                        nuevoEstado = 0;
                    }
                }

                siguiente.set(
                        renglon,
                        columna,
                        nuevoEstado
                );
            }
        }


        tablero = siguiente;
    }

    private int contarVecinos(
            int renglon,
            int columna) {

        int vecinos = 0;

        for (int dr = -1;
             dr <= 1;
             dr++) {

            for (int dc = -1;
                 dc <= 1;
                 dc++) {

                if (dr == 0 && dc == 0) {
                    continue;
                }


                int nuevoRenglon =
                        renglon + dr;

                int nuevaColumna =
                        columna + dc;

                if (nuevoRenglon >= 0 &&
                        nuevoRenglon <
                                tablero.getRenglones() &&

                        nuevaColumna >= 0 &&
                        nuevaColumna <
                                tablero.getColumnas()) {


                    if (tablero.get(
                            nuevoRenglon,
                            nuevaColumna
                    ) == 1) {

                        vecinos++;
                    }
                }
            }
        }


        return vecinos;
    }
}