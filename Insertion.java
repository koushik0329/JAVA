import java.util.Arrays;

public class Insertion {
    private static void sort(int[] arr){
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr={3,1,5,6,29,7};
        System.out.print("before sorting");
        System.out.print(Arrays.toString(arr));

        sort(arr);
        System.out.print("after sorting");
        System.out.print(Arrays.toString(arr));
    }
}
