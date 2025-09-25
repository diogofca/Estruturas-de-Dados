import java.util.Scanner;
import java.util.Arrays;

public class Pizza {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String IngredientesNao = sc.nextLine();
        String[] primeiroInput = IngredientesNao.split(" ");
        int n = Integer.parseInt(primeiroInput[0]);
        int[] ingredientesNaoNumeros = new int[n];
        for (int i = 0; i < n; i++) {
            ingredientesNaoNumeros[i] = Integer.parseInt(primeiroInput[i + 1]);
        }
        // System.out.println("I am here");
        ;
        int p = sc.nextInt();
        System.out.printf("");
        // System.out.println(p);
        int osqueda = 0;
        sc.nextLine();
        for (int i = 0; i < p; i++) {
            String ingredientes = sc.nextLine();
            String[] ingredientes_divididos = ingredientes.split(" ");
            String[] ingredientes_divididos2 = Arrays.copyOfRange(ingredientes_divididos, 1,
                    ingredientes_divididos.length);
            // System.out.println(ingredientes);
            // System.out.println(ingredientes_divididos[0]);
            if (ingredientesdividiosfuncao(ingredientes_divididos2, ingredientesNaoNumeros)) {
                // System.out.println("aqui");
                continue;
            }
            osqueda += 1;

        }

        System.out.println(osqueda);
        sc.close();

    }

    static boolean oquelavai(int numero_ingrediente, int[] ingredientesNaoNumeros) {

        for (int j = 0; j < ingredientesNaoNumeros.length; j++) {
            if (numero_ingrediente == ingredientesNaoNumeros[j]) {
                return true;
            }
        }
        return false;
    }

    static boolean ingredientesdividiosfuncao(String[] ingredientes_divididos, int[] ingredientesNaoNumeros) {
        for (String ingrediente : ingredientes_divididos) {
            int numero_ingrediente = Integer.parseInt(ingrediente);
            for (int j = 0; j < ingredientesNaoNumeros.length; j++) {
                // System.out.println(numero_ingrediente);
                // System.out.println(ingredientesNaoNumeros[j]);
                if (numero_ingrediente == ingredientesNaoNumeros[j]) {
                    return true;
                }
            }
        }
        return false;
    }

}
