import java.util.Scanner;

public class Losangolo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.close();
        for (int i = 1; i <= n / 2; i++) {
            // print the individual rows
            int number_of_cardinals = 2 * i - 1;
            int number_of_dots = n - number_of_cardinals;
            for (int j = 1; j <= number_of_dots / 2; j++) {
                System.out.print(".");
            }
            for (int j = 1; j <= number_of_cardinals; j++) {
                System.out.print("#");
            }
            for (int j = 1; j <= number_of_dots / 2; j++) {
                System.out.print(".");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            System.out.print("#");
        }
        System.out.println();

        for (int i = n / 2; i >= 1; i--) {
            int number_of_cardinals = 2 * i - 1;
            // System.out.println(number_of_cardinals);
            int number_of_dots = n - number_of_cardinals;
            for (int j = 1; j <= number_of_dots / 2; j++) {
                System.out.print(".");
            }
            for (int j = 1; j <= number_of_cardinals; j++) {
                System.out.print("#");
            }
            for (int j = 1; j <= number_of_dots / 2; j++) {
                System.out.print(".");
            }
            System.out.println();
        }
    }
}