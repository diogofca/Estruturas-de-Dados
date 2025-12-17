// -----------------------------------------------------------
// Estruturas de Dados 2025/2026 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2526/
// -----------------------------------------------------------
// Exemplo de utilizacao da uma arvore binaria
// -----------------------------------------------------------

import java.util.Scanner;
import java.util.Arrays;

public class TestBTree {
    public static void main(String[] args) {
        // Ler arvore de inteiros em preorder
        Scanner in = new Scanner(System.in);
        BTree<Integer> t = LibBTree.readIntTree(in);

        // Escrever resultado de chamada a alguns metodos
        System.out.println("numberNodes = " + t.numberNodes());
        System.out.println("depth = " + t.depth());
        System.out.println("contains(2) = " + t.contains(2));
        System.out.println("contains(3) = " + t.contains(3));
        // Escrever nos da arvore seguindo varias ordens possiveis
        System.out.println(t.level(5));
        t.printPreOrder();
        t.printInOrder();
        t.printPostOrder();
        t.printBFS();
        t.printDFS();

    }
}