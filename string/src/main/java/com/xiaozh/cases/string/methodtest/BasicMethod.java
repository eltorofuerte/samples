package com.xiaozh.cases.string.methodtest;

/**
 * Java中没有内置String的数据类型，而是预定义好的一个类
 * String类的方法演示：
 */

public class BasicMethod {
    public static void main(String[] args) {
        String s = "Java\u2122";
        System.out.println(s);
        substringDemo();
        joinDemo();
        getNewString();
        equalsDemo();
        isEmptyDemo();
        compareToDemo();
        testString();
    }

    /**
     * 4、字符串比较
     * 结论：
     * 1、equals 比较的是两个字符串的字符序列,==比较的是字符串对象在内存中的地址值
     */
    public static void equalsDemo() {
        String s1 = "helloworld";
        String s2 = "hello" + "world";
        String s3 = s1;
        String s4 = "hello";
        String s5 = "world";
        String s6 = s4 + s5;
        String s7 = s1.substring(0, 5);
        String s8 = new String("hello");

        // true
        boolean b1 = s1.equals(s2);
        // true
        boolean b2 = s1.equals(s3);
        // true
        boolean b3 = s1.equals("helloworld");
        // true
        boolean b4 = s1.equals(s6);
        // true
        boolean b5 = s4.equals(s7);

        // true
        System.out.println("s4.equals(s8):" + s4.equals(s8));
        System.out.println("b1:" + b1);
        System.out.println("b2:" + b2);
        System.out.println("b3:" + b3);
        System.out.println("b4:" + b4);
        //true
        System.out.println("b5:" + b5);
    }

    /**
     * 1、只有字符串常量是共享的，存放在String池中
     * 2、对变量拼接，是先为这两个变量开辟空间，拼接后会产生新的地址；
     * 但是两个常量拼接，则是在常量池中查找，没有才会创建
     */
    public static void testString() {
        String s1 = "HelloWorld";
        String s2 = "Hello";
        String s3 = "World";
        // s2 = s2 + "World"; 这里开辟了两个空间 常量池中没有World，开辟了新的空间
        s2 += "World";
        // HelloWorld
        String s4 = "Hello" + "World";
        // 创建了两个对象
        String s5 = new String("HelloWorld");
        String s6 = s2 + s3;
        String s7 = s1.substring(0, 5);

        // false
        System.out.println("s1==s2:" + (s1 == s2));
        // true
        System.out.println("s1==s4:" + (s1 == s4));
        // false
        System.out.println("s1==s6:" + (s1 == s6));

        // false
        System.out.println("s1==s5:" + (s1 == s5));
        // false
        System.out.println("s2==s7:" + (s1 == s7));
    }

    /**
     * compareTo()方法测试
     */
    private static void compareToDemo() {
        String s1 = "hello";
        String s2 = "hello world";
        String s3 = "hallo";
        // s1.length() - s2.length();
        int count = s1.compareTo(s2);
        System.out.println("s1 compareTo s2:" + count);
        count = s1.compareTo(s3);
        // s1.charAt(1) - s3.charAt(1);
        System.out.println("s1 compareTo s3:" + count);
    }

    // 截取字符串方法
    // 1、public String substring(int beginIndex)
    // 2、public String substring(int beginIndex, int endIndex)
    //                  返回从beginIndex到endIndex-1的字串
    // 字串的长度是 end-begin
    public static void substringDemo() {
        String s = "helloworld";
        String s1 = s.substring(2);
        System.out.println(s1);
        String s2 = s.substring(2, 6);
        System.out.println(s2);

    }

    /**
     * 2、字符串拼接 ”+“
     * public String join(CharSequence delimiter, CharSequence... elements)
     */
    public static void joinDemo() {

//        String s = String.join("\u2122", "string", "null", " ", "1");
        String s = String.join("我", "string", "null", " ", "1");
        System.out.println(s);

    }

    // 3、Java是不可变字符串，字符序列不可修改，但是可以修改变量，引用其他字符串
    // 编译器可以让字符串共享
    public static void getNewString() {
        String greeting = "Hello";
        greeting = greeting.substring(0, 3) + "p!";
        System.out.println(greeting);
    }


    /**
     * 判断字符串为空
     */
    public static void isEmptyDemo() {
        String s1 = null;   // 表示s1变量没有与任何对象关联
        String s2 = "";
        String s3 = " ";

        // 判断一个字符串为空
        if (s2.length() == 0 || s2.equals("")) {
            System.out.println("s2是一个空串");
        }
        // 判断一个字符串为null
        if (s1 == null) {
            System.out.println("字符串s1没有引用对象");
        }
        // 判断一个字符串不为空且不为null,要先判断不为空
        if (s3 != null && s3.length() != 0) {
            System.out.println("字符串s3");
        }

        System.out.println(s3.length());    // 1
        System.out.println(s2.length());    // 0
//        System.out.println(s1.length());    // NullPointerException

    }
}
