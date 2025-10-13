
// import java.util.List;
import java.util.Scanner;

public class Tartaruga {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int flag = sc.nextInt();
        int LINS = sc.nextInt();
        int COLS = sc.nextInt();

        Board b = new Board(LINS, COLS);
        // System.out.println(b.toString());

        sc.nextLine();

        String newIntruction = sc.nextLine();
        while (!newIntruction.equals("end")) {
            char first = newIntruction.charAt(0);
            if (first == 'D') {
                b.turtle.caneta = true;
                b.board[b.turtle.x][b.turtle.y] = Board.FULL;

                // System.out.println(b.turtle.direcao);
            } else if (first == 'U') {
                b.turtle.caneta = false;
            } else if (first == 'R') {
                b.virarDireita();
            } else if (first == 'L') {
                b.virarEsquerda();
            } else {

                int casasParaAndar = Integer.parseInt((String.format("%c", newIntruction.charAt(2))));
                // System.out.println(newIntruction);
                // System.out.println(casasParaAndar);
                b.walk(casasParaAndar);
                // System.out.println(b.toString());
            }

            newIntruction = sc.nextLine();
        }
        // System.out.println(b.toString());
        // System.out.println(b.toString());

        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();
        Board b1 = new Board(M, N);
        for (int i = 0; i < M; i++) {
            char[] toAdd = sc.nextLine().replaceAll(" ", "").toCharArray();
            b1.board[i] = toAdd;
        }
        // System.out.println(b1.toString());
        sc.close();

        if (flag == 0) {
            // System.out.println(b);
            b.printBoard();
        } else if (flag == 1) {
            System.out.println(String.format("%d %d %d", b.percentagemMarcadas(), b.numeroDeLinhasSemNada(),
                    b.numeroDeColunasSemNada()));
        } else if (flag == 2) {
            // System.out.println("aqui");
            // System.out.println(b1);
            for (int i = 0; i < b.LINS - b1.LINS; i++) {
                for (int j = 0; j < b.COLS - b1.COLS; j++) {
                    // System.out.println(b.subBoard(i, j, b1.LINS, b1.COLS));
                    if (b.subBoard(i, j, b1.LINS, b1.COLS).equals(b1)) {
                        System.out.println("Sim");
                        System.exit(1);
                    }
                }
            }
            System.out.println("Não");
            // do something here
        }
        // b.printBoard();
        // System.out.println(b.percentagemMarcadas());
        // System.out.println(b.numeroDeLinhasSemNada());
        // System.out.println(b.numeroDeColunasSemNada());
        // System.out.println(b.subBoard(3, 3, 2, 2));
        // temos aqui um comentário
    }
}

// lalalala

class Board {
    char[][] board;
    int LINS;
    int COLS;

    static char EMPTY = '.';
    static char FULL = '*';

    Turtle turtle;

    Board(int L, int C) {
        this.LINS = L;
        this.COLS = C;
        board = new char[L][C];
        turtle = new Turtle();
        for (int i = 0; i < LINS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public boolean equals(Board obj) {
        for (int i = 0; i < LINS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (this.board[i][j] != obj.board[i][j])
                    return false;
            }
        }

        return true;
    }

    Board subBoard(int i, int j, int l, int c) {
        Board toReturn = new Board(l, c);
        for (int v = i; v < i + l; v++) {
            for (int u = j; u < j + c; u++) {
                toReturn.board[v - i][u - j] = this.board[v][u];
            }
        }
        return toReturn;
    }

    void printBoard() {
        for (int i = 0; i < LINS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(this.board[i][j]);
                if (j != COLS - 1) {
                    System.out.print(" ");
                } else {
                    System.out.print("\n");
                }
            }
        }
    }

    int numeroDeLinhasSemNada() {
        int counter = 0;
        for (int i = 0; i < LINS; i++) {
            if (Board.temNada(this.board[i]))
                counter += 1;
        }

        return counter;
    }

