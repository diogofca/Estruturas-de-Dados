// -----------------------------------------------------------
// Estruturas de Dados 2025/2026 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2526/
// -----------------------------------------------------------
// No de uma arvore binaria de pesquisa - versao dicionario
// -----------------------------------------------------------

// K e o tipo da chave (key) e V o tipo do valor (value)
// O tipo K tem de implementar o interface Comparable
// (ou te-lo herdado de uma super classe).
public class BSTMapNode<K extends Comparable<? super K>, V> {
    private K key; // chave
    private V value; // valor
    private BSTMapNode<K, V> left; // Filho esquerdo
    private BSTMapNode<K, V> right; // Filho direito

    // Construtor
    BSTMapNode(K k, V v, BSTMapNode<K, V> l, BSTMapNode<K, V> r) {
        key = k;
        value = v;
        left = l;
        right = r;
    }

    // Getters e Setters
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public BSTMapNode<K, V> getLeft() {
        return left;
    }

    public BSTMapNode<K, V> getRight() {
        return right;
    }

    public void setKey(K k) {
        key = k;
    }

    public void setValue(V v) {
        value = v;
    }

    public void setLeft(BSTMapNode<K, V> l) {
        left = l;
    }

    public void setRight(BSTMapNode<K, V> r) {
        right = r;
    }
}