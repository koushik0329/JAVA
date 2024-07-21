import java.util.Arrays;

public class Bubble {
    private static void sort(int a[]){
        int n=a.length;
        for(int i=0;i<n;i++){
            int isswapped=0;
            for(int j=0;j<n-1;j++){
                if(a[j]>a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    isswapped=1;
                }
            }
            if(isswapped==0){
                break;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr={3,1,5,6,2,7};
        System.out.print("before sorting");
        System.out.print(Arrays.toString(arr));
        sort(arr);
        System.out.print("after sorting");
        System.out.print(Arrays.toString(arr));
    }
}
