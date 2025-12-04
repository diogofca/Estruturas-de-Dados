import java.util.Scanner;

public class ED164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String[] palavras = new String[N];
        for (int i = 0; i < N; i++) {
            palavras[i] = sc.next();
        }
        BSTree<String> tree = new BSTree<>();
        for (int i = 0; i < N; i++) {
            tree.insert(palavras[i]);
        }
        System.out.println(tree.numberNodes());
    }
}
