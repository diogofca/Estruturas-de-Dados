import java.util.Scanner;
import java.util.Arrays;


class ED231 {

    public static int[] differences(int[] cases) {
        int[] toReturn = new int[cases.length -1];
        for (int j = 0; j<toReturn.length; j++) {
            toReturn[j] = cases[j+1]- cases[j];

        }
        // System.out.println(Arrays.toString(toReturn));
        return toReturn;
    }
    


    public static double[] differencesPercentage(int[] cases) {
        double[] toReturn = new double[cases.length -1];
        for (int j = 0; j<toReturn.length; j++) {
            toReturn[j] = (cases[j+1]- cases[j])/((double) cases[j]);

        }
        // System.out.println(Arrays.toString(toReturn));
        return toReturn;
    }

    public static int max(int[] a) {
        int toReturn = a[0];
        for (int i = 0; i<a.length; i++) {
            if (a[i] > toReturn) {
                toReturn = a[i];
            }
        }
        return toReturn;
    }


    public static int min(int[] a) {
        int toReturn = a[0];
        for (int i = 0; i<a.length; i++) {
            if (a[i] < toReturn) {
                toReturn = a[i];
            }
        }
        return toReturn;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[] cases = new int[N];
        for (int i= 0; i<N; i++) {
            cases[i] = sc.nextInt();
        }
        sc.nextLine();
        int flag = sc.nextInt();
        if (flag == 1) {
            int[] diff = differences(cases);
            System.out.println(String.format("%d %d",min(diff), max(diff)));
        } else if (flag == 2) {
            double[] percentageDifferente = differencesPercentage(cases);
            int last  = 0;
            int[] comprimentoPeriodosDeBaixaPropagacao = new int[percentageDifferente.length+1];
            for (int t = 0; t<percentageDifferente.length; t++) {
                if (percentageDifferente[t] <= 0.05) {
                    last+= 1;
                } else if (percentageDifferente[t] > 0.05 && last != 0) {
                    comprimentoPeriodosDeBaixaPropagacao[t] = last;
                    last = 0;
                } else {
                    // do nothing
                }
            }
            // System.out.println(Arrays.toString(comprimentoPeriodosDeBaixaPropagacao));
            if (last > 0) {
                comprimentoPeriodosDeBaixaPropagacao[comprimentoPeriodosDeBaixaPropagacao.length-1] = last;
            }
            int counter = 0;
            int max = 0;
            for (int j = 0; j<comprimentoPeriodosDeBaixaPropagacao.length; j++){
                if (comprimentoPeriodosDeBaixaPropagacao[j] > 0) {
                    counter += 1;
                    if (comprimentoPeriodosDeBaixaPropagacao[j] > max) {
                        max = comprimentoPeriodosDeBaixaPropagacao[j];
                    }
                }
            }

            System.out.println(String.format("%d %d", counter, max));

        } else if (flag == 3) {
            int[] normalized = casesNormalized(cases);
            int maior = max(normalized);
            String[] normalizedString = new String[normalized.length];
            for (int y = 0; y<normalized.length; y++) {
                normalizedString[y] = hastags(maior-normalized[y], ".") + hastags(normalized[y], "#"); 
            }
            for(int x = 0; x<maior; x++) {
                for (int y = 0; y<normalized.length; y++) {
                
                    System.out.print(normalizedString[y].toCharArray()[x]);
                }
                System.out.println();
            }

        }
        
        
        
        sc.close();
    }

    public static String hastags(int n, String p) {
        String toReturn = "";
        for (int j = 0; j<n; j++) {
            toReturn += p;
        }
        return toReturn;
    }

    public static int[] casesNormalized(int[] cases) {
        int[] toReturn = new int[cases.length];
        for (int i = 0; i<toReturn.length; i++) {
            toReturn[i] = cases[i]/100;
        }
        return toReturn;
    } 

}
