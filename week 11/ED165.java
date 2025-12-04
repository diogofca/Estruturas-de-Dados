// -----------------------------------------------------------
// Estruturas de Dados 2025/2026 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2526/
// -----------------------------------------------------------
// Arvore binaria de pequisa - versao dicionario
// -----------------------------------------------------------

import java.util.LinkedList;
// -----------------------------------------------------------
// Estruturas de Dados 2025/2026 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2526/
// -----------------------------------------------------------
// No de uma arvore binaria de pesquisa
// -----------------------------------------------------------
import java.util.Scanner;

class BSTMapNode<K extends Comparable<? super K>, V> {
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

// O tipo T tem de implementar o interface Comparable
// (ou te-lo herdado de uma super classe).
class BSTNode1<T extends Comparable<? super T>> {
    private T value; // Valor guardado no no
    private BSTNode<T> left; // Filho esquerdo
    private BSTNode<T> right; // Filho direito

    // Construtor
    BSTNode1(T v, BSTNode<T> l, BSTNode<T> r) {
        value = v;
        left = l;
        right = r;
    }

    // Getters e Setters
    public T getValue() {
        return value;
    }

    public BSTNode<T> getLeft() {
        return left;
    }

    public BSTNode<T> getRight() {
        return right;
    }

    public void setValue(T v) {
        value = v;
    }

    public void setLeft(BSTNode<T> l) {
        left = l;
    }

    public void setRight(BSTNode<T> r) {
        right = r;
    }
}

// K e o tipo da chave (key) e V o tipo do valor (value)
// O tipo K tem de implementar o interface Comparable
// (ou te-lo herdado de uma super classe).
class BSTMap1<K extends Comparable<? super K>, V> {
    private BSTMapNode<K, V> root; // raiz da arvore

    // Construtor
    BSTMap1() {
        root = null;
    }

    // Getter e Setter para a raiz
    public BSTMapNode<K, V> getRoot() {
        return root;
    }

    public void setRoot(BSTMapNode<K, V> r) {
        root = r;
    }

    // Verificar se o dicionario esta vazio
    public boolean isEmpty() {
        return root == null;
    }

    // Limpa o dicionario (torna-o vazia)
    public void clear() {
        root = null;
    }

    // --------------------------------------------------------
    // Tamanho do dicionario (numero de chaves guardadas)
    public int size() {
        return size(root);
    }

    private int size(BSTMapNode<K, V> n) {
        if (n == null)
            return 0;
        return 1 + size(n.getLeft()) + size(n.getRight());
    }

    // --------------------------------------------------------
    // Devolver o valor associado a uma chave (ou null caso nao exista)
    public V get(K key) {
        return get(root, key);
    }

    private V get(BSTMapNode<K, V> n, K key) {
        if (n == null)
            return null;
        if (key.compareTo(n.getKey()) < 0)
            return get(n.getLeft(), key);
        if (key.compareTo(n.getKey()) > 0)
            return get(n.getRight(), key);
        return n.getValue(); // se nao e menor ou maior, e porque e igual
    }

    // --------------------------------------------------------
    // Adicionar par (chave,valor) ao dicionario
    // Se chave ja existir, substitui o valor antigo pelo novo
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private BSTMapNode<K, V> put(BSTMapNode<K, V> n, K key, V value) {
        if (n == null)
            return new BSTMapNode<K, V>(key, value, null, null);
        else if (key.compareTo(n.getKey()) < 0)
            n.setLeft(put(n.getLeft(), key, value));
        else if (key.compareTo(n.getKey()) > 0)
            n.setRight(put(n.getRight(), key, value));
        else
            n.setValue(value);
        return n;
    }

    // --------------------------------------------------------
    // Remover uma chave do dicionario
    // Devolve true se conseguiu remover, false caso contrario
    public boolean remove(K key) {
        if (get(key) == null)
            return false;
        root = remove(root, key);
        return true;
    }

    // Assume-se que elemento existe (foi verificado antes)
    private BSTMapNode<K, V> remove(BSTMapNode<K, V> n, K key) {
        if (key.compareTo(n.getKey()) < 0)
            n.setLeft(remove(n.getLeft(), key));
        else if (key.compareTo(n.getKey()) > 0)
            n.setRight(remove(n.getRight(), key));
        else if (n.getLeft() == null) // Nao tem filho esquerdo
            n = n.getRight();
        else if (n.getRight() == null) // Nao tem filho direito
            n = n.getLeft();
        else { // Dois fihos: ir buscar maximo do lado esquerdo
            BSTMapNode<K, V> max = n.getLeft();
            while (max.getRight() != null)
                max = max.getRight();
            n.setKey(max.getKey()); // Substituir chave removida
            n.setValue(max.getValue()); // Substituir valor removido
            // Apagar valor que foi para lugar do removido
            n.setLeft(remove(n.getLeft(), max.getKey()));
        }
        return n;
    }

    // --------------------------------------------------------
    // Devolver lista ligada das chaves (usando listas do Java)
    public LinkedList<K> keys() {
        LinkedList<K> list = new LinkedList<K>();
        keys(root, list);
        return list;
    }

    private void keys(BSTMapNode<K, V> n, LinkedList<K> l) {
        if (n == null)
            return;
        keys(n.getLeft(), l);
        l.addLast(n.getKey());
        keys(n.getRight(), l);
    }

}

public class ED165 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }
        int P = sc.nextInt();
        BSTMap1<Integer, String> set = new BSTMap1<Integer, String>();
        Integer[] values = new Integer[P];
        for (int i = 0; i < P; i++) {
            Integer lala = sc.nextInt();
            set.put(lala, "nao");
            values[i] = lala;
        }
        sc.close();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int numero = numbers[i] + numbers[j];
                if (set.get(numero) != null) {
                    set.remove(numero);
                    set.put(numero, "sim");
                }
            }
        }

        for (int i : values) {
            System.out.println(String.format("%d: %s", i, set.get(i)));
        }
    }
}
