import java.util.Scanner;

public class ED201 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxduration = sc.nextInt();
        int N = sc.nextInt();
        int[] musicas = new int[N];
        for (int i = 0; i < N; i++) {
            musicas[i] = sc.nextInt();
        }
        System.out.println(melhor(musicas, maxduration));
    }

    // Escrever todos as permutacoes do array v[]
    static void permutations(int v[]) {
        boolean used[] = new boolean[v.length]; // $i$ esta na permutacao?
        int perm[] = new int[v.length]; // permutacao actual
        goPerm(0, v, used, perm); // chamar funcao recursiva
    }

    // Gera todos os subconjuntos a partir da posicao 'cur'
    static void goPerm(int cur, int v[], boolean used[], int perm[]) {
        if (cur == v.length) { // Caso base: terminamos a permutacao
            for (int i = 0; i < v.length; i++) // Escrever a permutacao
                System.out.print(v[perm[i]] + " ");
            System.out.println();
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

    public static int melhor(int[] musicas, int maxduration) {
        if (musicas.length == 1) {
            if (musicas[0] <= maxduration) {
                return musicas[0];
            } else {
                return 0;
            }
        } else {
            int[] newmusicas = new int[musicas.length - 1];
            for (int i = 0; i < newmusicas.length; i++) {
                newmusicas[i] = musicas[i + 1];
            }
            int p = melhor(newmusicas, maxduration - musicas[0]) + musicas[0];
            int p2 = melhor(newmusicas, maxduration);
            if (p > maxduration) {
                return p2;
            } else if (p > p2) {
                return p;
            } else {
                return p2;
            }
        }
    }
}
