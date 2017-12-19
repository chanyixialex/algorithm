package strings;

import utils.StdOut;

/**
 * Create by Alex Chan in 16:21  2017/12/12
 * Boyer-Moore模式匹配算法：
 * 1.只用坏字符，没有用好后缀，好后缀类似于kmp中的next[]表格
 * 2.测试字符：子串：ababaca，主串： bacbabababacaca
 */
public class BoyerMoore {
    private String pat;//模式字符串
    private char[] pattern;//模式字符数组
    private final int size;//匹配的字符表大小
    private int[] right;//坏字符匹配数组

    /**
     * 模式串pat的构造函数
     * @param pat：模式串
     */
    public BoyerMoore(String pat){
        this.size=256;//默认字符表大小为256
        this.pat=pat;
        this.right=new int[this.size];
        for (int i = 0; i < size; i++) {
            this.right[i]=-1;
        }
        for (int j = 0; j < pat.length(); j++) {
            this.right[pat.charAt(j)]=j;
        }

    }

    /**
     * 字符数组的构造函数
     * @param pattern：字符数组模式串
     * @param size：要匹配的字符表大小
     */
    public BoyerMoore(char[] pattern,int size){
        this.size=size;
        int length=pattern.length;
        this.pattern=new char[length];
        for (int i = 0; i < length; i++) {
            this.pattern[i]=pattern[i];
        }
        right=new int[size];
        for (int i = 0; i < size; i++) {
            right[i]=-1;
        }
        for (int j = 0; j < length; j++) {
            right[pattern[j]]=j;
        }
    }

    /**
     * 字符串模式匹配，此算法只找第一个匹配的字符串在主串中的起始位置。
     * @param txt：主串
     * @return：成功：返回匹配的第一个字符索引，不匹配返回主串大小
     */
    public int search(String txt){
        int n=txt.length();
        int m=this.pat.length();
        int skip;
        for (int i = 0; i <= n-m; i=i+skip) {
            skip = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    skip = Math.max(1, j-right[txt.charAt(i + j)]);
                    break;
                }
            }
            if (skip == 0) return i; //成功返回第一个匹配的字符位置
        }
        return n;//匹配不成功，返回主串大小
    }
    public int search(char[] text){
        int n=text.length;
        int m=pattern.length;
        int skip;
        for (int i = 0; i <= n-m; i+=skip) {
            skip=0;
            for (int j = m-1; j >= 0; j--) {
                if(pattern[j]!=text[i+j]){
                    skip=Math.max(1,j-right[text[i+j]]);
                    break;
                }
            }
            if(skip==0) return i;
        }
        return n;
    }

    public static void main(String[] args) {
        String pat = args[0];
        String txt = args[1];
        char[] pattern = pat.toCharArray();
        char[] text = txt.toCharArray();
        BoyerMoore bm1 = new BoyerMoore(pat);
        BoyerMoore bm2 = new BoyerMoore(pattern,256);
        int offset1 = bm1.search(txt);
        int offset2=bm2.search(text);
        // print results
        StdOut.println("text:    " + txt);

        StdOut.print("pattern: ");
        for (int i = 0; i < offset1; i++)
            StdOut.print(" ");
        StdOut.println(pat);

        StdOut.print("pattern: ");
        for (int i = 0; i < offset2; i++)
            StdOut.print(" ");
        StdOut.println(pat);
    }

}
