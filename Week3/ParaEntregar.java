import java.util.Scanner;

public class ParaEntregar {
}

class Matrix {
    int data[][]; // os elementos da matriz em si
    int rows; // numero de linhas
    int cols; // numero de colunas

    // construtor padrao de matriz
    Matrix(int r, int c) {
        data = new int[r][c];
        rows = r;
        cols = c;
    }

    // Ler os rows x cols elementos da matriz
    public void read(Scanner in) {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                data[i][j] = in.nextInt();
    }

    // Representacao em String da matriz
    public String toString() {
        String ans = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                ans += data[i][j] + " ";
            ans += "\n";
        }
        return ans;
    }

    public static Matrix identity(int n) {
        Matrix toReturn = new Matrix(n, n);
        for (int i = 0; i < n; i++) {
            toReturn.data[i][i] = 1;
        }
        return toReturn;
    }

    public Matrix transpose() {
        Matrix toReturn = new Matrix(this.cols, this.rows);
        for (int i = 0; i < this.cols; i++) {
            for (int j = 0; j < this.rows; j++) {
                toReturn.data[i][j] = this.data[j][i];
            }
        }
        return toReturn;
    }

    public Matrix sum(Matrix m) {
        Matrix toReturn = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                toReturn.data[i][j] = this.data[i][j] + m.data[i][j];
            }
        }
        return toReturn;

    }

    public Matrix multiply(Matrix m) {
        Matrix toReturn = new Matrix(this.rows, m.cols);
        for (int i = 0; i < toReturn.rows; i++) {
            for (int j = 0; j < toReturn.cols; j++) {
                int sum = 0;
                for (int k = 0; k < this.cols; k++) {
                    sum += this.data[i][k] * m.data[k][j];
                }
                toReturn.data[i][j] = sum;
            }
        }
        return toReturn;
    }
}
