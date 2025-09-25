public class Numbers {
    public static void main(String[] args) {
        int n = 10;
        System.out.print("Números de um a " + n + ":");
        for (int i = 1; i <= n - 1; i++) {
            System.out.print(i + ",");
        }
        System.out.print(n);

    }
}