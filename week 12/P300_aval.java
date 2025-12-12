// -----------------------------------------------------------
// Estruturas de Dados 2025/2026 (CC1007) - DCC/FCUP
// ED300 - code provide to be completed
// Note: it uses a specific tree of integers
// -----------------------------------------------------------

import java.util.*;

// define a tree node
class BTNode<T> {
    private T value; // node value
    private BTNode<T> left; // left child
    private BTNode<T> right; // right child

    // Constructor
    BTNode(T v, BTNode<T> l, BTNode<T> r) {
        value = v;
        left = l;
        right = r;
    }

    // Getters and Setters
    public T getValue() {
        return value;
    }

    public BTNode<T> getLeft() {
        return left;
    }

    public BTNode<T> getRight() {
        return right;
    }

    public void setValue(T v) {
        value = v;
    }

    public void setLeft(BTNode<T> l) {
        left = l;
    }

    public void setRight(BTNode<T> r) {
        right = r;
    }
}

// define a binary tree of integers

class BTree {
    private BTNode<Integer> root; // tree root

    // Constructor
    BTree() {
        root = null;
    }

    public int countNodesWithGrandParentMultipleOfK(int k) {
        return helper(k, this.root);
    }

    private int helper(int k, BTNode<Integer> n) {
        int counter = 0;

        if (n == null) {
            return counter;
        }

        try {
            int primeiro = n.getLeft().getLeft().getValue();
            if (n.getValue() % k == 0) {
                counter += 1;
            }
        } catch (NullPointerException e) {
            // do nothing;
        }
        try {
            int primeiro = n.getLeft().getRight().getValue();
            if (n.getValue() % k == 0) {
                counter += 1;
            }
        } catch (NullPointerException e) {
            // do nothing;
        }
        try {
            int primeiro = n.getRight().getRight().getValue();
            if (n.getValue() % k == 0) {
                counter += 1;
            }
        } catch (NullPointerException e) {
            // do nothing;
        }

        try {
            int primeiro = n.getRight().getLeft().getValue();
            if (n.getValue() % k == 0) {
                counter += 1;
            }
        } catch (NullPointerException e) {
            // do nothing;
        }
        return counter + helper(k, n.getRight()) + helper(k, n.getLeft());
    }

    // verifies if tree is empty
    public boolean isEmpty() {
        return root == null;
    }

    // reads a tree in PreOrder
    // input must be as described in the examples input
    public void readTreePreOrder(Scanner in) {
        root = readIntNode(in);
    }

    // helper method
    private BTNode<Integer> readIntNode(Scanner in) {
        String s = in.next();
        if (s.equals("N"))
            return null;
        Integer value = Integer.parseInt(s);
        BTNode<Integer> left = readIntNode(in);
        BTNode<Integer> right = readIntNode(in);
        return new BTNode<Integer>(value, left, right);
    }

    // required methods to answer to ED300 problem

}

// class that gives name to the file to be compiled
// advise to test locally your solutions before submitting
class P300_aval {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nc = in.nextInt(); // num. of cases

        for (int i = 0; i < nc; i++) {
            BTree t = new BTree(); // binary tree of integers
            t.readTreePreOrder(in);
            int k = in.nextInt();
            System.out.println("Case " + (i + 1) + ":");
            System.out.println(String.format("Num Nodes with Grand Parente multiple of %d= %d", k,
                    t.countNodesWithGrandParentMultipleOfK(k)));
            // print num of nodes whose grand-parent node is multiple of k
            // call the method you implemented in BTree

        }
    }
}
