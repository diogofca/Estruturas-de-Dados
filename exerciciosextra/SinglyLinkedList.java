// -----------------------------------------------------------
// Estruturas de Dados 2025/2026 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Classe com um no generico
// Ultima alteracao: 03/04/2018
// -----------------------------------------------------------

// -----------------------------------------------------------
// Estruturas de Dados 2025/2026 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Lista ligada simples
// Ultima alteracao: 03/04/2018
// -----------------------------------------------------------

import java.time.format.SignStyle;

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

   public void duplicate(int pos) {
      Node<T> myFirst = this.first;
      int i = 0;
      while (i < pos) {
         myFirst = myFirst.getNext();
         i++;
      }
      T toduplicate = myFirst.getValue();
      Node<T> last = myFirst.getNext();
      myFirst.setNext(new Node<T>(toduplicate, last));
      size += 1;
   }

   public SinglyLinkedList<T> remove(int[] pos) {
      SinglyLinkedList<T> toReturn = new SinglyLinkedList<>();

      if (this.isEmpty()) {
         return toReturn;
      }
      if (pos.length == 0) {
         Node<T> myFirst = this.first;
         while (myFirst != null) {
            toReturn.addLast(myFirst.getValue());
            myFirst = myFirst.getNext();
         }
         return toReturn;
      }
      int indexInPos = 0;
      int lala = 1;
      int index = 0;
      Node<T> myFirst = this.first;
      while (myFirst != null) {
         if (lala == 1 && index == pos[indexInPos]) {
            indexInPos += 1;
            if (indexInPos >= pos.length) {
               lala = 0;
            }
         } else {
            toReturn.addFirst(myFirst.getValue());
         }

         // last part
         index += 1;
         myFirst = myFirst.getNext();
      }

      // eu sou o maior

      return toReturn.reverse();
   }

   public SinglyLinkedList<T> cut(int a, int b) {
      SinglyLinkedList<T> toReturn = new SinglyLinkedList<>();
      if (this.isEmpty()) {
         return toReturn;
      }
      Node<T> first = this.first;
      for (int j = 0; j < a; j++) {
         first = first.getNext();
      }
      for (int j = a; j <= b; j++) {
         toReturn.addLast(first.getValue());
         first = first.getNext();
      }

      return toReturn;
   }

   public void shift(int k) {
      if (this.isEmpty()) {
         return;
      }
      if (k == 0 || k == size()) {
         return;
      }

      // size() -k
      Node<T> firstfirst = this.first;
      Node<T> lastlast = this.first;
      for (int i = 1; i <= size() - 1; i++) {
         lastlast = lastlast.getNext();
      }

      lastlast.setNext(firstfirst);
      Node<T> toCut = this.first;
      for (int i = 1; i <= size() - k - 1; i++) {
         toCut = toCut.getNext();
      }
      Node<T> temp = toCut.getNext();
      this.first = temp;
      toCut.setNext(null);

   }

   public SinglyLinkedList<T> reverse() {
      SinglyLinkedList<T> toReturn = new SinglyLinkedList<T>();
      if (this.isEmpty()) {
         return toReturn;
      }
      Node<T> first = this.first;
      do {
         toReturn.addFirst(first.getValue());
         first = first.getNext();
      } while (first != null);

      return toReturn;
   }

   public int[] occurrences(T elem) {
      if (this.isEmpty()) {
         return null;
      }
      Node<T> first = this.first;
      SinglyLinkedList<Integer> counter = new SinglyLinkedList<Integer>();
      int i = 0;
      do {
         if (first.getValue().equals(elem)) {
            counter.addLast(i);
         }
         first = first.getNext();
         i++;
      } while (first != null);
      if (counter.isEmpty()) {
         return null;
      }
      int[] toReturn = new int[counter.size()];
      for (int j = 0; j < toReturn.length; j++) {
         toReturn[j] = counter.getFirst();
         counter.removeFirst();
      }
      return toReturn;
   }

   public void remove(SinglyLinkedList<T> toRemove) {
      int N = toRemove.size();

      for (int i = 0; i < N; i++) {
         T remove = toRemove.getFirst();
         toRemove.removeFirst();

         if (this.size() == 0) {
            return;
         } else if (this.size() == 1) {
            if (this.getFirst().equals(remove)) {
               this.removeFirst();

            }
            return;
         }
         // lala

         Node<T> first = this.first;
         do {
            if (first.getNext().getValue().equals(remove)) {
               first.setNext(first.getNext().getNext());
               this.size--;
            } else {
               first = first.getNext();
            }
            // lala
         } while (first.getNext() != null);

         if (this.getFirst().equals(remove)) {
            this.removeFirst();
         }

      }
   }
}