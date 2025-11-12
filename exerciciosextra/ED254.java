import java.util.Scanner;

public class ED254 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] toPrint = new int[N];
        for (int i = 0; i < N; i++) {
            toPrint[i] = sc.nextInt();
        }
        // lala
        for (int i = 0; i < N; i++) {
            printN(toPrint[i]);
        }

    }

    public static void printKLine(int k, int N) {
        for (int j = 0; j < k; j++) {
            System.out.print(".");
        }
        System.out.print("#");

        for (int j = 0; j < N - 2 * k - 2; j++) {
            System.out.print(".");
        }
        System.out.print("#");
        for (int j = 0; j < k; j++) {
            System.out.print(".");
        }
        System.out.println();
    }
    // lala

    public static void printN(int N) {

        for (int i = 0; i < N / 2; i++) {
            printKLine(i, N);
        }

        // parte de baixo
        for (int i = 0; i < N / 2 + 1; i++) {
            for (int j = 0; j < N / 2; j++) {
                System.out.print(".");
            }
            System.out.print("#");
            for (int j = 0; j < N / 2; j++) {
                System.out.print(".");
            }
            System.out.println();
        }
    }
}
