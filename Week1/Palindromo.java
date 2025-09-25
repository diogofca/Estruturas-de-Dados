import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Palindromo {
    static boolean isPalindrome(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                return false;
            }
        }
        return true;

    }

    static boolean isAlphaNumeric(char c) {
        return (c >= (int) 'a' || c <= (int) 'z');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n);
        String buffer = sc.nextLine();
        for (int i = 0; i < n; i++) {
            String palavra = sc.nextLine();
            palavra = palavra.toLowerCase();
            palavra = palavra.replaceAll("[^a-z]", "");
            if (isPalindrome(palavra)) {
                System.out.println("sim");
            } else {

                System.out.println("nao");
            }

        }
        sc.close();
    }
}
