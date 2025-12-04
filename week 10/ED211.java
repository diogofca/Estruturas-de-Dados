public class ED211 {
    public static int countEven(BTree<Integer> t) {
        return countEvenInduction(t.getRoot());
    }

    private static int countEvenInduction(BTNode<Integer> n) {
        int counter = 0;
        if (n == null) {
            return 0;
        }
        if (n.getValue() % 2 == 0) {
            counter += 1;
        }
        return counter + countEvenInduction(n.getRight()) + countEvenInduction(n.getLeft());

    }

}