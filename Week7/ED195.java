public class ED195 {
    public static boolean balanced(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        MyStack<Character> n = new LinkedListStack<>();
        for (char i : s.toCharArray()) {
            if (i == '(' || i == '[' || i == '{') {
                n.push(i);
            } else {
                char retirado = n.pop();
                if ((retirado == '(' && i == ')') || (retirado == '[' && i == ']')) {

                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(balanced("()"));
    }
}