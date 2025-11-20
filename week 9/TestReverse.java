// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2526/
// -----------------------------------------------------------
// Invertendo um array (versao recursiva)
// -----------------------------------------------------------

import java.util.Arrays;

public class TestReverse {

    // Inverter array v entre posicoes start e end
    static void reverse(int v[], int start, int end) {
        if (start >= end)
            return; // Caso base: array de tamanho < 2
        int tmp = v[start]; // Trocar primeiro com ultimo
        v[start] = v[end];
        v[end] = tmp;
        reverse(v, start + 1, end - 1); // Chamada recursiva para o resto
    }

    // -----------------------------------------------------------

    public static void main(String[] args) {
        int v[] = { 2, 4, 6, 8, 10 }; // Inicializacao de array

        System.out.println("Antes  do reverse: " + Arrays.toString(v));
        reverse(v, 0, v.length - 1);
        System.out.println("Depois do reverse: " + Arrays.toString(v));
        System.out.println(capicua(new int[] { 1, 2, 3, 2, 1 }, 0, 4));
        System.out.println(capicua(new int[] { 5, 8, 8, 5 }, 0, 3));
        System.out.println(capicua(new int[] { 1, 2, 3, 1 }, 0, 3));
        System.out.println(capicua(new int[] { 5, 8, 7, 5 }, 0, 3));
    }

    static boolean capicua(int v[], int start, int end) {
        if (start == end) {
            return true;
        }
        if (end - start == 1) {
            if (v[start] == v[end]) {
                return true;
            } else {
                return false;
            }
        }
        if (v[start] != v[end]) {
            return false;
        } else {
            return capicua(v, start + 1, end - 1);
        }
    }
}