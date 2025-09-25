import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Primos {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        String input = sn.nextLine();
        String[] input_divided = input.split(" ");
        int A = Integer.parseInt(input_divided[0]);
        int B = Integer.parseInt(input_divided[1]);
        // ArrayList<Integer> list = erastotenes(B);
        // // System.out.println(list);
        // list.removeIf(n -> n < A);
        // System.out.println(list.size());
        int[] list = erastotenes(A, B);

        int sum = 0;
        for (int i = A; i < list.length; i++) {
            if (list[i] != 0) {
                sum += 1;
            }
        }
        System.out.println(sum);

    }

    static int[] erastotenes(int A, int B) {
        int[] list = new int[B + 1];
        for (int i = 0; i <= B; i++) {
            list[i] = i;
        }

        for (int i = 2; i < list.length; i++) {
            int k = list[i];
            if (k == 0) {
                continue;
            } else {
                for (int l = 2 * k; l <= B; l += k) {
                    list[l] = 0;
                }
            }
        }
        // System.out.println(list);
        // this is a comment
        return list;
    }

    static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        } else {
            for (int i = 2; (i <= Math.ceil(Math.sqrt(n))) && (i != n); i++) {
                // System.out.print(i);
                // for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
