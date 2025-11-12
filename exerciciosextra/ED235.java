import java.util.Scanner;

public class ED235 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int []lala = new int[N];
        for (int i = 0; i<N; i++) {
            lala[i] = sc.nextInt();
            sc.nextLine();
        }
        for (int i = 0; i< N; i++) {
            for (int t = 0; t<lala[i]; t++) {
                printlala('#',lala[i]-t);
                printlala('.', t);
                System.out.println();
            }

        }
		

        sc.close();
	}

    public static void printlala(char c, int n) {
        for (int i = 0; i<n; i++) {
            System.out.print(c);
        }
    }
}
