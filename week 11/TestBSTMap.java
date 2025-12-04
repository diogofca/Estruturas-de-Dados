// -----------------------------------------------------------
// Estruturas de Dados 2025/2026 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2526/
// -----------------------------------------------------------
// Exemplo de utilizacao da um dicionario
// -----------------------------------------------------------

import java.util.LinkedList;

public class TestBSTMap {

    public static void main(String[] args) {

        // Criacao de um dicionario
        BSTMap1<String, Integer> map = new BSTMap1<String, Integer>();

        // Inserindo alguns pares (chave,valor)
        map.put("Life", 42);
        map.put("Zero", 0);
        map.put("Infinity", 999);

        // Tamanho e conteudo
        System.out.println("size = " + map.size());
        System.out.println("Value of \"Life\" = " + map.get("Life"));
        System.out.println("Value of \"Data\" = " + map.get("Data"));

        // Imprimindo todas chaves
        LinkedList<String> keys = map.keys();
        System.out.println("keys = " + keys);

        // Percorrendo todas as chaves para imprimir os pares (chave,valor)
        System.out.println("All (key,value) pairs:");
        for (String k : map.keys())
            System.out.println("- (" + k + "," + map.get(k) + ")");

        // Modificando um valor
        map.put("Life", 22);
        System.out.println("Value of \"Life\" = " + map.get("Life"));

        // Apagando um valor
        map.remove("Life");
        System.out.println("Value of \"Life\" = " + map.get("Life"));
    }
}