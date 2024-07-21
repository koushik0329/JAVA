import java.util.Arrays;

public class Selection {
    private static void sort(int[] a){
        int n=a.length;
        for(int i=0;i<n-1;i++){
            int min=i;
            for(int j=i+1;j<n;j++){
                if(a[j]<a[min]){
                    min=j;
                }
            }
            int temp=a[min];
            a[min]=a[i];
            a[i]=temp;
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
