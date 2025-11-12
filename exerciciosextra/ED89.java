import java.util.Scanner;
import java.util.Arrays;

public class ED89 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int flag = sc.nextInt();
        Object[] data = new Object[N];

        for (int i = 0; i < N; i++) {
            sc.nextLine();
            String NIF = sc.nextLine();
            String name = sc.nextLine();
            String AE = sc.nextLine();
            int codeAE = sc.nextInt();
            sc.nextLine();
            int income = sc.nextInt();
            data[i] = new Company(name, NIF, AE, codeAE, income);
        }

        // temos as cenas
        int i = 0;
        int[] differenteAE = new int[N];
        for (Object c : data) {
            Company d = (Company) c;
            if (isIn(d.codeAE, differenteAE, i)) {
                differenteAE[i] = d.codeAE;
                i++;
            } else {
                // do nothing
            }
        }

        if (flag == 0) {
            System.out.println(i);
        }
        int[] differenteAE2 = new int[i];
        for (int j = 0; j < i; j++) {
            differenteAE2[j] = differenteAE[j];
        }

        if (flag == 1) {
            Arrays.sort(differenteAE2);
            int[] sumsIncome = new int[differenteAE2.length];
            for (Object c : data) {
                Company d = (Company) c;
                for (int j = 0; j < differenteAE2.length; j++) {
                    if (d.codeAE == differenteAE2[j]) {
                        sumsIncome[j] += d.income;
                    }
                }
            }
            for (int j = 0; j < sumsIncome.length; j++) {
                System.out.println(String.format("%d %d", differenteAE2[j], sumsIncome[j]));
            }
        }
    }

    public static boolean isIn(int j, int[] a, int i) {
        for (int t = 0; t < i; t++) {
            if (a[t] == j) {
                return false;
            }
        }
        return true;
    }
}

class Company {
    String name;
    String NIF;
    String AE;
    int codeAE;
    int income;

    Company(String name, String NIF, String AE, int codeAE, int income) {
        this.name = name;
        this.NIF = NIF;
        this.AE = AE;
        this.codeAE = codeAE;
        this.income = income;
    }
}