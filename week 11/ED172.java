import java.util.Scanner;

public class ED172 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BSTMap1<String, Integer> dict = new BSTMap1<>();
        while (true) {
            try {
                String palavra = sc.next();
                if (dict.get(palavra) == null) {
                    dict.put(palavra, 1);
                } else {
                    Integer a = dict.get(palavra);
                    dict.remove(palavra);
                    dict.put(palavra, a + 1);

                }
            } catch (RuntimeException e) {
                break;
            }
        }
        for (String i : dict.keys()) {
            System.out.println(String.format("%s: %d", i, dict.get(i)));
        }
    }
}