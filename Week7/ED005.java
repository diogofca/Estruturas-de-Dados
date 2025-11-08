import java.util.Scanner;

public class ED005 {

    public static void doLoop(String[] comandArray) {
        MyStack2<Integer> stack = new LinkedListStack2<Integer>();
        for (String j : comandArray) {
            if (j.equals("+")) {
                Integer first = stack.pop();
                Integer second = stack.pop();
                if (first == null || second == null) {
                    System.out.println("Expressao Incorrecta");
                    return;
                } else {
                    stack.push(first + second);
                }

            } else if (j.equals("-")) {

                Integer first = stack.pop();
                Integer second = stack.pop();
                if (first == null || second == null) {
                    System.out.println("Expressao Incorrecta");
                    return;
                } else {
                    stack.push(second - first);
                }
            } else if (j.equals("*")) {

                Integer first = stack.pop();
                Integer second = stack.pop();
                if (first == null || second == null) {
                    System.out.println("Expressao Incorrecta");
                    return;
                } else {
                    stack.push(first * second);
                }
            } else if (j.equals("/")) {

                Integer first = stack.pop();
                Integer second = stack.pop();
                if (first == null || second == null) {
                    System.out.println("Expressao Incorrecta");
                    return;
                } else {
                    stack.push(second / first);
                }
            } else {
                stack.push(Integer.parseInt(j));
            }
        }
        Integer toPrint = stack.pop();
        if (toPrint == null || stack.size() > 0) {
            System.out.println("Expressao Incorrecta");
        } else {
            System.out.println(toPrint);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String command = sc.nextLine();
            String[] comamndArray = command.split(" ");
            doLoop(comamndArray);
        }
    }
}
