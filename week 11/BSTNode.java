// -----------------------------------------------------------
// Estruturas de Dados 2025/2026 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2526/
// -----------------------------------------------------------
// No de uma arvore binaria de pesquisa
// -----------------------------------------------------------

// O tipo T tem de implementar o interface Comparable
// (ou te-lo herdado de uma super classe).
public class BSTNode<T extends Comparable<? super T>> {
    private T value; // Valor guardado no no
    private BSTNode1<T> left; // Filho esquerdo
    private BSTNode1<T> right; // Filho direito

    // Construtor
    BSTNode(T v, BSTNode1<T> l, BSTNode1<T> r) {
        value = v;
        left = l;
        right = r;
    }

    // Getters e Setters
    public T getValue() {
        return value;
    }

    public BSTNode1<T> getLeft() {
        return left;
    }

    public BSTNode1<T> getRight() {
        return right;
    }

    public void setValue(T v) {
        value = v;
    }

    public void setLeft(BSTNode1<T> l) {
        left = l;
    }

    public void setRight(BSTNode1<T> r) {
        right = r;
    }
}