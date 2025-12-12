import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

public class ED301 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int flag = sc.nextInt();
        int equipas = sc.nextInt();
        String[] cores = { "Vermelho", "Laranja", "Amarelo", "Verde", "Azul" };
        Comparator<Person> c = (a, b) -> {
            if (a.priority == b.priority) {
                return Integer.compare(a.t_chegada, b.t_chegada);
            }
            return Integer.compare(a.priority, b.priority);
        };
        PriorityQueue<Person> fila = new PriorityQueue<Person>(c);
        int[] contagem = new int[5];
        while (sc.hasNext()) {
            String name = sc.next();
            String priority = sc.next();
            int p = 0;
            if (priority.equals("Vermelho")) {
                p = 1;
                contagem[0] += 1;
            } else if (priority.equals("Laranja")) {
                p = 2;
                contagem[1] += 1;
            } else if (priority.equals("Amarelo")) {
                p = 3;
                contagem[2] += 1;
            } else if (priority.equals("Verde")) {
                p = 4;
                contagem[3] += 1;
            } else if (priority.equals("Azul")) {
                p = 5;
                contagem[4] += 1;
            }
            fila.add(new Person(name, p, sc.nextInt(), sc.nextInt()));
            // System.out.println(Arrays.toString(fila.toArray()));
        }

        if (flag == 0) {
            int maior = 0;
            for (int i = 0; i < contagem.length; i++) {
                if (maior < contagem[i]) {
                    maior = contagem[i];
                }
            }
            for (int i = 0; i < contagem.length; i++) {
                if (contagem[i] == maior) {
                    System.out.println(String.format("%s %d", cores[i], contagem[i]));
                }
            }
        }

        if (flag == 1) {
            int time = 0;
            System.out.println("---------------------------");
            System.out.println("Lista dos doentes atendidos");
            System.out.println("---------------------------");
            int[] temposdeespera = new int[fila.size()];
            int i = 0;
            while (!fila.isEmpty()) {
                Person atendido = fila.poll();
                int tempodeespera = time - atendido.t_chegada;
                temposdeespera[i] = tempodeespera;
                i++;
                time += atendido.t_attend;
                System.out
                        .println(String.format("%s %d %d %d", atendido.name, atendido.t_chegada, tempodeespera, time));
            }
            double average = 0.0;
            for (int j = 0; j < temposdeespera.length; j++) {
                average += temposdeespera[j];
            }
            average = (double) average / temposdeespera.length;
            System.out.println("---------------------------");
            System.out.println(String.format("Tempo medio de espera: %.1f", Math.round(average * 10) / 10.0));
        }
        sc.close();

    }
}

class Person {
    String name;
    int priority;
    // 1 -> red
    // 2-> orange
    // 3 -> yellow
    // 4 -> green
    // 5-> blue
    int t_chegada;
    int t_attend;

    Person(String name, int priority, int t_chegada, int t_attend) {
        this.name = name;
        this.priority = priority;
        this.t_chegada = t_chegada;
        this.t_attend = t_attend;
    }

}