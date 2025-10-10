import java.util.Scanner;

public class Galo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String[] board = new String[N];
        for (int i = 0; i < N; i++) {
            board[i] = sc.nextLine();
        }

        sc.close();

        String[] cols = new String[N];
        for (int i = 0; i < N; i++) {
            StringBuilder toAdd = new StringBuilder();
            for (int j = 0; j < N; j++) {
                toAdd.append(board[j].charAt(i));
            }
            cols[i] = toAdd.toString();
        }
        StringBuilder diagonalOne = new StringBuilder();
        for (int i = 0; i < N; i++) {
            diagonalOne.append(board[i].charAt(i));
        }
        StringBuilder diagonalTwo = new StringBuilder();
        for (int i = 0; i < N; i++) {
            diagonalTwo.append(board[i].charAt(N - 1 - i));
        }

        // System.out.println(diagonalOne.toString());
        // System.out.println(diagonalTwo.toString());

        for (int i = 0; i < N; i++) {
            if (testSequence(board[i])) {
                System.out.println(String.format("Ganhou o %c", board[i].charAt(0)));
                return;
            }
        }
        for (int i = 0; i < N; i++) {
            if (testSequence(cols[i])) {
                System.out.println(String.format("Ganhou o %c", board[i].charAt(0)));
                return;
            }
        }
        if (testSequence(diagonalOne.toString())) {
            System.out.println(String.format("Ganhou o %c", board[0].charAt(0)));
            return;
        }
        if (testSequence(diagonalTwo.toString())) {
            System.out.println(String.format("Ganhou o %c", board[0].charAt(N - 1)));
            return;
        }

        if (incomplete(board)) {
            System.out.println("Jogo incompleto");
        } else {
            System.out.println("Empate");
        }

        // aqui sabemos que o jogo está ou incompleto ou perdido

        // debugging purpouses
        // for (int i = 0; i < N; i++) {
        // System.out.println(board[i]);
        // }
    }

    private static boolean incomplete(String[] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; i < board.length; i++) {
                if (board[i].charAt(j) == '.') {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean testSequence(String sequence) {
        char first = sequence.charAt(0);
        // System.out.println(first);
        if (first == '.') {
            return false;
        } else {
            for (int i = 1; i < sequence.length(); i++) {
                if (sequence.charAt(i) != first) {
                    return false;
                }
            }
        }
        return true;
    }
}
