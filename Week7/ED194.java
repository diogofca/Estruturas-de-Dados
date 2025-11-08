public class ED194 {
    public static void reverse(MyStack<Integer> s, int n) {
        int[] paraInverter = new int[n];
        for (int i = 0; i < n; i++) {
            paraInverter[i] = s.pop();
        }
        for (int i = 0; i < n; i++) {
            s.push(paraInverter[i]);
        }
    }
}
