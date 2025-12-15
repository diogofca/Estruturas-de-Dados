import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Queue;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class ED301 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int flag = sc.nextInt();
        int equipas = sc.nextInt();
        String[] cores = { "Vermelho", "Laranja", "Amarelo", "Verde", "Azul" };
        Comparator<Person> c = (a, b) -> {
            if (a.t_chegada == b.t_chegada) {
                return Integer.compare(a.t_chegada, b.t_chegada);
            }
            return Integer.compare(a.t_chegada, b.t_chegada);
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
        // this is my try
        if (flag == 1) {
            int time = 0;
            System.out.println("---------------------------");
            System.out.println("Lista dos doentes atendidos");
            System.out.println("---------------------------");
            int[] temposdeespera = new int[fila.size()];
            Comparator<Person> d = (a, b) -> {
                if (a.priority == b.priority) {
                    return Integer.compare(a.t_chegada, b.t_chegada);
                }
                return Integer.compare(a.priority, b.priority);
            };
            PriorityQueue<Person> chegados = new PriorityQueue<Person>(d);
            while (!fila.isEmpty()) {
                chegados.add(fila.poll());
            }
            int i = 0;
            while (!chegados.isEmpty()) {
                PriorityQueue<Person> aindanaoeoteutempo = new PriorityQueue<Person>(d);

                Person atendido;
                while (!chegados.isEmpty() && chegados.peek().t_chegada > time) {
                    aindanaoeoteutempo.add(chegados.poll());
                }
                if (chegados.isEmpty()) {
                    time += 1;
                    while (!aindanaoeoteutempo.isEmpty()) {
                        chegados.add(aindanaoeoteutempo.poll());
                    }
                    continue;
                }
                atendido = chegados.poll();
                while (!aindanaoeoteutempo.isEmpty()) {
                    chegados.add(aindanaoeoteutempo.poll());
                }

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

        if (flag == 2) {
            int time = 0;
            Comparator<Person> d = (a, b) -> {
                if (a.priority == b.priority) {
                    return Integer.compare(a.t_chegada, b.t_chegada);
                }
                return Integer.compare(a.priority, b.priority);
            };
            PriorityQueue<Person> chegados = new PriorityQueue<>(d);
            int[] tempo_atendimento = new int[equipas];
            int[] ocupado_ate = new int[equipas];
            int tempodeespera = 0;
            int totalPacientes = fila.size();
            int[] numerodoentes = new int[equipas];
            boolean[] ocupados = new boolean[equipas];
            for (int i = 0; i < equipas; i++) {
                ocupados[i] = false;
            }

            while (true) {

                // os coisos chegaram
                while (true) {
                    if (fila.isEmpty()) {
                        break;
                    }
                    if (fila.peek().t_chegada == time) {
                        chegados.add(fila.poll());
                    } else {
                        break;
                    }
                }

                // equipas libertaram-se
                for (int i = 0; i < equipas; i++) {
                    if (time == ocupado_ate[i]) {
                        ocupados[i] = false;
                    }
                }

                for (int i = 0; i < equipas; i++) {
                    if (!chegados.isEmpty() && ocupados[i] == false) {
                        Person doente = chegados.poll();
                        ocupados[i] = true;
                        ocupado_ate[i] = time + doente.t_attend;
                        tempodeespera += time - doente.t_chegada;
                        tempo_atendimento[i] += doente.t_attend;
                        // System.out.println(doente.t_attend);
                        numerodoentes[i] += 1;
                    }
                }

                time += 1;

                // esta parte é para parar
                boolean todasEstaoLivres = true;
                for (int i = 0; i < equipas; i++) {
                    if (ocupados[i] == true) {
                        todasEstaoLivres = false;
                    }
                }

                if (fila.isEmpty() && chegados.isEmpty() && todasEstaoLivres) {
                    break;
                }

            }
            System.out.println("-----------------------");
            System.out.println("Equipa NDoentes MediaTA");
            System.out.println("-----------------------");

            for (int i = 0; i < equipas; i++) {
                // System.out.println(i);
                // System.out.println(numerodoentes[i]);
                // System.out.println((double) tempo_atendimento[i] / numerodoentes[i]);
                System.out.println(String.format("%6d %8d %7.1f", i, numerodoentes[i],
                        (double) tempo_atendimento[i] / numerodoentes[i]));

            }
            System.out.println("---------------------------");
            System.out.println(String.format("Tempo medio de espera: %2.1f", (double) tempodeespera / totalPacientes));
        }
        sc.close();

    }
}

class EquipaAgregado {
    Queue<Equipa> fila;
    int[] ocupadoate;
    Queue<Equipa> ocupados;

    EquipaAgregado(int numero) {
        for (int i = 0; i < numero; i++) {
            fila.add(new Equipa(0, 0, i));
            ocupadoate = new int[numero];
        }
    }

    boolean temEquipasLivres() {
        return fila.isEmpty();
    }

    void meterPessoa(Person doente, int time) {
        Equipa eq = fila.poll();
        eq.n_pacientes += 1;
        eq.tempodeesperatotal = time - doente.t_chegada;
        ocupadoate[eq.n_equipa] = time + doente.t_attend;
    }

    void updateTime() {

    }
}

class Equipa {
    int n_equipa;
    int n_pacientes;
    int tempodeesperatotal;

    Equipa(int n_pacientes, int tempodeesperatotal, int n_equipa) {
        this.n_pacientes = n_pacientes;
        this.tempodeesperatotal = tempodeesperatotal;
        this.n_equipa = n_equipa;
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