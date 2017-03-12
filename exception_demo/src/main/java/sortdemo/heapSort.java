package sortdemo;
/**
**  author:jack 2017年02月2017/2/23日
*/
public class heapSort {

    public static void heapOne(int[] a,int n,int k){
        int k1 = 2 * k + 1;
        int k2 = 2 * k + 2;

        if(k1 >= n && k2 >= n){
            return;
        }

        int a1 = Integer.MAX_VALUE;
        int a2 = Integer.MAX_VALUE;
        if(k1 < n){
            a1 = a[k1];//左孩子的值
        }
        if(k2 < n){
            a2 = a[k2];//右孩子的值
        }

        if(a[k] <= a1 && a[k] <= a2){
            return;
        }

        //这里必须是需要判断的，需要和子树中小的一个进行交换，不然是有问题的。
        if(a1 < a2){
            int t = a[k];
            a[k] = a[k1];
            a[k1] = t;
            heapOne(a,n,k1);//继续筛选子树
        }else{
            int t = a[k];
            a[k] = a[k2];
            a[k2] = t;
            heapOne(a,n,k2);//继续筛选子树
        }
    }

    public static void heapSort(int[] a){

        //需要从后向前进行堆化
        for(int i = (a.length - 1)/2;i >= 0;i--){
            heapOne(a,a.length,i);
        }

        int n = a.length;
        while(n > 0){
            System.out.println(a[0]+" ");
            a[0] = a[n-1];
            n--;
            heapOne(a,n,0);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {6,4,7,9,2,3};
        heapSort(a);
    }
}
