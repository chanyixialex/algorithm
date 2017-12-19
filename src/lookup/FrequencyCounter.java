package lookup;

import utils.StdIn;
import utils.StdOut;

/**
 * Create by Alex Chan in 14:20  2017/12/5
 * 遍历所有的键，记录每个键频率
 *
 */
public class FrequencyCounter {
    public static void main(String[] args) {
        ST<String,Integer> st=new ST<>();//初始化符号表
        int distinct=0,words=0;           //distinct为不同键的数量，words是键的总数量
        int minlen=Integer.parseInt(args[0]);  //获取键的最小的长度
        while(!StdIn.isEmpty()){
            String word =StdIn.readString();
            if(word.length()<minlen) continue;
            words++;
            if(!st.contains(word)){
                st.put(word,1);
                distinct++;
            }else
                st.put(word,st.get(word)+1);
        }
        String max=" ";  //初始化频率最大的键为空字符串
        st.put(max,0);
        for (String word :
                st.keys()) {
            if(st.get(word)>st.get(max))
                max=word;

        }
        StdOut.println(max+" "+st.get(max));  //输出频率最大的键的值
        StdOut.println("distinct = " + distinct);
        StdOut.println("words    = " + words);
    }
}
