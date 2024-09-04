import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaApplication11 {
    private static final Map<Integer, String> numToWordsEs = new HashMap<>();
    private static final Map<Integer, String> numToWordsEn = new HashMap<>();

    static {
        // Inicialización de números a palabras en español
        String[] unidades = {"", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
        String[] especiales = {"cero", "diez", "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve", "veinte"};
        String[] decenas = {"", "", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};

        for (int i = 0; i <= 20; i++) {
            numToWordsEs.put(i, especiales[i]);
        }
        for (int i = 21; i < 100; i++) {
            if (i % 10 == 0) {
                numToWordsEs.put(i, decenas[i / 10]);
            } else {
                numToWordsEs.put(i, decenas[i / 10] + " y " + unidades[i % 10]);
            }
        }
        numToWordsEs.put(100, "cien");

        // Inicialización de números a palabras en inglés
        String[] unitsEn = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] teensEn = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tensEn = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        for (int i = 0; i <= 9; i++) {
            numToWordsEn.put(i, unitsEn[i]);
        }
        for (int i = 10; i <= 19; i++) {
            numToWordsEn.put(i, teensEn[i - 10]);
        }
        for (int i = 20; i < 100; i++) {
            if (i % 10 == 0) {
                numToWordsEn.put(i, tensEn[i / 10]);
            } else {
                numToWordsEn.put(i, tensEn[i / 10] + "-" + unitsEn[i % 10]);
            }
        }
        numToWordsEn.put(100, "one hundred");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese el primer número en un rango entre 0-100:");
        int Num_1 = scan.nextInt();

        System.out.println("Ingrese el segundo número en un rango entre 0-100:");
        int Num_2 = scan.nextInt();

        int suma = Num_1 + Num_2;

        String Num_1TextEsp = numToWordsEs.get(Num_1);
        String Num_2TextEsp = numToWordsEs.get(Num_2);
        String SumTextEsp = numToWordsEs.get(suma);

        String Num_1TextEng = numToWordsEn.get(Num_1);
        String Num_2TextEng = numToWordsEn.get(Num_2);
        String SumTextEng = numToWordsEn.get(suma);

        System.out.println("La suma de " + Num_1TextEsp + " más " + Num_2TextEsp + " es " + SumTextEsp);
        System.out.println("The sum of " + Num_1TextEng + " plus " + Num_2TextEng + " is " + SumTextEng);
    }
}
