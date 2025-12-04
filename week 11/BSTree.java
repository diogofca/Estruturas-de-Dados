// -----------------------------------------------------------
// Estruturas de Dados 2025/2026 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2526/
// -----------------------------------------------------------
// Arvore binaria de pequisa
// -----------------------------------------------------------

// O tipo T tem de implementar o interface Comparable
// (ou te-lo herdado de uma super classe).
public class BSTree<T extends Comparable<? super T>> {
    private BSTNode1<T> root; // raiz da arvore

    // Construtor
    BSTree() {
        root = null;
    }

    public boolean valid() {
        return valid(this.root);
    }

    private boolean valid(BSTNode1<T> n) {
        if (n == null) {
            return true;
        }
        boolean lala = allAreMore(n.getValue(), n.getRight()) && allAreLess(n.getValue(), n.getLeft());
        return valid(n.getLeft()) && valid(n.getRight()) && lala;
    }

    private boolean allAreLess(T value, BSTNode1<T> n) {
        if (n == null) {
            return true;
        } else {
            return (value.compareTo(n.getValue()) > 0 && allAreLess(value, n.getLeft())
                    && allAreLess(value, n.getRight()));
        }
    }

    private boolean allAreMore(T value, BSTNode1<T> n) {
        if (n == null) {
            return true;
        } else {
            return (n.getValue().compareTo(value) > 0 && allAreMore(value, n.getLeft())
                    && allAreMore(value, n.getRight()));
        }
    }

    public int countBetween(T a, T b) {
        return countBetween(a, b, this.root);
    }

    private int countBetween(T a, T b, BSTNode1<T> n) {
        // isto e um codiigo
        int toReturn = 0;
        if (n == null) {
            return toReturn;
        }
        if (a.compareTo(n.getValue()) <= 0 && b.compareTo(n.getValue()) >= 0) {
            toReturn += 1;
        }
        if (n.getLeft() != null) {
            toReturn += countBetween(a, b, n.getLeft());
        }
        if (n.getRight() != null) {
            toReturn += countBetween(a, b, n.getRight());
        }

        return toReturn;
    }

    public T maxValue() {
        BSTNode1<T> first = this.root;
        while (first.getRight() != null) {
            first = first.getRight();
        }
        return first.getValue();
    }

    public T minValue() {
        BSTNode1<T> first = this.root;
        while (first.getLeft() != null) {
            first = first.getLeft();
        }
        return first.getValue();
    }

    // Getter e Setter para a raiz
    public BSTNode1<T> getRoot() {
        return root;
    }

    public void setRoot(BSTNode1<T> r) {
        root = r;
    }

    // Verificar se arvore esta vazia
    public boolean isEmpty() {
        return root == null;
    }

    // Limpa a arvore (torna-a vazia)
    public void clear() {
        root = null;
    }

    // --------------------------------------------------------
    // Numero de nos da arvore
    public int numberNodes() {
        return numberNodes(root);
    }

    private int numberNodes(BSTNode1<T> n) {
        if (n == null)
            return 0;
        return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
    }

    // --------------------------------------------------------
    // O elemento value esta contido na arvore?
    public boolean contains(T value) {
        return contains(root, value);
    }

    private boolean contains(BSTNode1<T> n, T value) {
        if (n == null)
            return false;
        if (value.compareTo(n.getValue()) < 0) // menor? sub-arvore esquerda
            return contains(n.getLeft(), value);
        if (value.compareTo(n.getValue()) > 0) // maior? sub-arvore direita
            return contains(n.getRight(), value);
        return true; // se nao e menor ou maior, e porque e igual
    }

    // --------------------------------------------------------
    // Adicionar elemento a uma arvore de pesquisa
    // Devolve true se conseguiu inserir, false caso contrario
    public boolean insert(T value) {
        if (contains(value))
            return false;
        root = insert(root, value);
        return true;
    }

    private BSTNode1<T> insert(BSTNode1<T> n, T value) {
        if (n == null)
            return new BSTNode1<T>(value, null, null);
        else if (value.compareTo(n.getValue()) < 0)
            n.setLeft(insert(n.getLeft(), value));
        else if (value.compareTo(n.getValue()) > 0)
            n.setRight(insert(n.getRight(), value));
        return n;
    }

    // --------------------------------------------------------
    // Remover elemento de uma arvore de pesquisa
    // Devolve true se conseguiu remover, false caso contrario
    public boolean remove(T value) {
        if (!contains(value))
            return false;
        root = remove(root, value);
        return true;
    }

    // Assume-se que elemento existe (foi verificado antes)
    private BSTNode1<T> remove(BSTNode1<T> n, T value) {
        if (value.compareTo(n.getValue()) < 0)
            n.setLeft(remove(n.getLeft(), value));
        else if (value.compareTo(n.getValue()) > 0)
            n.setRight(remove(n.getRight(), value));
        else if (n.getLeft() == null) // Nao tem filho esquerdo
            n = n.getRight();
        else if (n.getRight() == null) // Nao tem filho direito
            n = n.getLeft();
        else { // Dois fihos: ir buscar maximo do lado esquerdo
            BSTNode1<T> max = n.getLeft();
            while (max.getRight() != null)
                max = max.getRight();
            n.setValue(max.getValue()); // Substituir valor removido
            // Apagar valor que foi para lugar do removido
            n.setLeft(remove(n.getLeft(), max.getValue()));
        }
        return n;
    }

    // --------------------------------------------------------
    // Altura da arvore
    public int depth() {
        return depth(root);
    }

    private int depth(BSTNode1<T> n) {
        if (n == null)
            return -1;
        return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
    }

    // --------------------------------------------------------

    // Imprimir arvore em PreOrder
    public void printPreOrder() {
        System.out.print("PreOrder:");
        printPreOrder(root);
        System.out.println();
    }

    private void printPreOrder(BSTNode1<T> n) {
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

    private void printInOrder(BSTNode1<T> n) {
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

    private void printPostOrder(BSTNode1<T> n) {
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

        MyQueue<BSTNode1<T>> q = new LinkedListQueue<BSTNode1<T>>();
        q.enqueue(root);
        while (!q.isEmpty()) {
            BSTNode1<T> cur = q.dequeue();
            if (cur != null) {
                System.out.print(" " + cur.getValue());
                q.enqueue(cur.getLeft());
                q.enqueue(cur.getRight());
            }
        }
        System.out.println();
    }

    // --------------------------------------------------------

    // Imprimir arvore numa visita em largura (usando TAD Pilha)
    public void printDFS() {
        System.out.print("DFS:");

        MyStack<BSTNode1<T>> q = new LinkedListStack<BSTNode1<T>>();
        q.push(root);
        while (!q.isEmpty()) {
            BSTNode1<T> cur = q.pop();
            if (cur != null) {
                System.out.print(" " + cur.getValue());
                q.push(cur.getLeft());
                q.push(cur.getRight());
            }
        }
        System.out.println();
    }

}