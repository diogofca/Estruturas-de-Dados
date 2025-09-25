import java.util.Scanner;

public class Estatisticas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String numbers = sc.nextLine();
        String[] numbers_individually = numbers.split(" ");
        int sum = 0;
        int max = Integer.parseInt(numbers_individually[0]);
        int min = Integer.parseInt(numbers_individually[0]);
        for (int i = 0; i < numbers_individually.length; i++) {
            int a = Integer.parseInt(numbers_individually[i]);
            sum += a;
            if (a > max) {
                max = a;
            }
            if (a < min) {
                min = a;
            }
        }
        System.out.printf("%.2f\n", sum / (double) n);
        System.out.println(max - min);
        // find max
        sc.close();
    }
}
