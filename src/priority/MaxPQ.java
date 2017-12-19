package priority;
import java.util.Iterator;

/**
 * Create by Alex Chan in 15:32  2017/11/4
 * 基于二叉堆的优先队列
 * 二叉堆：是一组能够用堆有序的完全二叉树排序的元素，并在数组中按照层级存储。
 * 堆有序：当一棵二叉树的每个结点都大于等于它的两个子结点时，它就被称为堆有序。
 */
public class MaxPQ<K> implements Iterable<K>{
   private K[] pq;   //优先队列
   private int n;  //队列大小
    /**
     * 构造函数
     * @param maxN:优先队列大小
     */
    public MaxPQ(int maxN){
        pq=(K[])new Object[maxN+1];  //初始化一个空的优先队列，数据存储于pq[1...N]中，pq[0]没有使用
    }
    /**
     * 接受一个数组作为参数，自底向上的方法构造堆
     * @param initarray
     */
    public MaxPQ(K[] initarray){

    }
    //加一个调整数组大小的代码
    //判断队列空
    public boolean isEmpty(){
        return n==0 ? true:false;
    }
    //判断队列大小
    public int size(){
        return n;
    }

    /**
     * 比较元素大小
     * @param i 第一元素下标
     * @param j 第二个元素下标
     * @return
     */
    public boolean less(int i,int j){
        return ((Comparable<K>)pq[i]).compareTo(pq[j])>0;
    }

    /**
     * 交换数
     * @param i
     * @param j
     */
    public void exch(int i,int j){
        K temp=pq[i];
        pq[i]=pq[j];
        pq[j]=temp;
    }

    /**
     * 向上有序化堆
     * @param k 比父节点大的节点
     */
    public void swim(int k){
        while(k>1&&less(k,k/2)){
            exch(k,k/2);
            k=k/2;
        }
    }

    /**
     * 向下有序化堆
     * @param k 比子节点小的结点
     */
    public void sink(int k){
        while(k*2<=n){
            int j=2*k;
            if(j<n&&less(j+1,j))
                j++;
            if(!less(j,k))    //这种效率更高（具体点应该是说代码更好看），注意点！！！
                break;
            exch(j,k);
            k=j;
        }
    }

    /**
     * 向堆中插入新元素，在堆最后位置插入
     * @param v
     */
    public void insert(K v){
        pq[++n]=v;
        swim(n);
    }

    /**
     * 从堆中获取最大元素
     * @param v
     * @return
     */
    public K delMax(K v){
        K max=pq[1]; //从根结点中获取最大元素
        exch(1,n--); //将其与最低元素交换
        pq[n++]=null;  //注意点！！！防止对象游离，即把之前的最大元素回收为null。
        sink(1);
        return max;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }
}
