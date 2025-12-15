import java.util.Scanner;

public class ED241 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int flag = sc.nextInt();
        int N = sc.nextInt();
        if (flag == 1) {
            BSTree<String> alunos = new BSTree<String>();
            for (int i = 0; i < N; i++) {
                alunos.insert(sc.next());
                sc.next();
                sc.next();
            }
            System.out.println(alunos.numberNodes());
        } else if (flag == 2) {
            BSTMap<String, Integer> alunos = new BSTMap<String, Integer>();
            for (int i = 0; i < N; i++) {
                sc.next();
                String problema = sc.next();
                sc.next();
                if (alunos.get(problema) == null) {
                    alunos.put(problema, 1);
                } else {
                    alunos.put(problema, alunos.get(problema) + 1);
                }
            }
            String p = "";
            int max = 0;
            for (String problema : alunos.keys()) {
                if (alunos.get(problema) > max) {
                    p = problema;
                    max = alunos.get(problema);
                }
            }
            System.out.println(String.format("%s %d", p, max));
        } else if (flag == 3) {

            BSTMap<String, Integer> problemasFrequencia = new BSTMap<String, Integer>();

            BSTMap<String, Integer> problemasAceites = new BSTMap<String, Integer>();
            for (int i = 0; i < N; i++) {
                sc.next();
                String problema = sc.next();
                String estado = sc.next();
                if (problemasFrequencia.get(problema) == null) {
                    problemasFrequencia.put(problema, 1);
                    if (estado.equals("Accepted")) {
                        problemasAceites.put(problema, 1);
                    }

                } else {
                    problemasFrequencia.put(problema, problemasFrequencia.get(problema) + 1);
                    if (estado.equals("Accepted")) {
                        if (problemasAceites.get(problema) == null) {
                            problemasAceites.put(problema, 1);
                        }
                        problemasAceites.put(problema, problemasAceites.get(problema) + 1);
                    }
                }
            }
            for (String problemas : problemasFrequencia.keys()) {
                if ((double) problemasAceites.get(problemas) / problemasFrequencia.get(problemas) >= 0.5) {
                    System.out.println(problemas);
                }
            }
        } else if (flag == 4) {

            BSTree<String> n_problemas = new BSTree<String>();
            BSTMap<String, BSTree<String>> major = new BSTMap<>();
            for (int i = 0; i < N; i++) {
                String aluno = sc.next();
                String problema = sc.next();
                String estado = sc.next();
                n_problemas.insert(problema);
                if (estado.equals("Accepted")) {
                    if (major.get(aluno) == null) {
                        BSTree<String> toPut = new BSTree<String>();
                        toPut.insert(problema);
                        major.put(aluno, toPut);
                    } else {
                        BSTree<String> toModify = major.get(aluno);
                        toModify.insert(problema);
                    }
                }
            }
            for (String aluno : major.keys()) {
                if (major.get(aluno).numberNodes() == n_problemas.numberNodes()) {
                    System.out.println(aluno);
                }
            }
        }
    }
}
