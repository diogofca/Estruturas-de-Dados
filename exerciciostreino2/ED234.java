import java.util.Scanner;

public class ED234 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int flag = sc.nextInt();
        int N = sc.nextInt();

        if (flag == 1) {
            BSTree<String> filmes = new BSTree<String>();
            // System.out.println("lala");
            for (int i = 0; i < N; i++) {
                filmes.insert(sc.next());
                sc.nextInt();
            }
            System.out.println(filmes.numberNodes());
        } else if (flag == 2) {
            BSTMap<String, Integer> filmes = new BSTMap<String, Integer>();
            for (int i = 0; i < N; i++) {
                String filme = sc.next();
                sc.nextInt();
                if (filmes.get(filme) == null) {
                    filmes.put(filme, 1);
                } else {
                    filmes.put(filme, filmes.get(filme) + 1);
                }
            }
            int max = -1;
            String coiso = "";
            for (String filme : filmes.keys()) {
                if (filmes.get(filme) > max) {
                    max = filmes.get(filme);
                    coiso = filme;
                }
            }
            System.out.println(String.format("%s %d", coiso, max));
        } else {

            BSTMap<String, Integer> filmes = new BSTMap<String, Integer>();
            BSTMap<String, Integer> filmesFrequencua = new BSTMap<String, Integer>();

            for (int i = 0; i < N; i++) {
                String filme = sc.next();

                int pontuacao = sc.nextInt();
                if (filmes.get(filme) == null) {
                    filmes.put(filme, pontuacao);
                    filmesFrequencua.put(filme, 1);
                } else {
                    filmes.put(filme, filmes.get(filme) + pontuacao);
                    filmesFrequencua.put(filme, filmesFrequencua.get(filme) + 1);
                }
            }

            for (String filme : filmes.keys()) {
                if ((double) filmes.get(filme) / filmesFrequencua.get(filme) >= 5) {
                    System.out.println(filme);
                }
            }
        }
    }
}