// -----------------------------------------------------------
// Estruturas de Dados 2025/2026 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2526/
// -----------------------------------------------------------
// Exemplo de utilizacao da uma arvore binaria de pesquisa
// -----------------------------------------------------------

class TestBSTree {
    public static void main(String[] args) {

        // Criacao da Arvore
        BSTree<Integer> t = new BSTree<Integer>();

        // Inserindo 11 elementos na arvore binaria de pesquisa
        int[] data = { 6, 3, 10, 1, 4, 8, 42, 2, 7, 23, 54 };
        for (int i = 0; i < data.length; i++)
            t.insert(data[i]);

        // Escrever resultado de chamada a alguns metodos
        System.out.println("numberNodes = " + t.numberNodes());
        System.out.println("depth = " + t.depth());
        System.out.println("contains(2) = " + t.contains(2));
        System.out.println("contains(3) = " + t.contains(3));
        System.out.println(t.countBetween(5, 44));
        System.out.println(t.countBetween(7, 10));

        // Escrever nos da arvore seguindo varias ordens possiveis
        // t.printPreOrder();
        // t.printInOrder();
        // t.printPostOrder();

        // Experimentando remocao
        // t.remove(14);
        // t.printPreOrder();
        // t.printInOrder();
        // t.printPostOrder();
    }
}