import java.util.Scanner;

public class ED201 {
    static int melhor = 0;
    static int D;
    static int N;

    static void sets(int v[]) {
        // array de booleanos para representar o conjunto
        boolean used[] = new boolean[v.length];
        goSets(0, v, used); // chamar funcao recursiva
    }

    static void goSets(int cur, int v[], boolean used[]) {
        if (cur == v.length) { // Caso base: terminamos o conjunto
            // Escrever conjunto
            // System.out.print("Set:");
            int soma = 0;
            for (int i = 0; i < v.length; i++)
                if (used[i])
                    soma += v[i];
            // System.out.print(" " + v[i]);
            // System.out.println();
            if (soma > melhor && soma <= D) {
                melhor = soma;
            }
        } else { // Se nao terminamos, continuar a gerar
            used[cur] = true; // Subconjuntos que incluem o elemento actual
            goSets(cur + 1, v, used);// Chamada recursiva
            used[cur] = false; // Subconjuntos que nao incluem o el. actual
            goSets(cur + 1, v, used);// Chamada recursiva
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        D = sc.nextInt();
        N = sc.nextInt();
        int[] musicas = new int[N];
        for (int i = 0; i < N; i++) {
            musicas[i] = sc.nextInt();
        }
        sets(musicas);
        System.out.println(melhor);

    }
}
