import java.util.Scanner;
import java.util.Arrays;

public class ED202 {
    static double menor = 10000000.00;
    static double[][] A;

    static void permutations(int v[]) {

        boolean used[] = new boolean[v.length]; // $i$ esta na permutacao?
        int perm[] = new int[v.length]; // permutacao actual
        goPerm(0, v, used, perm); // chamar funcao recursiva
    }

    static void goPerm(int cur, int v[], boolean used[], int perm[]) {
        if (cur == v.length) { // Caso base: terminamos a permutacao
            double sum = 0.0;
            for (int i = 1; i < v.length; i++) {// Escrever a permutacao
                // System.out.print(v[perm[i]] + " ");
                sum += A[v[perm[i - 1]]][v[perm[i]]];
            }
            sum += A[v[perm[v.length - 1]]][v[perm[0]]];
            if (sum < menor)
                menor = sum;
            // System.out.print(sum);
            // System.out.println();

        } else { // Se nao terminamos, continuar a gerar
            for (int i = 0; i < v.length; i++) // Tentar todos os elementos
                if (!used[i]) {
                    used[i] = true;
                    perm[cur] = i;
                    goPerm(cur + 1, v, used, perm);
                    used[i] = false;
                }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        sc.nextLine();

        A = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = sc.nextDouble();
            }
        }

        int[] lala = new int[N];
        for (int i = 0; i < N; i++) {
            lala[i] = i;
        }
        permutations(lala);
        // System.out.println(Arrays.toString(lala));

        // System.out.println(Arrays.deepToString(A));
        System.out.println(String.format("%.2f", menor));
        sc.close();
    }
}
