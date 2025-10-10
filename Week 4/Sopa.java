import java.util.Scanner;

public class Sopa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int k = 1;
        while (M != 0) {
            sc.nextLine();
            char[][] board = new char[M][N];
            for (int i = 0; i < M; i++) {
                board[i] = sc.nextLine().toCharArray();
            }
            // temos aqui o nosso board
            int G = sc.nextInt();
            sc.nextLine();
            String[] palavras = new String[G];
            for (int i = 0; i < G; i++) {
                palavras[i] = sc.nextLine();
            }

            // System.out.println(Arrays.deepToString(board));
            // System.out.println(Arrays.toString(palavras));

            int[][] checkado = new int[M][N];

            for (int i = 0; i < M; i++) {
                checkado[i] = checkarSequencia(board[i], palavras);
                // System.out.println(Arrays.toString(checkado[i]));
            }

            char[][] boardRevsersed = new char[N][M];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    boardRevsersed[j][i] = board[i][j];
                }
            }
            int[][] chackedColsRevsered = new int[N][M];
            for (int i = 0; i < N; i++) {
                chackedColsRevsered[i] = checkarSequencia(boardRevsersed[i], palavras);
            }

            int[][] checkedCols = new int[M][N];

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    checkedCols[i][j] = chackedColsRevsered[j][i];
                }
            }
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (checkedCols[i][j] == 0 && checkado[i][j] == 0) {
                        board[i][j] = '.';
                    }
                }
            }

            // System.out.println(Arrays.deepToString(board));

            // print everythin
            System.out.println(String.format("Input #%d", k));
            k++;
            for (int i = 0; i < M; i++) {
                String toPrint = new String(board[i]);
                System.out.println(toPrint);
            }

            // isto já faz parte do próximo
            M = sc.nextInt();
            N = sc.nextInt();

        }

        sc.close();
    }

    static int[] checkarSequencia(char[] sequence, String[] palavras) {
        int[] toReturn = new int[sequence.length];
        for (String palavra : palavras) {
            String sequenceString = new String(sequence);
            if (sequenceString.contains(palavra)) {
                // System.out.println("Aqui");
                int firstIndex = sequenceString.indexOf(palavra);
                for (int i = firstIndex; i < firstIndex + palavra.length(); i++) {
                    toReturn[i] = 1;
                }
            }

        }

        // revsersed array
        char[] reversed = new char[sequence.length];
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = sequence[sequence.length - 1 - i];
        }

        int[] toReturnReversed = new int[reversed.length];

        for (String palavra : palavras) {
            String sequenceString = new String(reversed);
            if (sequenceString.contains(palavra)) {
                // System.out.println("Aqui");
                int firstIndex = sequenceString.indexOf(palavra);
                for (int i = firstIndex; i < firstIndex + palavra.length(); i++) {
                    toReturnReversed[i] = 1;
                }
            }

        }
        // System.out.println(Arrays.toString(toReturnReversed));

        for (int i = 0; i < toReturn.length; i++) {
            if (toReturnReversed[toReturnReversed.length - 1 - i] == 1) {
                toReturn[i] = 1;
            }
        }

        return toReturn;
    }
}
