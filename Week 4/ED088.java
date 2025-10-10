/* -----------------------------------
  Estruturas de Dados 2024/2025
  Jogo da Vida [ED088]  
----------------------------------- */

import java.util.Scanner;
import java.util.Arrays;

// Classe para representar um jogo
class Game {
    final char DEAD = '.'; // Constante que indica uma celula morta
    final char ALIVE = 'O'; // Constante que indica uma celula viva
    private int rows, cols; // Numero de linhas e colunas
    private char m[][]; // Matriz para representar o estado do jogo

    // Construtor: inicializa as variaveis tendo em conta a dimensao dada
    Game(int r, int c) {
        rows = r;
        cols = c;
        m = new char[r][c];
    }

    // Metodo para ler o estado inicial para a matriz m[][]
    public void read(Scanner in) {
        for (int i = 0; i < rows; i++)
            m[i] = in.next().toCharArray();
    }

    // Metodo para escrever a matriz m[][]
    public void write() {
        // ... por completar
        for (int i = 0; i < rows; i++) {
            String toPrint = new String(m[i]);
            System.out.println(toPrint);
        }
    }

    // Deve devolver o numero de celulas vivas que sao vizinhas de (y,x)
    private int countAlive(int y, int x) {
        int count = 0;
        // ... por completar

        for (int i = 0; i < 3; i++) {
            try {
                if (m[y - 1][x - 1 + i] == ALIVE) {
                    count++;
                }
            } catch (IndexOutOfBoundsException e) {
                // literally do nothing
            }
        }
        for (int i = 0; i < 3; i++) {
            try {
                if (m[y + 1][x - 1 + i] == ALIVE) {
                    count++;
                }
            } catch (IndexOutOfBoundsException e) {
                // literally do nothing
            }
        }

        try {
            if (m[y][x - 1] == ALIVE) {
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // literally do nothing
        }

        try {
            if (m[y][x + 1] == ALIVE) {
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // literally do nothing
        }
        return count;
    }

    // Deve fazer uma iteracao: cria nova geracao a partir da actual
    public void iterate() {
        char[][] newBoard = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int numberOfCellsAlive = this.countAlive(i, j);
                if ((numberOfCellsAlive <= 1 || numberOfCellsAlive >= 4) && this.m[i][j] == ALIVE) {
                    newBoard[i][j] = DEAD;
                } else if ((numberOfCellsAlive == 2 || numberOfCellsAlive == 3) && this.m[i][j] == ALIVE) {
                    newBoard[i][j] = ALIVE;
                } else if (this.m[i][j] == DEAD && numberOfCellsAlive == 3) {
                    newBoard[i][j] = ALIVE;
                } else {
                    newBoard[i][j] = DEAD;
                }
            }
        }
        this.m = newBoard;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(this.m);
    }

}

// Classe principal com o main()
public class ED088 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Ler linhas, colunas e numero de iteracoes
        int rows = in.nextInt();
        int cols = in.nextInt();
        int n = in.nextInt();

        // Criar objecto para conter o jogo e ler estado inicial
        Game g = new Game(rows, cols);
        g.read(in);

        for (int i = 0; i < n; i++) {
            g.iterate();
        }
        g.write();
        // ... por completar
    }
}
