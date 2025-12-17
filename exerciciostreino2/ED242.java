import java.util.Scanner;
import java.util.Arrays;

import java.util.LinkedList;

// K e o tipo da chave (key) e V o tipo do valor (value)
// O tipo K tem de implementar o interface Comparable
// (ou te-lo herdado de uma super classe).
class BSTMap<K extends Comparable<? super K>, V> {
    private BSTMapNode<K, V> root; // raiz da arvore

    // Construtor
    BSTMap() {
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

class BSTree<T extends Comparable<? super T>> {
    private BSTNode<T> root; // raiz da arvore

    // Construtor
    BSTree() {
        root = null;
    }

    // Getter e Setter para a raiz
    public BSTNode<T> getRoot() {
        return root;
    }

    public void setRoot(BSTNode<T> r) {
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

    private int numberNodes(BSTNode<T> n) {
        if (n == null)
            return 0;
        return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
    }

    // --------------------------------------------------------
    // O elemento value esta contido na arvore?
    public boolean contains(T value) {
        return contains(root, value);
    }

    private boolean contains(BSTNode<T> n, T value) {
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

    private BSTNode<T> insert(BSTNode<T> n, T value) {
        if (n == null)
            return new BSTNode<T>(value, null, null);
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
    private BSTNode<T> remove(BSTNode<T> n, T value) {
        if (value.compareTo(n.getValue()) < 0)
            n.setLeft(remove(n.getLeft(), value));
        else if (value.compareTo(n.getValue()) > 0)
            n.setRight(remove(n.getRight(), value));
        else if (n.getLeft() == null) // Nao tem filho esquerdo
            n = n.getRight();
        else if (n.getRight() == null) // Nao tem filho direito
            n = n.getLeft();
        else { // Dois fihos: ir buscar maximo do lado esquerdo
            BSTNode<T> max = n.getLeft();
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

    private int depth(BSTNode<T> n) {
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

    private void printPreOrder(BSTNode<T> n) {
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

    private void printInOrder(BSTNode<T> n) {
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

    private void printPostOrder(BSTNode<T> n) {
        if (n == null)
            return;
        printPostOrder(n.getLeft());
        printPostOrder(n.getRight());
        System.out.print(" " + n.getValue());
    }

    // --------------------------------------------------------

    // Imprimir arvore numa visita em largura (usando TAD Fila)

}

class BSTNode<T extends Comparable<? super T>> {
    private T value; // Valor guardado no no
    private BSTNode<T> left; // Filho esquerdo
    private BSTNode<T> right; // Filho direito

    // Construtor
    BSTNode(T v, BSTNode<T> l, BSTNode<T> r) {
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

public class ED242 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        sc.nextLine();
        BSTMap<Integer, String> board = new BSTMap<Integer, String>();
        int i = 0;
        while (sc.hasNextLine()) {
            board.put(i, sc.nextLine());
            i++;
        }
        sc.close();
        int C = board.get(0).length();
        int L = board.size();
        char[][] boardarray = new char[L][C];
        for (int j = 0; j < L; j++) {
            boardarray[j] = board.get(j).toCharArray();
        }
        // System.out.println(Arrays.deepToString(boardarray));
        int[][] visited = new int[L][C];
        // System.out.println(countLake(2, 2, visited, boardarray));
        int[] numeros = new int[L * C];
        int k = 0;
        for (int g = 0; g < L; g++) {
            countLake(g, 0, visited, boardarray);
            countLake(g, C - 1, visited, boardarray);
        }
        for (int j = 0; j < L; j++) {
            countLake(L - 1, j, visited, boardarray);
            countLake(0, j, visited, boardarray);
        }
        for (int g = 0; g < L; g++) {
            for (int j = 0; j < C; j++) {
                if (visited[g][j] == 0) {
                    int contar = countLake(g, j, visited, boardarray);
                    if (contar != 0) {
                        numeros[k] = contar;
                        k++;
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(numeros));

        // contar o numero de nao zeros
        int naozeros = 0;
        for (int j = 0; j < numeros.length; j++) {
            if (numeros[j] != 0) {
                naozeros += 1;
            }
        }
        if (naozeros == 0) {
            System.out.println(0);
        }
        // System.out.println(naozeros);
        int[] numeros2 = new int[naozeros];
        for (int j = 0; j < naozeros; j++) {
            numeros2[j] = numeros[j];
        }
        Arrays.sort(numeros2);
        // System.out.println(Arrays.toString(numeros2));
        int lala = 0;
        for (int j = 0; j < naozeros - K; j++) {
            lala += numeros2[j];
        }
        System.out.println(lala);
    }

    public static int countLake(int i, int j, int[][] visited, char[][] board) {
        int L = visited.length;
        int C = visited[0].length;
        if (i < 0 || i >= L || j < 0 || j >= C) {
            return 0;
        }
        if (visited[i][j] == 1) {
            return 0;
        } else {
            visited[i][j] = 1;
            if (board[i][j] == '.') { // é água
                return 1 + countLake(i + 1, j, visited, board) + countLake(i - 1, j, visited, board)
                        + countLake(i, j + 1, visited, board) + countLake(i, j - 1, visited, board);

            } else {

                return 0;
            }
        }
    }
}
