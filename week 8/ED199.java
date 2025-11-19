import java.util.Scanner;

public class ED199 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfChests = sc.nextInt();
        int initialPosition = sc.nextInt();
        // lalala
        int numberOfInstructions = sc.nextInt();
        sc.nextLine();
        String chests = sc.nextLine();
        // lala
        int max = initialPosition;
        int min = initialPosition;
        int[] instructions = new int[numberOfInstructions];
        for (int i = 0; i < numberOfInstructions; i++) {

            String instruction = sc.next();
            if (instruction.charAt(0) == 'D') {
                instructions[i] = Integer.parseInt(sc.next());
            } else {
                instructions[i] = -Integer.parseInt(sc.next());
            }
            // segunda submissao
        }
        for (int i = 0; i < numberOfInstructions; i++) {
            initialPosition += instructions[i];
            min = Math.min(min, initialPosition);
            max = Math.max(max, initialPosition);
        }
        int counter = 0;
        for (int i = min - 1; i < max; i++) {
            if (chests.charAt(i) == 'T') {
                counter += 1;
            }
        }
        // int[] prefix = new int[numberOfChests + 1];
        // for (int i = 1; i <= numberOfChests; i++) {
        // prefix[i] = prefix[i - 1] + (chests.charAt(i - 1) == 'T' ? 1 : 0);
        // }
        // int total = prefix[max] - prefix[min - 1];
        // // lALALlsjgsbdrg beruioae gr
        System.out.println(counter);
        // lala
    }
}
