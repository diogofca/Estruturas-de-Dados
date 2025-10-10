import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {
        String[] decks = { "Ouros", "Paus", "Copas", "Espadas" };
        String[] numbers = { "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove", "dez", "dama",
                "valete", "rei", "ás" };
        String[] cards = new String[decks.length * numbers.length];
        for (int i = 0; i < decks.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                cards[i * numbers.length + j] = numbers[j] + " de " + decks[i];
            }
        }

        System.out.println(String.join(", ", cards));
        double[][] a = {
                { 99.0, 85.0, 98.0, 0.0 },
                { 98.0, 57.0, 79.0, 0.0 },
                { 92.0, 77.0, 74.0, 0.0 },
                { 94.0, 62.0, 81.0, 0.0 },
                { 99.0, 94.0, 92.0, 0.0 },
                { 80.0, 76.5, 67.0, 0.0 },
                { 76.0, 58.5, 90.5, 0.0 },
                { 92.0, 66.0, 91.0, 0.0 },
                { 97.0, 70.5, 66.5, 0.0 },
                { 89.0, 89.5, 81.0, 0.0 },
                { 0.0, 0.0, 0.0, 0.0 }
        };
        System.out.println(a[1].length);
        System.out.println();
        Scanner sc = new Scanner(System.in);
        sc.close();

    }

}