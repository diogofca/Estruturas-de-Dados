
import java.util.Scanner;

public class ED198 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(kadane(data, N));
    }

    public static int maxTotal(int[] v, int n) {
        int maxSoFar = v[0]; // porque é esta uma boa escolha para a melhor soma inicial?
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) { // Todas as posicoes finais possiveis
                sum += v[j];
                // System.out.println("Soma entre " + i + " e " + j + " = " + sum);
                if (sum > maxSoFar)
                    maxSoFar = sum;
            }
        }
        return maxSoFar;
    }

    public static int kadane(int[] v, int n) {
        int[] best = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                best[i] = v[i];
            } else {
                if (best[i - 1] > 0) {
                    best[i] = best[i - 1] + v[i];
                } else {
                    best[i] = v[i];
                }
            }
        }

        int max = best[0];
        for (int i = 1; i < n; i++) {
            if (best[i] > max) {
                max = best[i];
            }
        }
        return max;
    }
}