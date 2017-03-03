package sortdemo;
/**
**  author:jack 2017年02月2017/2/19日
*/
public class QucikSort {
    public static void main(String[] args) {
        QucikSort qucikSort = new QucikSort();
        int[] a = new int[]{3,5,1,2,7,0,-1};
        qucikSort.quickSortTest(a,0,a.length - 1);
        for(int i : a){
            System.out.println(i);
        }
    }

    public void  quickSortTest(int[] arry,int first,int last){
        if(first >= last){
            return;
        }
        int mid = quickSort(arry,first,last);
        quickSortTest(arry,first,mid - 1);
        quickSortTest(arry,mid + 1,last);
    }

    public int quickSort(int[] arry,int first,int last){
        int i = first;
        int j = last;
        int x = first;
        while(i < j){
            while(arry[x] < arry[j]){
                j--;
            }
            exchange(arry,x,j);
            x = j;
            while(arry[x] > arry[i]){
                i++;
            }
            exchange(arry,x,i);
            x = i;
        }
        return x;
    }

    /**
     *
     * @param a
     * @param b
     */
    public void exchange(int[] arry,int a,int b){
        int temp = arry[a];
        arry[a] = arry[b];
        arry[b] = temp;
    }
}
