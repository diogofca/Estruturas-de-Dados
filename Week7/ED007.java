import java.util.Scanner;
// -----------------------------------------------------------
// Estruturas de Dados (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2526/
// -----------------------------------------------------------
// Implementacao do TAD Pilha usando lista duplamente ligada
// -----------------------------------------------------------
// -----------------------------------------------------------
// Estruturas de Dados (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2526/
// -----------------------------------------------------------
// Lista duplamente ligada 
// (implementada com sentinelas - nos "dummy" no inicio e no fim
//  que facilitam a implementacao e evitam casos excepcionais)
// -----------------------------------------------------------

class DoublyLinkedList2<T> {
    private DNode<T> first; // Primeiro no da lista
    private DNode<T> last; // Ultimo no da lista
    private int size; // Tamanho da lista

    // Construtor (cria lista vazia com dois nos sentinelas)
    DoublyLinkedList2() {
        first = new DNode<T>(null, null, null);
        last = new DNode<T>(null, first, null); // Antes do ultimo vem o primeiro
        first.setNext(last); // A seguir ao primeiro vem o ultimo
        size = 0;
    }

    // Retorna o tamanho da lista
    public int size() {
        return size;
    }

    // Devolve true se a lista estiver vazia ou falso caso contrario
    public boolean isEmpty() {
        return (size == 0);
    }

    // Retorna o primeiro valor da lista (ou null se a lista for vazia)
    public T getFirst() {
        if (isEmpty())
            return null;
        return first.getNext().getValue();
    }

    // Retorna o ultimo valor da lista (ou null se a lista for vazia)
    public T getLast() {
        if (isEmpty())
            return null;
        return last.getPrev().getValue();
    }

    // Adiciona v ao inicio da lista
    public void addFirst(T v) {
        addBetween(v, first, first.getNext());
    }

    // Adiciona v ao final da lista
    public void addLast(T v) {
        addBetween(v, last.getPrev(), last);
    }

    // Adiciona elemento entre dois nos n1 e n2
    private void addBetween(T v, DNode<T> n1, DNode<T> n2) {
        DNode<T> newNode = new DNode<T>(v, n1, n2);
        n1.setNext(newNode);
        n2.setPrev(newNode);
        size++;
    }

    // Remove o primeiro elemento da lista (se for vazia nao faz nada)
    public void removeFirst() {
        if (isEmpty())
            return;
        remove(first.getNext());
    }

    // Remove o ultimo elemento da lista (se for vazia nao faz nada)
    public void removeLast() {
        if (isEmpty())
            return;
        remove(last.getPrev());
    }

    // Remove um no da lista
    private void remove(DNode<T> n) {
        DNode<T> prev = n.getPrev();
        DNode<T> next = n.getNext();
        prev.setNext(next);
        next.setPrev(prev);
        size--;
    }

    // Converte a lista para uma String
    public String toString() {
        String str = "{";
        DNode<T> cur = first.getNext();
        for (int i = 0; i < size; i++) {
            str += cur.getValue();
            cur = cur.getNext();
            if (cur != last)
                str += ",";
        }
        str += "}";
        return str;
    }
}

class LinkedListStack2<T> implements MyStack2<T> {
    private DoublyLinkedList2<T> list;

    LinkedListStack2() {
        list = new DoublyLinkedList2<T>();
    }

    public void push(T v) {
        list.addFirst(v);
    }

    public T pop() {
        T ans = list.getFirst();
        list.removeFirst();
        return ans;
    }

    public T top() {
        return list.getFirst();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public String toString() {
        return list.toString();
    }
}

interface MyStack2<T> {
    // Metodos que modificam a pilha
    public void push(T v); // Coloca um valor no topo da pilha

    public T pop(); // Retira e retorna o valor no topo da pilha

    // Metodos que acedem a informacao (sem modificar)
    public T top(); // Retorna valor no topo da pilha

    public int size(); // Retorna quantidade de elementos na pilha

    public boolean isEmpty();
}

public class ED007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String expression = sc.nextLine();
            deal(expression.toCharArray());

        }
        sc.close();
    }

    public static void deal(char[] expressionArray) {
        MyStack2<Character> stack = new LinkedListStack2<Character>();
        for (int i = 0; i < expressionArray.length; i++) {
            char j = expressionArray[i];
            if (j == '(' || j == '[') {
                stack.push(j);
            } else if (j == ')') {
                Character poped = stack.pop();
                if (poped == null) {

                    System.out.println(String.format("Erro na posicao %d", i));
                    return;
                }
                if (poped != '(') {
                    System.out.println(String.format("Erro na posicao %d", i));
                    return;
                }
            } else if (j == ']') {
                Character poped = stack.pop();
                if (poped == null) {

                    System.out.println(String.format("Erro na posicao %d", i));
                    return;
                }
                if (poped != '[') {
                    System.out.println(String.format("Erro na posicao %d", i));
                    return;
                }
            }
        }
        if (stack.size() != 0) {
            System.out.println("Ficam parenteses por fechar");
        } else {
            System.out.println("Expressao bem formada");
        }

        // lala tu es o maior

    }
}