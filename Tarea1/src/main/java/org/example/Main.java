import java.io.*;
import java.util.Scanner;

public class Main {
    private static final int MES_INI = 3;
    private static final int MES_FIN = 8;

    private static final String[] NOMBRES_MESES = {
            "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO"
    };

    public static void main(String[] args) {
        String ruta = "datos.csv";

        double seguidoresTwtEnero = 0;
        double seguidoresTwtJunio = 0;

        double[] vistasYT = new double[6];
        double sumaCrecTwt = 0;
        double sumaCrecFb = 0;

        double sumaLikesYT = 0;
        double sumaLikesTw = 0;
        double sumaLikesFb = 0;

        boolean okFollowersTwt = false;
        boolean okVistasYT = false;

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {

            String header = br.readLine();
            if (header == null) {
                System.out.println("El archivo CSV está vacío.");
                return;
            }

            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;

                linea = linea.replace("\"", "");
                linea = linea.replace("65,41", "65410");

                String[] campos = linea.split(",");

                if (campos.length < 9) continue;

                String red = campos[0].trim();
                String concepto = campos[1].trim();

                if (red.equals("TWITTER") && concepto.contains("SEGUIDORES")) {
                    seguidoresTwtEnero = parseDoubleSafe(campos[3]);
                    seguidoresTwtJunio = parseDoubleSafe(campos[8]);
                    okFollowersTwt = true;
                }

                if (red.equals("YOUTUBE") && concepto.contains("VISUALIZACIONES")) {
                    for (int i = 0; i < 6; i++) {
                        vistasYT[i] = parseDoubleSafe(campos[MES_INI + i]);
                    }
                    okVistasYT = true;
                }

                if (red.equals("TWITTER") && concepto.contains("CRECIMIENTO")) {

                    if (concepto.contains("FOLLOWERS") || concepto.contains("follow")) {
                        for (int i = 0; i < 6; i++) {
                            sumaCrecTwt += parseDoubleSafe(campos[MES_INI + i]);
                        }
                    }
                }

                if (red.equals("FACEBOOK") && concepto.contains("CRECIMIENTO")) {

                    if (concepto.contains("seguidores") || concepto.contains("SEGUIDORES")) {
                        for (int i = 0; i < 6; i++) {
                            sumaCrecFb += parseDoubleSafe(campos[MES_INI + i]);
                        }
                    }
                }


                if (red.equals("YOUTUBE") && concepto.contains("ME GUSTA")) {
                    for (int i = 0; i < 6; i++) {
                        sumaLikesYT += parseDoubleSafe(campos[MES_INI + i]);
                    }
                }

                if (red.equals("TWITTER") && concepto.equals("ME GUSTA")) {
                    for (int i = 0; i < 6; i++) {
                        sumaLikesTw += parseDoubleSafe(campos[MES_INI + i]);
                    }
                }

                if (red.equals("FACEBOOK") && concepto.contains("ME GUSTA")) {
                    for (int i = 0; i < 6; i++) {
                        sumaLikesFb += parseDoubleSafe(campos[MES_INI + i]);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo: " + ruta);
            System.out.println("Asegúrate de que exista en la misma carpeta donde ejecutas el proyecto.");
            return;
        } catch (IOException e) {
            System.out.println("Ocurrió un error leyendo el archivo CSV.");
            e.printStackTrace();
            return;
        }


        System.out.println("==================================================");

        if (okFollowersTwt) {
            System.out.println("1) Diferencia de seguidores Twitter (JUNIO - ENERO):");
            System.out.println("   Diferencia = " + (seguidoresTwtJunio - seguidoresTwtEnero) + " seguidores");
        } else {
            System.out.println("1) No se encontró la fila de TWITTER + SEGUIDORES en el CSV.");
        }


        Scanner sc = new Scanner(System.in);
        System.out.println("\n2) Diferencia de visualizaciones YouTube entre dos meses (ENERO..JUNIO)");
        System.out.println("   1=ENERO, 2=FEBRERO, 3=MARZO, 4=ABRIL, 5=MAYO, 6=JUNIO");

        if (!okVistasYT) {
            System.out.println("   No se encontró la fila de YOUTUBE + VISUALIZACIONES para ENERO..JUNIO.");
        } else {
            int m1 = pedirMes(sc, "Ingrese primer mes (1-6)");
            int m2 = pedirMes(sc, "Ingrese segundo mes (1-6)");

            double v1 = vistasYT[m1 - 1];
            double v2 = vistasYT[m2 - 1];

            System.out.println("   Visualizaciones en " + NOMBRES_MESES[m1 - 1] + ": " + v1);
            System.out.println("   Visualizaciones en " + NOMBRES_MESES[m2 - 1] + ": " + v2);
            System.out.println("   Diferencia absoluta = " + Math.abs(v2 - v1));
        }

        System.out.println("\n3) Promedio de crecimiento (ENERO..JUNIO)");
        System.out.println("   Twitter promedio = " + (sumaCrecTwt / 6.0));
        System.out.println("   Facebook promedio = " + (sumaCrecFb / 6.0));


        System.out.println("\n4) Promedio de likes (ENERO..JUNIO)");
        System.out.println("   YouTube promedio = " + (sumaLikesYT / 6.0));
        System.out.println("   Twitter promedio  = " + (sumaLikesTw / 6.0));
        System.out.println("   Facebook promedio = " + (sumaLikesFb / 6.0));

        sc.close();
        System.out.println("==================================================");
    }


    private static int pedirMes(Scanner sc, String mensaje) {
        int mes = -1;
        while (true) {
            System.out.print(mensaje + ": ");
            if (sc.hasNextInt()) {
                mes = sc.nextInt();
                if (mes >= 1 && mes <= 6) break;
            } else {
                sc.next();
            }
            System.out.println("   Entrada inválida. Debe ser un número entre 1 y 6.");
        }
        return mes;
    }


    private static double parseDoubleSafe(String s) {
        try {
            if (s == null) return 0;
            s = s.trim();
            if (s.isEmpty()) return 0;

            return Double.parseDouble(s);
        } catch (Exception e) {
            return 0;
        }
    }
}