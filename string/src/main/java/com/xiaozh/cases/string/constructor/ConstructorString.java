package com.xiaozh.cases.string.constructor;

import java.io.UnsupportedEncodingException;

public class ConstructorString {
    public static void main(String[] args) throws UnsupportedEncodingException {
       /* // 1、空的字符序列
        String s = new String();
        // 2、默认字符集解码制定的字节数组
        byte[] bytes = new byte[]{2, 31, 41, 12, -12};
        String s2 = new String(bytes, "iso-8859-1");
        System.out.println(Arrays.toString(s2.getBytes("iso-8859-1")));
        // 3、默认字符集解码制定的字节子列
        byte[] bytes2 = new byte[]{1, -2, 13, 4, 5, 5};
        String s3 = new String(bytes2, 1, 4); // length 2
        // 4、指定字符集解码
        String s4 = new String(bytes2, 1, 2, "iso-8859-1");
        System.out.println(Arrays.toString(s4.getBytes("iso-8859-1")));
        // 5、String?(byte[] bytes, String charsetName)
        //      String?(byte[] bytes, Charset charset)
        String s5 = new String(bytes2, "utf8");
        System.out.println(Arrays.toString(s5.getBytes("utf8")));
        // 6、String?(char[] value)
        // String?(char[] value, int offset, int count)
        String s6 = new String(new char[]{'1', 'b', 'c', '2'});
        System.out.println(s6);
        String s7 = new String(new char[]{'1', '2', 's', 'a'}, 1, 2);
        System.out.println(s7);
        // 7、String?(String original)
        // String?(StringBuffer buffer)
        // String?(StringBuilder builder)
        String s8 = new String("hello");



        //       System.out.println(Charset.defaultCharset().name());

*/
        //输出当前环境属性
        System.getProperties().list(System.out);
    }
}
