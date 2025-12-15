
// -----------------------------------------------------------
// Estruturas de Dados 2025/2026 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2526/
// -----------------------------------------------------------
// Arvore binaria "normal"
// -----------------------------------------------------------
import java.util.Arrays;

public class BTree<T> {
    private BTNode<T> root; // raiz da arvore

    // Construtor
    BTree() {
        root = null;
    }

    public int level(T v) {
        if (this.root == null) {
            return -1;
        }
        int[] levels = new int[this.depth() + 1];
        helper(this.root, levels, 0, v);
        // System.out.println(Arrays.toString(levels));
        int max = 0;
        int level = -1;
        for (int i = 0; i <= this.depth(); i++) {
            if (levels[i] != 0) {
                level = i;
                break;
            }
        }
        return level;
    }

    private void helper(BTNode<T> n, int[] eusoulindo, int k, T v) {
        if (n == null) {
            return;
        }
        if (n.getValue().equals(v)) {
            eusoulindo[k] += 1;
        }
        helper(n.getLeft(), eusoulindo, k + 1, v);
        helper(n.getRight(), eusoulindo, k + 1, v);
    }

    public int count() {
        return countInduction(this.root);
    }

    private int countInduction(BTNode<T> n) {
        if (n == null) {
            return 0;
        }
        if ((n.getLeft() == null && n.getRight() != null) || (n.getLeft() != null && n.getRight() == null)) {
            return 1 + countInduction(n.getLeft()) + countInduction(n.getRight());
        } else {

            return countInduction(n.getLeft()) + countInduction(n.getRight());
        }
    }

    public int internal() {
        return intervalInduction(this.root);
    }

    private int intervalInduction(BTNode<T> n) {
        if (n == null || (n.getLeft() == null && n.getRight() == null)) {
            return 0;
        } else {
            return 1 + intervalInduction(n.getLeft()) + intervalInduction(n.getRight());
        }
    }

    public void cut(int k) {
        cutInduction(this.root, k - 1);
        if (k <= 0) {
            this.root = null;
        }
    }

    private void cutInduction(BTNode<T> n, int k) {
        if (n == null) {
            return;
        }
        if (k == 0) {
            n.setLeft(null);
            n.setRight(null);
        } else {
            cutInduction(n.getLeft(), k - 1);
            cutInduction(n.getRight(), k - 1);
        }
    }

