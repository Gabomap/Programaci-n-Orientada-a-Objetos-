package ajedrez;

public class TableroAjedrez {

    private Array2D<Character> tablero;

    public TableroAjedrez() {

        tablero = new Array2D<>(8, 8);

        inicializar();
    }

    private void inicializar() {

        // =========================================
        // FILA 8 - PIEZAS NEGRAS
        // =========================================

        tablero.set(0, 0, '♜');
        tablero.set(0, 1, '♞');
        tablero.set(0, 2, '♝');
        tablero.set(0, 3, '♛');
        tablero.set(0, 4, '♚');
        tablero.set(0, 5, '♝');
        tablero.set(0, 6, '♞');
        tablero.set(0, 7, '♜');


        // =========================================
        // FILA 7 - PEONES NEGROS
        // =========================================

        for (int columna = 0; columna < 8; columna++) {

            tablero.set(1, columna, '♟');
        }


        // =========================================
        // FILAS VACÍAS
        // =========================================

        for (int renglon = 2; renglon < 6; renglon++) {

            for (int columna = 0; columna < 8; columna++) {

                tablero.set(renglon, columna, ' ');
            }
        }


        // =========================================
        // FILA 2 - PEONES BLANCOS
        // =========================================

        for (int columna = 0; columna < 8; columna++) {

            tablero.set(6, columna, '♙');
        }


        // =========================================
        // FILA 1 - PIEZAS BLANCAS
        // =========================================

        tablero.set(7, 0, '♖');
        tablero.set(7, 1, '♘');
        tablero.set(7, 2, '♗');
        tablero.set(7, 3, '♕');
        tablero.set(7, 4, '♔');
        tablero.set(7, 5, '♗');
        tablero.set(7, 6, '♘');
        tablero.set(7, 7, '♖');
    }


    public void mostrar() {

        System.out.println();

        for (int renglon = 0; renglon < 8; renglon++) {

            System.out.print((8 - renglon) + "  ");

            for (int columna = 0; columna < 8; columna++) {

                System.out.print(
                        tablero.get(renglon, columna)
                );

                System.out.print("   ");
            }

            System.out.println();
            System.out.println();
        }
    }
}