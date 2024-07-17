import java.util.Random;

public class Mergesort {

    public static void main(String[] args) {
        Random ran=new Random();
        int[] a=new int[10];
        for(int i=0;i<a.length;i++){
            a[i]=ran.nextInt(100);
        }
        System.out.println("before sort");
        printa(a);

        mergesort(a);

        System.out.println("after sort");
        printa(a);
    }
    public static void mergesort(int[] a){
        int len=a.length;
        if(len<2)
            return;

        int mid=len/2;
        int[] l=new int[mid];
        int[] r=new int[len-mid];

        for(int i=0;i<l.length;i++){
            l[i]=a[i];
        }
        for(int i=mid;i<len;i++){
            r[i-mid]=a[i];
        }
        mergesort(l);
        mergesort(r);

        sor(a,l,r);
    }
    private static void sor(int[] a,int[] l, int[] r){
        int i=0,j=0,k=0;
        int ls=l.length;
        int rs=r.length;
        while(i<ls && j<rs){
            if(l[i]>r[j]){
                a[k]=r[j];
                j++;
            }
            else{
                a[k]=l[i];
                i++;
            }
            k++;
        }
        while(i<ls){
            a[k]=l[i];
            i++;
            k++;
        }
        while(j<rs){
            a[k]=r[j];
            j++;
            k++;
        }
    }

    private static void printa(int[] num){
        for(int i=0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
        System.out.println();
    }
}
