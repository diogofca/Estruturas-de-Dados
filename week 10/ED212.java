public class ED212 {
    public static int[] sumLevels(BTree<Integer> t) {
        int[] toAdd = new int[t.depth() + 1];
        sumLevelsInduction(t.getRoot(), toAdd, 0);
        return toAdd;

    }

    private static void sumLevelsInduction(BTNode<Integer> n, int[] toAdd, int k) {
        if (n == null) {
            return;
        }
        toAdd[k] += n.getValue();
        sumLevelsInduction(n.getRight(), toAdd, k + 1);
        sumLevelsInduction(n.getLeft(), toAdd, k + 1);
        // lala
    }
}
