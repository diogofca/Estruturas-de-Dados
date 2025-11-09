import java.util.Scanner;

public class ED029 {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        // numero de casos a analisar está aqui
        sc.nextLine();
        for (int m = 0; m<C; m++) {
            int L = sc.nextInt();
            int A = sc.nextInt();
            sc.nextLine();
            MyQueue<Plane> departures = new LinkedListQueue<Plane>();
            for (int j = 0; j<L; j++) {
                String newPlaneString = sc.nextLine();
                String[] newPlaneStringArray = newPlaneString.split(" ");
                String planeName = newPlaneStringArray[0];
                int estimatedTime = Integer.parseInt(newPlaneStringArray[1]);

                departures.enqueue(new Plane(planeName, estimatedTime));
            }
            MyQueue<Plane> arrivals = new LinkedListQueue<Plane>();
            for (int j = 0; j<A; j++) {
                String newPlaneString = sc.nextLine();
                String[] newPlaneStringArray = newPlaneString.split(" ");
                String planeName = newPlaneStringArray[0];
                int estimatedTime = Integer.parseInt(newPlaneStringArray[1]);

                arrivals.enqueue(new Plane(planeName, estimatedTime));
            }

            // System.out.println(departures);
            // System.out.println(arrivals);

        int N = departures.size() + arrivals.size();
        MyQueue<Plane> finalOrderArrivals = new LinkedListQueue<Plane>();
        MyQueue<Plane> finalOrderDepartures = new LinkedListQueue<Plane>();
        
            // System.out.println(N);
        int i = 1;
        while (!arrivals.isEmpty() || !departures.isEmpty() ) {

            Plane toLand = arrivals.first();
            Plane toGo = departures.first();


            if (toLand == null) {
                if (toGo.estimatedTime>i) {
                i++;
                continue;}

                // System.out.println("null1");
                departures.dequeue();
                finalOrderDepartures.enqueue(new Plane(toGo.name, i-toGo.estimatedTime));
                i++;
                continue;
            } else if (toGo == null) {

                if (toLand.estimatedTime>i) {
                i++;
                continue;}

                // System.out.println("null2");
                arrivals.dequeue();
                finalOrderArrivals.enqueue(new Plane(toLand.name, i-toLand.estimatedTime));
                i++;
                continue;
            }
            if (toLand.estimatedTime > i &&  toGo.estimatedTime>i) {
                i++;
            continue;}
            if (toLand.estimatedTime>toGo.estimatedTime) {
                // System.out.println("departed");
                departures.dequeue();
                finalOrderDepartures.enqueue(new Plane(toGo.name, i-toGo.estimatedTime));
            } else if (toLand.estimatedTime<toGo.estimatedTime) {
                // System.out.prin
                arrivals.dequeue();
                finalOrderArrivals.enqueue(new Plane(toLand.name, i-toLand.estimatedTime));
            } else {
                arrivals.dequeue();
                finalOrderArrivals.enqueue(new Plane(toLand.name, i-toLand.estimatedTime));
            }
            i++;
        }


        System.out.println(String.format("%d %d", L, A));


        int T = finalOrderDepartures.size();
        for (int t = 0; t<T; t++) {
            finalOrderDepartures.dequeue().print();
        }
        T = finalOrderArrivals.size();
        for (int t = 0; t<T; t++) {
            finalOrderArrivals.dequeue().print();
        }
        }

        // we now have finalOrderArrivals, finalOrderDepartures
        //
        //
        //


    
    }

}


class Plane {
    String name;
    int estimatedTime;
    public Plane(String name, int estimatedTime) {
        this.name = name;
        this.estimatedTime = estimatedTime;
    }


    public void print() {
        System.out.println(String.format("%s %d", this.name, this.estimatedTime ));
    }

}
