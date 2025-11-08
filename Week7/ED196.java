public class ED196 {
    public static void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b) {
        int n = q.size() / 2;
        for (int i = 0; i < n; i++) {
            String name = q.dequeue();
            String command = q.dequeue();
            if (command.equals("A")) {
                a.enqueue(name);
            } else if (command.equals("B")) {
                b.enqueue(name);
            } else {
                if (a.size() > b.size()) {
                    b.enqueue(name);
                } else if (b.size() > a.size()) {
                    a.enqueue(name);
                }
            }
        }
    }
}