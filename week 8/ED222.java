import java.util.Scanner;

public class ED222 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int T = sc.nextInt();

        int[] deep = new int[N];
        for (int i = 0; i < N; i++) {
            deep[i] = sc.nextInt();
        }
        int current = 0;
        int sum = 0;
        int primeiro = deep[0];
        for (int i = 0; i < K; i++) {
            if (deep[i] >= T) {
                sum += 1;
            }
        }

        // System.out.println(sum);

        if (sum >= K / 2.0) {
            current += 1;
        }

        for (int i = K; i < N; i++) {

            if (primeiro >= T) {
                sum -= 1;
            }
            primeiro = deep[i - K + 1];
            if (deep[i] >= T) {
                sum += 1;
            }

            if (sum >= K / 2.0) {
                current += 1;
            }

        }

        System.out.println(current);

        sc.close();
    }
}
