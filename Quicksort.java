public class Quicksort {
    private static void pa(int[] a){
        for(int i:a){
            System.out.println(i);
        }
    }
    private static void quick(int[] a,int low,int high){
        if(low>=high){
            return;
        }
        int pivot=a[high];
        int i=partition(a,low,high,pivot);

        quick(a,low,i-1);
        quick(a,i+1,high);
    }
    private static int partition(int[] a,int low,int high,int pivot){
        int i=low;
        int j=high-1;
        while(i<j){
            while(a[i]<=pivot && i<j){
                i++;
            }
            while(a[j]>=pivot && i<j){
                j--;

            }
            sort(a,i,j);
        }
        sort(a,i,high);
        return i;
//        returns pivot element after getting smaller elements, before pivot and larger elements, after pivot
    }
    private static void sort(int[] a, int i, int j){
        int temp;
        temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static void main(String[] args) {
        int[] a={4,87,3,1,6,45,8,5,11,9,2,7};
        System.out.println("before sorting");
        pa(a);
        quick(a,0,a.length-1);


        System.out.println("after sorting");
        pa(a);

    }
}
