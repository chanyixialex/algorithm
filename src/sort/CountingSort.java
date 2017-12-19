package sort;

/**
 * Create by Alex Chan in 15:23  2017/11/1
 * 计数排序：是一种非比较排序（这里的算法是基于升序)
 * 适用范围：适用于排序数据范围不大的情况。如果数据范围太大会导致空间复杂度太大
 * 特点：1.时间复杂度为O(k+n),k为待排序的数据范围，n为待排序数组大小，当k=O(n)时，时间复杂度为O（n）
 *       2.该算法是稳定的（stable）。
 *       3.空间复杂度O(k+n),k与n的含义与上述一致
 * 下面是分布计数，其实也有基于比较计数方式
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] array={4,1,3,4,3};
        int[] results=countingSort(array,4);
        //打印排序后的结果数组
        for (int i :
                results) {
            System.out.println(i+"");
        }
        System.out.println();

    }

    /**
     *@param a :输入的数组
     * @param max:待排序数组的元素的范围，即0~max
     * @return 排序后的数组
     */

    public static int[] countingSort(int[] a,int max){//注意定义的数组下标是从0开始的
        int[] results=new int[a.length];//返回排序后的数组
        int[] count=new int[max+1];//计数数组,自动初始化为0，技巧：如果知道待排序数组没有包括0，可以减少一个元素空间。
        for (int i : a) {//循环后，count[i]代表元素i的数量
            count[i]++;
        }
        for(int i=1;i<=max;i++){//循环后，count[i]代表小于后等于i的元素数量
            count[i]+=count[i-1];
        }
        for(int j=a.length-1;j>=0;j--){//遍历待排序数组
            results[count[a[j]]-1]=a[j];//这行代码是注意点。把待排序数组中当前遍历的元素的计数位置作为当前元素在结果数组results中的位置
            count[a[j]]-=1;//调整当前元素的count
        }
        return results;
    }
}
