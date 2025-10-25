// -----------------------------------------------------------
// Estruturas de Dados 2025/2026 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2526/
// -----------------------------------------------------------
// Lista ligada simples
// -----------------------------------------------------------

public class SinglyLinkedList<T> {
   private Node<T> first; // Primeiro no da lista
   private int size; // Tamanho da lista

   // Construtor (cria lista vazia)
   SinglyLinkedList() {
      first = null;
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

   // Adiciona v ao inicio da lista
   public void addFirst(T v) {
      Node<T> newNode = new Node<T>(v, first);
      first = newNode;
      size++;
   }

   // Adiciona v ao final da lista
   public void addLast(T v) {
      Node<T> newNode = new Node<T>(v, null);
      if (isEmpty()) {
         first = newNode;
      } else {
         Node<T> cur = first;
         while (cur.getNext() != null)
            cur = cur.getNext();
         cur.setNext(newNode);
      }
      size++;
   }

   // Retorna o primeiro valor da lista (ou null se a lista for vazia)
   public T getFirst() {
      if (isEmpty())
         return null;
      return first.getValue();
   }

   // Retorna o ultimo valor da lista (ou null se a lista for vazia)
   public T getLast() {
      if (isEmpty())
         return null;
      Node<T> cur = first;
      while (cur.getNext() != null)
         cur = cur.getNext();
      return cur.getValue();
   }

   // Remove o primeiro elemento da lista (se for vazia nao faz nada)
   public void removeFirst() {
      if (isEmpty())
         return;
      first = first.getNext();
      size--;
   }

   // Remove o ultimo elemento da lista (se for vazia nao faz nada)
   public void removeLast() {
      if (isEmpty())
         return;
      if (size == 1) {
         first = null;
      } else {
         // Ciclo com for e uso de de size para mostrar alternativa ao while
         Node<T> cur = first;
         for (int i = 0; i < size - 2; i++)
            cur = cur.getNext();
         cur.setNext(cur.getNext().getNext());
      }
      size--;
   }

   // Converte a lista para uma String
   public String toString() {
      String str = "{";
      Node<T> cur = first;
      while (cur != null) {
         str += cur.getValue();
         cur = cur.getNext();
         if (cur != null)
            str += ",";
      }
      str += "}";
      return str;
   }

   // exercício -> adicionar cenas
   public T get(int pos) {
      if (pos < 0) {
         return null;
      }
      Node<T> toReturn = this.first;
      if (this.isEmpty()) {
         return null;
      }

      for (int i = 1; i <= pos; i++) {
         if (toReturn.getNext() != null) {
            toReturn = toReturn.getNext();
         } else {
            return null;
         }
      }

      return toReturn.getValue();

   }

   public T remove(int pos) {
      if (pos < 0) {
         return null;
      }
      if (this.isEmpty()) {
         return null;
      }
      T toOut = null;
      if (pos == 0) {
         toOut = first.getValue();
         this.first = this.first.getNext();
         size--;
         return toOut;
      }

      Node<T> toReturn = this.first;
      for (int i = 1; i < pos; i++) {
         if (toReturn.getNext() != null) {
            toReturn = toReturn.getNext();
         } else {
            return null;
         }
      }
      if (toReturn.getNext() == null) {
         return null;
      } else {
         toOut = toReturn.getNext().getValue();
         toReturn.setNext(toReturn.getNext().getNext());
         size--;
      }

      return toOut;

   }
   // lalal

   public SinglyLinkedList<T> copy() {
      SinglyLinkedList<T> toReturn = new SinglyLinkedList<T>();
      if (isEmpty()) {
         return toReturn;
      }
      Node<T> pointer = first;
      do {

         toReturn.addLast(pointer.getValue());
         pointer = pointer.getNext();
      } while (pointer != null);

      return toReturn;
   }

   public void duplicate() {
      if (first == null) {
         return;
      }
      Node<T> pointer = first;
      do {
         T value = pointer.getValue();
         Node<T> newToAdd = new Node<T>(value, pointer.getNext());
         pointer.setNext(newToAdd);
         pointer = pointer.getNext().getNext();

      } while (pointer != null);
      size *= 2;
   }

   public int count(T value) {
      int counter = 0;
      if (first == null) {
         return counter;
      }
      Node<T> pointer = first;
      do {
         if ((pointer.getValue()).equals(value)) {
            counter += 1;
         }
         pointer = pointer.getNext();
      } while (pointer != null);

      return counter;
   }

   public void removeAll(T value) {
      if (isEmpty()) {
         return;
      }
      if (size == 1) {
         if (this.first.getValue().equals(value)) {
            this.first = null;
            size--;
         }
         return;
      }

      Node<T> pointer = first;
      do {
         if (pointer.getNext().getValue().equals(value)) {
            pointer.setNext(pointer.getNext().getNext());
            size--;
            continue;
         }
         pointer = pointer.getNext();
      } while (pointer.getNext() != null);

      if (first.getValue().equals(value)) {
         first = first.getNext();
         size--;
      }
   }
}
