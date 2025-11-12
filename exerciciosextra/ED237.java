import java.util.Scanner;

public class ED237 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        int N = sc.nextInt();
        sc.nextLine();

        SinglyLinkedList<Process> timeline = new SinglyLinkedList<Process>();
        for (int i = 0; i < N; i++) {
            String[] toAddString = sc.nextLine().split(" ");
            timeline.addLast(new Process(toAddString[0], Integer.parseInt(toAddString[1])));
        }
        sc.close();

        // System.out.println(timeline);
        rotate(timeline, T);

        // here we have all the inputs

    }

    public static void rotate(SinglyLinkedList<Process> l, int T) {
        int time = 0;
        int iteration = 0;
        while (!l.isEmpty()) {
            if (l.getFirst().time > T) {
                l.getFirst().time -= T;
                time += T;
                iteration += 1;
                Process toRotate = l.getFirst();
                // System.out.println(toRotate);
                l.removeFirst();
                l.addLast(toRotate);
                continue;
            } else if (l.getFirst().time <= T) {
                time += l.getFirst().time;
                iteration += 1;
                System.out.println(String.format("%s %d %d", l.getFirst().name, time, iteration));
                l.removeFirst();
                continue;
            }
        }
    }
}

class Process {
    String name;
    int time;

    Process(String name, int time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public String toString() {
        return String.format("name: %s; time: %d", this.name, this.time);
    }
}