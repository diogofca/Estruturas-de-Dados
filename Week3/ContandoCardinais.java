import java.util.Scanner;

public class ContandoCardinais {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int C = sc.nextInt();
        // tenha as linhas
        sc.nextLine();
        String[] linhas = new String[L];
        for (int i = 0; i < L; i++) {
            linhas[i] = sc.nextLine();
            // System.out.println(linhas[i]);
        }
        sc.close();
        // System.out.println(Arrays.toString(linhas));

        // tenho as colunas
        String[] colunas = new String[C];
        for (int i = 0; i < C; i++) {
            StringBuilder sn = new StringBuilder();
            for (int j = 0; j < L; j++) {
                sn.append(linhas[j].charAt(i));
            }
            colunas[i] = sn.toString();
        }

        // System.out.println(Arrays.toString(colunas));
        int[] result = finalizar(linhas, colunas);
        System.out.print(result[0] + " " + result[1] + "\n");
    }

    static int[] finalizar(String[] linhas, String[] colunas) {
        int[] toReturn = { contarMaior(linhas[0]), 1 };
        for (int i = 1; i < linhas.length; i++) {
            int a = contarMaior(linhas[i]);
            if (a > toReturn[0]) {
                toReturn[0] = a;
                toReturn[1] = 1;
            } else if (a == toReturn[0]) {
                toReturn[1] += 1;
            }
        }
        for (int i = 0; i < colunas.length; i++) {
            int a = contarMaior(colunas[i]);
            if (a > toReturn[0]) {
                toReturn[0] = a;
                toReturn[1] = 1;
            } else if (a == toReturn[0]) {
                toReturn[1] += 1;
            }
        }

        return toReturn;
    }

    static int contarMaior(String s) {
        // System.out.println(s);
        String[] dividido = s.split("\\.");
        // System.out.println(s);
        // System.out.println(Arrays.toString(dividido));
        int[] comprimentos = new int[dividido.length];
        for (int i = 0; i < comprimentos.length; i++) {
            comprimentos[i] = dividido[i].length();
        }
        // System.out.println(Arrays.toString(comprimentos));
        // System.out.println(Arrays.toString(comprimentos));
        // :w
        // System.out.println(max(comprimentos));
        return max(comprimentos);
    }

    static int max(int[] a) {
        int m = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > m) {
                m = a[i];
            }
        }
        return m;
    }

}
