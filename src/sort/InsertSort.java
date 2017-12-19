package sort;

/**
 * Create by Alex Chan in 16:40  2017/11/1
 * 插入排序：这里的算法都是升序
 * 适用范围：1.适用于待排序元素比较接近有序的情况或部分有序（倒置数量小于数组大小的某个倍数，详细概念课参考《算法》p157），
 *           有序程度越高，排序移动的次数就越少。速度会快很多。最糟糕的情况是待排序元素是逆序排序。
 *           2.也适合于小规模数组
 * 特点：1.该算法是稳定的。
 *       2.时间复杂度为O（n^2）,最好为c=n-1=O(n),平均为c=n^2/4=O(n^2),最坏为c=n(n-1)/2=O(n^2)。这是根据比较次数。
 *       3.空间复杂度为O(1),就地（原地）排序。
 */
public class InsertSort {
    public static void main(String[] args) {
        Integer[] a={4,1,3,4,3,0,6,9,2};//里面的int会自动装箱
        sortY(a);
        for (Integer i :
                a) {
            System.out.println(i+"");
        }
        System.out.println();

    }

    /**
     * 直接插入排序算法1：有交换的插入排序。
     * @param a 待排序元素集
     */
    public static void sort(Comparable[] a){
        int N=a.length;
        for (int i = 1; i <N ; i++) {
            for (int j = i; j >0&&Util.less(a[j],a[j-1]) ; j--) {//注意点：less函数。包括比较函数
                Util.exch(a,j,j-1);//交换元素
            }
        }
        assert Util.isSorted(a);//检查是否排好序
    }

    /**
     * 直接插入排序2（最快的插入排序）：引入哨兵（能够省略判断条件的元素通常称为哨兵），去掉内循环的判断条件j>0。
     * @param a 待排序元素集
     */
    public static void sortX(Comparable[] a){
        int  n=a.length;
        int exchanges=0;//交换次数
        /**
         * 这个循环实现哨兵
         */
        for (int i = n-1; i >0 ; i--) {//找最小的元素交换到第一个位置。相当于冒泡排序的一次内循环。
            if(Util.less(a[i],a[i-1])){
                Util.exch(a,i,i-1);
                exchanges++;
            }
        }
        if(exchanges==0) return;//等于0，说明没有交换过，即已经排好序了
        /**
         * 这个循环就是使用了不需要交换的插入排序
         */
        for (int i = 2; i <n ; i++) {//从第三个元素开始，因为第一个元素是哨兵，是最小的。
            Comparable temp=a[i];
            int j=i;
            while (Util.less(temp,a[j-1])){//注意点：第一个元素是temp。判断是否a[i]小于a[j-1]
                a[j]=a[j-1];              //a[j-1]上移一位
                j--;
            }
            a[j]=temp;
        }
        assert Util.isSorted(a);
    }

    /**
     * 直接插入排序3：不需要交换的插入排序，内循环的较大元素内移即可
     * @param a 待排序元素集
     */
    public static void sortY(Comparable[] a){
        int n=a.length;
        for (int i = 1; i <n ; i++) {
            Comparable temp=a[i];
            int j=i;
            for (; j >0&&Util.less(temp,a[j-1]) ; j--) {//注意点：第一个元素是temp。判断是否a[i]小于a[j-1]
                a[j]=a[j-1]; //a[j-1]上移一位
            }
            a[j]=temp;
        }
        assert Util.isSorted(a);
    }
}
