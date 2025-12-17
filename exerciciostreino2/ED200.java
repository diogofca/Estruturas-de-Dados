import java.util.Scanner;

public class ED200 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for (int u = 0; u < N; u++) {
            int L = sc.nextInt();
            int C = sc.nextInt();
            sc.nextLine();
            char[][] board = new char[L][C];
            for (int i = 0; i < L; i++) {
                board[i] = sc.nextLine().toCharArray();
            }
            int[][] visisted = new int[L][C];
            int t = 0;
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < L; j++) {
                    int l = countcells(i, j, board, visisted);
                    if (l > t) {
                        t = l;
                    }
                }
            }
            System.out.println(t);

        }
    }

    public static int countcells(int i, int j, char[][] board, int[][] visisted) {
        int L = board.length;
        int C = board[0].length;
        if (i < 0 || i >= L || j < 0 || j >= C) {
            return 0;
        } else {
            if (visisted[i][j] == 1) {
                return 0;
            }
            visisted[i][j] = 1;
            if (board[i][j] == '#') {
                return 1 + countcells(i + 1, j, board, visisted) + countcells(i - 1, j, board, visisted)
                        + countcells(i, j + 1, board, visisted) + countcells(i, j - 1, board, visisted)
                        + countcells(i + 1, j + 1, board, visisted) + countcells(i + 1, j - 1, board, visisted)
                        + countcells(i - 1, j + 1, board, visisted) + countcells(i - 1, j - 1, board, visisted);
            } else {
                return 0;
            }
        }
    }
}
