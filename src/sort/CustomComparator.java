package sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Create by Alex Chan in 21:52  2017/11/1
 */
public class CustomComparator implements Comparator<Person> {
//自定义比较方法
    @Override
    public int compare(Person o1, Person o2) {
        return (o1.getA()-o2.getA());
    }
//测试自定义比较类CustomComparator中的比较方法
    public static void main(String[] args) {
        List<Person> list=new ArrayList<Person>();
        list.add(new Person(2,"alex"));
        list.add(new Person(6,"chan"));
        list.add(new Person(4,"yixi"));
        System.out.println(Util.less2(new Person(2,"alex"),new Person(6,"chan"),new CustomComparator()));

    }
}
