import java.util.Scanner;

public class ED282 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        int N = sc.nextInt();
        sc.nextLine();

        MyQueue<Person> q = new LinkedListQueue<>();
        for (int i = 0; i < N; i++) {
            String[] input = sc.nextLine().split(" ");
            // System.out.println(input);
            q.enqueue(new Person(input[0], Integer.parseInt(input[1])));
        }
        rotate(q, T);
        sc.close();

    }

    public static void rotate(MyQueue<Person> q, int T) {
        int day = 0;
        int TVSoldOnDay = 0;
        int TVSoldTotal = 0;
        while (!q.isEmpty()) {
            day += 1;
            int G = q.size();
            for (int i = 0; i < G; i++) {
                if (q.first().numberOfTVs > T) {
                    q.first().numberOfTVs -= T;
                    q.enqueue(q.dequeue());
                    TVSoldOnDay += T;
                    TVSoldTotal += T;
                } else {
                    Person toGoHome = q.dequeue();
                    TVSoldOnDay += toGoHome.numberOfTVs;
                    TVSoldTotal += toGoHome.numberOfTVs;
                    System.out.println(String.format("%s %d %d %d", toGoHome.name, day, TVSoldOnDay, TVSoldTotal));

                }
            }
            TVSoldOnDay = 0;

        }

    }
}

class Person {
    String name;
    int numberOfTVs;

    Person(String name, int numberOfTVs) {
        this.name = name;
        this.numberOfTVs = numberOfTVs;
    }

    @Override
    public String toString() {
        return String.format("%s %d", name, numberOfTVs);
    }
}