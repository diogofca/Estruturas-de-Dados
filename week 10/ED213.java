public class ED213 {
    public static String maxSum(BTree<Integer> t) {
        StringBuilder toReturn = new StringBuilder();
        maxSumInduction(t.getRoot(), toReturn);
        return toReturn.toString();
    }

    private static void maxSumInduction(BTNode<Integer> n, StringBuilder toReturn) {
        if (n == null) {
            return;
        }
        if (maxSumInduction2(n.getRight()) > maxSumInduction2(n.getLeft())) {
            toReturn.append('D');
            maxSumInduction(n.getRight(), toReturn);
        } else if (maxSumInduction2(n.getRight()) < maxSumInduction2(n.getLeft())) {
            toReturn.append('E');
            maxSumInduction(n.getLeft(), toReturn);
        }

    }

    private static int maxSumInduction2(BTNode<Integer> n) {
        if (n == null) {
            return 0;
        } else {
            return n.getValue() + Math.max(maxSumInduction2(n.getRight()), maxSumInduction2(n.getLeft()));
        }
    }
}
