import java.util.Comparator;
import java.util.Scanner;

public class ED215 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        MinHeap<Offer> mm = new MinHeap<>(N, new OfferComparator());
        for (int i = 0; i < N; i++) {
            if (sc.next().equals("OFERTA")) {
                mm.insert(new Offer(sc.next(), sc.nextInt()));
            } else {
                System.out.println(mm.removeMin());
            }
        }
        sc.close();
    }

}

class OfferComparator implements Comparator<Offer> {
    public int compare(Offer a, Offer b) {
        return b.getValue() - a.getValue();
    }
}

class Offer {
    private String name;
    private int value;

    Offer(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%d %s", this.value, this.name);
    }
}