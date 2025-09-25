import java.util.Arrays;

class InsertionSort {

    public static void main(String[] args) {
        int[] a = { 5, 3, 2, 0 };
        insertionSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int a = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > a) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = a;
        }
    }
}