import java.util.Scanner;

public class ED006 {

    // indexamos players em um!

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        for (int u = 0; u < N; u++) {
            String frase = sc.nextLine();
            String[] palavras = frase.split(" ");
            String[] players = sc.nextLine().split(" ");
            // este indexamos em 1!!!!!!!!!!!

            // pôr os jogadores na lista ligada circular
            CircularLinkedList<String> jogadores = new CircularLinkedList<String>();
            for (int j = 1; j <= Integer.parseInt(players[0]); j++) {
                jogadores.addLast(players[j]);
            }

            String eleminado = jogar(jogadores, palavras.length);
            // System.out.println(eleminado);

            if (eleminado.equals("Carlos")) {
                System.out.println("O Carlos nao se livrou");
            } else {
                System.out.println(String.format("O Carlos livrou-se (coitado do %s!)", eleminado));
            }

        }
    }

    public static String jogar(CircularLinkedList<String> jogadores, int n_frase) {
        String removido = new String();
        String proximaIteracao = jogadores.getFirst();
        while (!jogadores.isEmpty()) {
            // System.out.println(jogadores);
            for (int i = 1; i < n_frase; i++) {

                jogadores.rotate();
            }
            removido = jogadores.getFirst();

            // if (removido.equals(proximaIteracao)) {
            // jogadores.removeFirst();
            // proximaIteracao = jogadores.getFirst();
            // } else {
            // jogadores.removeFirst();
            // }
            jogadores.removeFirst();

            // girarAteCertoElemento(jogadores, proximaIteracao);
        }

        return removido;
    }

    public static void girarAteCertoElemento(CircularLinkedList<String> l, String e) {
        if (l.isEmpty()) {
            return;
        }
        while (!l.getFirst().equals(e)) {
            l.rotate();
        }
    }

}