    int numeroDeColunasSemNada() {
        int counter = 0;

        for (int j = 0; j < COLS; j++) {
            char[] coluna = new char[LINS];
            for (int i = 0; i < coluna.length; i++) {
                coluna[i] = this.board[i][j];
            }
            if (Board.temNada(coluna))
                counter += 1;
        }
        return counter;
    }

    static boolean temNada(char[] paraCheckar) {
        for (int j = 0; j < paraCheckar.length; j++) {
            if (paraCheckar[j] == Board.FULL)
                return false;
        }
        return true;
    }

    int percentagemMarcadas() {
        int total = COLS * LINS;
        int a = 0;
        for (int i = 0; i < LINS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == FULL) {
                    a += 1;
                }
            }
        }
        // System.out.println(a);
        // System.out.println(COLS);
        return a * 100 / total;

    }

    void virarDireita() {
        switch (this.turtle.direcao) {
            case SUL:
                this.turtle.direcao = Directions.OESTE;
                break;
            case NORTE:

                this.turtle.direcao = Directions.ESTE;
                break;
            case OESTE:
                this.turtle.direcao = Directions.NORTE;

                break;
            case ESTE:
                this.turtle.direcao = Directions.SUL;
                break;

            default:
                break;
        }
    }

    void virarEsquerda() {
        switch (this.turtle.direcao) {
            case SUL:
                this.turtle.direcao = Directions.ESTE;
                break;
            case NORTE:

                this.turtle.direcao = Directions.OESTE;
                break;
            case OESTE:
                this.turtle.direcao = Directions.SUL;

                break;
            case ESTE:
                this.turtle.direcao = Directions.NORTE;
                break;

            default:
                break;
        }
    }

    void walk(int numberOfSteps) {

        if (this.turtle.direcao == Directions.ESTE) {
            for (int i = 1; i <= numberOfSteps; i++) {
                try {
                    if (turtle.caneta)
                        board[this.turtle.x][this.turtle.y + i] = FULL;
                } catch (IndexOutOfBoundsException e) {
                    this.turtle.y = this.turtle.y + i - 1;
                    return;
                }
            }
            this.turtle.y = this.turtle.y + numberOfSteps;
        } else if (this.turtle.direcao == Directions.OESTE) {

            for (int i = 1; i <= numberOfSteps; i++) {
                try {
                    if (turtle.caneta)
                        board[this.turtle.x][this.turtle.y - i] = FULL;
                } catch (IndexOutOfBoundsException e) {
                    this.turtle.y = this.turtle.y - i + 1;
                    return;
                }
            }
            this.turtle.y = this.turtle.y - numberOfSteps;
        } else if (this.turtle.direcao == Directions.SUL) {
            // System.out.println("Aqui");

            for (int i = 1; i <= numberOfSteps; i++) {
                try {
                    if (turtle.caneta)
                        board[this.turtle.x + i][this.turtle.y] = FULL;
                } catch (IndexOutOfBoundsException e) {
                    this.turtle.x = this.turtle.x + i - 1;
                    return;
                }
            }
            this.turtle.x = this.turtle.x + numberOfSteps;
        } else if (this.turtle.direcao == Directions.NORTE) {
            for (int i = 1; i <= numberOfSteps; i++) {
                try {
                    if (turtle.caneta)
                        board[this.turtle.x - i][this.turtle.y] = FULL;
                } catch (IndexOutOfBoundsException e) {
                    this.turtle.x = this.turtle.x - i + 1;
                    return;
                }
                this.turtle.x = this.turtle.x - numberOfSteps;
            }

        }
    }

    void atulizarDirecaoTurtle(Directions novaDirecao) {
        this.turtle.direcao = novaDirecao;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < LINS; i++) {
            for (int j = 0; j < COLS; j++) {
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }
        sb.append(turtle.toString());
        return sb.toString();
    }
}

class Turtle {
    int x;
    int y;
    Directions direcao;
    boolean caneta;

    Turtle() {
        x = 0;
        y = 0;
        direcao = Directions.ESTE;
        caneta = true;

    }

    @Override
    public String toString() {
        return String.format("[%d, %d]", x, y);
    }
}

enum Directions {
    NORTE,
    SUL,
    ESTE,
    OESTE,
}