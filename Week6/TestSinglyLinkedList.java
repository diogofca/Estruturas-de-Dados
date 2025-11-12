// ------------------------------------------------------------------------
// Estruturas de Dados 2025/2026 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2526/
// ------------------------------------------------------------------------
// Exemplo de utilizacao da lista ligada simples 
// ------------------------------------------------------------------------

public class TestSinglyLinkedList {
   public static void main(String[] args) {

      // Criacao de lista de inteiros
      SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

      // Escrevendo lista (no inicio esta vazia)
      System.out.println(list);

      // Verificando se esta vazia
      System.out.println("isEmpty? " + list.isEmpty());

      // Adicionando numeros de 1 a 5 ao final da lista
      for (int i = 1; i <= 5; i++)
         list.addLast(i);
      System.out.println(list);

      // Adicionando numeros de 6 a 10 ao inicio da lista
      for (int i = 6; i <= 10; i++)
         list.addFirst(i);
      System.out.println(list);

      // Verificando o tamanho da lista
      System.out.println("size = " + list.size());

      // Retirando o primeiro elemento
      list.removeFirst();
      System.out.println(list);

      // Retirando o ultimo elemento
      list.removeLast();
      System.out.println(list);

      // Verificando se esta vazia
      System.out.println("isEmpty? " + list.isEmpty());

      // Escreve o primeiro e ultimo elementos
      System.out.println("getFirst() = " + list.getFirst());
      System.out.println("getLast() = " + list.getLast());

      System.out.println("====ED188====");
      SinglyLinkedList<Integer> lala = new SinglyLinkedList<Integer>();
      lala.addFirst(6);
      lala.addFirst(4);
      lala.addFirst(2);
      System.out.println(lala.get(0));
      System.out.println(lala.get(3));

      System.out.println("====ED189====");
      SinglyLinkedList<Integer> lale1 = new SinglyLinkedList<>();
      lale1.addFirst(10);
      lale1.addFirst(8);
      lale1.addFirst(6);
      lale1.addFirst(4);
      lale1.addFirst(2);
      System.out.println(lale1.remove(0) == 2);
      System.out.println(lale1);
      System.out.println(lale1.size());
      // inglyLinkedList<Integer> lale21 = new SinglyLinkedList<>();
      // lale21.addFirst(10);
      // lale21.addFirst(8);
      // lale21.addFirst(6);
      // lale21.addFirst(4);
      // lale21.addFirst(2);
      // System.out.println(lale21.remove(4) == 10);
      // System.out.println(lale21.size());

      // SinglyLinkedList<Integer> lale2 = new SinglyLinkedList<>();
      // lale2.addFirst(10);
      // lale2.addFirst(8);
      // lale2.addFirst(6);
      // lale2.addFirst(4);
      // lale2.addFirst(2);
      // System.out.println(lale2.remove(-2) == null);
      // System.out.println(lale2.size());
   }
}