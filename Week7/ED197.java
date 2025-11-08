public class ED197 {
    public static MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b) {
        LinkedListQueue<Integer> toReturn = new LinkedListQueue<>();
        int n = a.size() + b.size();
        for (int i = 0; i < n; i++) {
            if (a.size() == 0) {
                toReturn.enqueue(b.dequeue());
                continue;
            } else if (b.size() == 0) {
                toReturn.enqueue(a.dequeue());
                continue;
            }
            int A = a.first();
            int B = b.first();
            if (A > B) {
                toReturn.enqueue(B);
                b.dequeue();
            } else {
                toReturn.enqueue(A);
                a.dequeue();
            }
        }
        return toReturn;
    }
}
