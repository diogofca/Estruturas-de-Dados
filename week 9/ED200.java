import java.util.Scanner;

public class ED200 {
    static int rows;
    static int cols;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int t = 0; t < N; t++) {
            int L = sc.nextInt();
            int C = sc.nextInt();
            rows = L;
            cols = C;
            sc.nextLine();
            char[][] board = new char[L][C];
            visited = new boolean[rows][cols];
            for (int i = 0; i < L; i++) {
                board[i] = sc.nextLine().toCharArray();
            }

            // fazer a coisa aqui
            System.out.println(motor(board));
        }
    }

    static int t(int y, int x, char[][] board) {
        if (y < 0 || y >= rows || x < 0 || x >= cols)
            return 0; // Caso base: fora dos limites
        if (visited[y][x])
            return 0; // Caso base: celula ja visitada
        if (board[y][x] == '.')
            return 0; // Caso base: celula vazia
        int count = 1; // celula nao vazia
        visited[y][x] = true; // marcar como visitada
        count += t(y - 1, x, board); // Adicionando celulas nao vizinhas
        count += t(y + 1, x, board);
        count += t(y, x + 1, board);
        count += t(y, x - 1, board);
        count += t(y - 1, x - 1, board);
        count += t(y - 1, x + 1, board);
        count += t(y + 1, x - 1, board);
        count += t(y + 1, x + 1, board);
        return count;
    }

    public static int motor(char[][] board) {
        int toReturn = t(0, 0, board);
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int l = t(i, j, board);
                if (l > toReturn) {
                    toReturn = l;
                }
            }
        }
        return toReturn;
    }
}
