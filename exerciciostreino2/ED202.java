import java.util.Scanner;

public class ED202 {
    // Escrever todos as permutacoes do array v[]
    static void permutations(int v[]) {
        boolean used[] = new boolean[v.length]; // $i$ esta na permutacao?
        int perm[] = new int[v.length]; // permutacao actual
        goPerm(0, v, used, perm); // chamar funcao recursiva
    }

    // Gera todos os subconjuntos a partir da posicao 'cur'
    static void goPerm(int cur, int v[], boolean used[], int perm[]) {
        if (cur == v.length) { // Caso base: terminamos a permutacao
            double sum = 0.0;
            for (int i = 0; i < v.length - 1; i++) {
                // System.out.println(board[v[i]][v[i + 1]]);
                sum += board[v[perm[i]]][v[perm[i + 1]]];
            }
            sum += board[v[perm[v.length - 1]]][v[perm[0]]];

            // System.out.println(board[v[v.length - 1]][v[0]]);
            // System.out.println(sum);
            // System.out.println(sum);
            if (sum < min) {
                min = sum;
            }

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

    // -----------------------------------------------------------
    static double[][] board;
    static double min = Double.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        sc.nextLine();
        board = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextDouble();
            }
        }
        int[] lala = new int[N];
        for (int i = 0; i < N; i++) {
            lala[i] = i;
        }
        permutations(lala);

        System.out.println(String.format("%.2f", min));
        sc.close();
    }
}
