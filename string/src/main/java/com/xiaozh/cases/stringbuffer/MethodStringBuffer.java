package com.xiaozh.cases.stringbuffer;

public class MethodStringBuffer {


    /*
    线程安全的可变字符序列 ,String的每次拼接都会产生新的对象，还会分配新的空间，造成浪费
     */

    public static void main(String[] args) {

        System.out.println("StringBuffer()的构造方法：");
        StringBuffer sb = new StringBuffer("hello");
        StringBuffer sb2 = new StringBuffer(new String("hello"));
        System.out.println(sb == sb2);
        System.out.println(sb.equals(sb2)); // 没有重写equals()方法

        StringBuffer sb3 = new StringBuffer();// 初始容量为16
        StringBuffer sb4 = new StringBuffer(21); // 指定容量
        System.out.println("capacity(): " + sb3.capacity());  // 16
        System.out.println("length(): " + sb3.length()); // 容纳字符的长度
        System.out.println(sb.capacity()); // 21 在16的基础上加上字符串的长度

        add();
        get();
        delete();
        change();

    }

    /*
    添加方法
    StringBuffer append(boolean b)   [char double float int long String StringBuffer]
    StringBuffer append(Object obj)
    StringBuffer append(char[] str)
    StringBuffer append(char[] str, int offset, int len)
    StringBuffer append(CharSequence s)
    StringBuffer append(CharSequence s, int start, int end)
    StringBuffer appendCodePoint(int codePoint)
     */
    public static void add() {
        System.out.println("添加方法：");
        StringBuffer sb = new StringBuffer();
        sb.append('a');
        sb.append(false);
        sb.append(4);
        sb.append(1l);
        sb.append(new Object()); // String.valueOf()
        System.out.println(sb); // afalse41
        StringBuffer sb2 = new StringBuffer();
        char[] ch = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
        sb2.append(ch);
        System.out.println(sb2);
        sb2.append(ch, 1, 4);
        System.out.println("sb2  :  " + sb2);
        sb2.append("hello", 2, 4);
        System.out.println(sb2 + "::");
        sb2.appendCodePoint(98); // 98 -> b
        System.out.println(sb2);
    }

    /*
    获取方法：
        int capacity()
        char charAt(int index)
        int codePointAt(int index)
        int codePointBefore(int index)  指定索引前一个的字符
        int codePointCount(int beginIndex, int endIndex)
        void getChars(int srcBegin, int srcEnd, char[] dst, int offset)
            字符从该序列复制到目标字符数组 dst 。
        int indexOf(String str)
            返回指定子字符串第一次出现的字符串内的索引。
        int indexOf(String str, int fromIndex)
            返回指定子串的第一次出现的字符串中的索引，从指定的索引开始。
     */
    public static void get() {
        System.out.println("测试获取方法：");
        StringBuffer sb = new StringBuffer();
        sb.append("woiw laflkdsa");
        int x = sb.charAt(1);
        System.out.println(x);
        int count = sb.codePointCount(1, 6);
        System.out.println("count: " + count);
        char[] ch = new char[24];
        sb.getChars(1, 6, ch, 2);
        for (char c : ch) {
            System.out.println(c);
        }
        x = sb.indexOf("y");
        System.out.println(x); // -1
    }

    /*
    删除方法：
    StringBuffer delete(int start, int end)
    StringBuffer deleteCharAt(int index)
     */
    public static void delete() {
        System.out.println("测试删除方法：");
        StringBuffer sb = new StringBuffer();
        sb.append("adfas f af safdsaf asdf s");
        sb.delete(2, 200);  //
        System.out.println(sb);
        sb.deleteCharAt(1);
        System.out.println(sb);

    }

    /*
    改：
    StringBuffer insert(int offset, char c)
    StringBuffer replace(int start, int end, String str)
    StringBuffer reverse()
    void setCharAt(int index, char ch)
    void setLength(int newLength)  和容量没有关系
    CharSequence subSequence(int start ,int end)
    String subString(int start)
    String subString(int start, int end)
    void trimToSize()
     */
    public static void change() {
        System.out.println("测试修改方法：");
        StringBuffer sb = new StringBuffer();
        sb.append("hijklmn");
//        sb.insert(2, "hello");
        sb.insert(2, "hello", 1, 2);
        System.out.println("sequence:" + sb);

        System.out.println(sb.offsetByCodePoints(1, 5));

        sb.insert(2, 12); // 就是把索引2的位置插入12
        System.out.println(sb);
        sb.insert(2, new char[]{'1', 'b', 'c'});
        System.out.println(sb);
        sb.insert(2, new char[]{'a', 'b', 'c', 'd'}, 1, 2);
        System.out.println("::" + sb);

        sb.replace(0, 4, "ooo");
        System.out.println(sb);

        System.out.println(sb.reverse());

        sb.setCharAt(1, 'x');
        System.out.println(sb);

        System.out.println(sb.capacity()); // 34
        sb.setLength(10);//可以用来截串  大于当前长度，则是'\u0000'补  和容量没有关系
        System.out.println(sb.capacity());

        System.out.println(sb.subSequence(0, 4));

        System.out.println("---" + sb);
        String subString = sb.substring(2);
        System.out.println(sb); // 原字符串不变

        sb = new StringBuffer("afda  fasf dafs dfaf as fadsf ");
        System.out.println(sb.length()); // 30
        System.out.println(sb.capacity()); // 46
        sb.trimToSize();
        System.out.println(sb);
        System.out.println(sb.length()); // 30
        System.out.println(sb.capacity()); // 30

    }


}
