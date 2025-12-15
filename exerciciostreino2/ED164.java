import java.util.Scanner;

public class ED164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BSTree<String> palavras = new BSTree<String>();
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String lala = sc.next();
            if (palavras.contains(lala)) {
                // do nothin
            } else {
                palavras.insert(lala);
            }

        }
        System.out.println(palavras.numberNodes());
    }
}