    public int[] maxLevel() {
        int[] numbers = new int[this.depth() + 1];
        numberOfNodesInALevel(0, this.root, numbers);
        int max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        int b = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == max) {
                b += 1;
            }
        }

        return new int[] { max, b };

    }

    private void numberOfNodesInALevel(int k, BTNode<T> n, int[] dados) {
        if (n == null) {
            return;
        }
        dados[k] += 1;
        numberOfNodesInALevel(k + 1, n.getLeft(), dados);
        numberOfNodesInALevel(k + 1, n.getRight(), dados);
    }

    public int nodesLevel(int k) {
        return nodesLevelInduction(k, root);
    }

    private int nodesLevelInduction(int k, BTNode<T> n) {
        if (k == 0) {
            return 1;
        } else if (n.getRight() == null && n.getLeft() == null) {
            return 0;
        } else if (n.getRight() != null && n.getLeft() == null) {
            return nodesLevelInduction(k - 1, n.getRight());
        } else if (n.getRight() == null && n.getLeft() != null) {

            return nodesLevelInduction(k - 1, n.getLeft());
        } else {
            return nodesLevelInduction(k - 1, n.getLeft()) + nodesLevelInduction(k - 1, n.getRight());
        }

    }

    public T path(String s) {
        if (s.equals("R")) {
            return root.getValue();
        }
        return pathInduction(s, 0, root);
    }

    private T pathInduction(String s, int index, BTNode<T> n) {
        if (index == s.length()) {
            return n.getValue();
        } else if (s.charAt(index) == 'D') {
            return pathInduction(s, index + 1, n.getRight());
        } else {
            return pathInduction(s, index + 1, n.getLeft());
        }

    }

    public boolean strict() {
        return strictInduction(root);
    }

    private boolean strictInduction(BTNode<T> n) {
        if ((n.getLeft() == null && n.getRight() != null) || (n.getLeft() != null && n.getRight() == null)) {
            return false;
        } else if (n.getLeft() != null && n.getRight() != null) {
            return strictInduction(n.getLeft()) && strictInduction(n.getRight());
        } else {
            return true;
        }
    }

    public int numberLeafs() {
        return numberLeafsInduction(root);
    }

    private int numberLeafsInduction(BTNode<T> n) {
        if (n.getLeft() == null && n.getRight() == null) {
            return 1;
        } else if (n.getLeft() == null) {
            return numberLeafsInduction(n.getRight());
        } else if (n.getRight() == null) {
            return numberLeafsInduction(n.getLeft());
        }

        else {
            return numberLeafsInduction(n.getLeft()) + numberLeafsInduction(n.getRight());
        }
    }

    // Getter e Setter para a raiz
    public BTNode<T> getRoot() {
        return root;
    }

    public void setRoot(BTNode<T> r) {
        root = r;
    }

    // Verificar se arvore esta vazia
    public boolean isEmpty() {
        return root == null;
    }

    // --------------------------------------------------------

    // Numero de nos da arvore
    public int numberNodes() {
        return numberNodes(root);
    }

    private int numberNodes(BTNode<T> n) {
        if (n == null)
            return 0;
        return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
    }

    // --------------------------------------------------------

    // Altura da arvore
    public int depth() {
        return depth(root);
    }

    private int depth(BTNode<T> n) {
        if (n == null)
            return -1;
        return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
    }

    // --------------------------------------------------------

    // O elemento value esta contido na arvore?
    public boolean contains(T value) {
        return contains(root, value);
    }

    private boolean contains(BTNode<T> n, T value) {
        if (n == null)
            return false;
        if (n.getValue().equals(value))
            return true;
        return contains(n.getLeft(), value) || contains(n.getRight(), value);
    }

    // --------------------------------------------------------

    // Imprimir arvore em PreOrder
    public void printPreOrder() {
        System.out.print("PreOrder:");
        printPreOrder(root);
        System.out.println();
    }

    private void printPreOrder(BTNode<T> n) {
        if (n == null)
            return;
        System.out.print(" " + n.getValue());
        printPreOrder(n.getLeft());
        printPreOrder(n.getRight());
    }

    // --------------------------------------------------------

    // Imprimir arvore em InOrder
    public void printInOrder() {
        System.out.print("InOrder:");
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(BTNode<T> n) {
        if (n == null)
            return;
        printInOrder(n.getLeft());
        System.out.print(" " + n.getValue());
        printInOrder(n.getRight());
    }

    // --------------------------------------------------------

    // Imprimir arvore em PostOrder
    public void printPostOrder() {
        System.out.print("PostOrder:");
        printPostOrder(root);
        System.out.println();
    }

    private void printPostOrder(BTNode<T> n) {
        if (n == null)
            return;
        printPostOrder(n.getLeft());
        printPostOrder(n.getRight());
        System.out.print(" " + n.getValue());
    }

    // --------------------------------------------------------

    // Imprimir arvore numa visita em largura (usando TAD Fila)
    public void printBFS() {
        System.out.print("BFS:");

        MyQueue<BTNode<T>> q = new LinkedListQueue<BTNode<T>>();
        q.enqueue(root);
        while (!q.isEmpty()) {
            BTNode<T> cur = q.dequeue();
            if (cur != null) {
                System.out.print(" " + cur.getValue());
                q.enqueue(cur.getLeft());
                q.enqueue(cur.getRight());
            }
        }
        System.out.println();
    }

    // --------------------------------------------------------

    // Imprimir arvore numa visita em profundidade (usando TAD Pilha)
    public void printDFS() {
        System.out.print("DFS:");

        MyStack<BTNode<T>> q = new LinkedListStack<BTNode<T>>();
        q.push(root);
        while (!q.isEmpty()) {
            BTNode<T> cur = q.pop();
            if (cur != null) {
                System.out.print(" " + cur.getValue());
                q.push(cur.getLeft());
                q.push(cur.getRight());
            }
        }
        System.out.println();
    }

}