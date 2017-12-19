package sort;

import java.util.Comparator;

/**
 * Create by Alex Chan in 19:39  2017/11/1
 * 排序算法的工具类
 */
public class Util {
    /**
     *比较大小
     * @param a:比较对象
     * @param b：比较对象
     * @return a小于b返回真，否则返回假
     */
    public static boolean less(Comparable a,Comparable b ){
        return a.compareTo(b)<0;
    }

    /**
     * 交换元素
     * @param a 交换的对象数组
     * @param i 交换位置
     * @param j 交换位置
     */
    public static void exch(Comparable[] a,int i,int j){
        Comparable swap=a[i];
        a[i]=a[j];
        a[j]=swap;
    }

    /**
     *检查是否排好序（升序），是一个用于调试的方法。
     * @param a 待排序元素
     * @return 排好序返回true，否则返回false
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    /**
     *自定义Comparator的比较方法
     * @param v
     * @param w
     * @param comparator
     * @return
     */
    public static boolean less2(Object v, Object w, Comparator comparator) {
        return comparator.compare(v, w) < 0;
    }

    /**
     * 自定义comparator的排序方法
     * @param a
     * @param comparator
     * @return
     */
    public static boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, 0, a.length, comparator);
    }

    // is the array a[lo..hi) sorted
    public static boolean isSorted(Object[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo+1; i < hi; i++)
            if (less2(a[i], a[i-1], comparator)) return false;
        return true;
    }
}
