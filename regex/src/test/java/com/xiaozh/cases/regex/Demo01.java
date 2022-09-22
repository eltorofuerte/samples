package com.xiaozh.cases.regex;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则：https://c.runoob.com/front-end/854/?adsd=1212
 *
 * @author zhangxinyu
 * @since 2022/9/21 10:22
 */
public class Demo01 {

    /**
     * 需求：所有小写字母都替换为'？'并且所有空白都被'+'替换
     * <p>
     * 正则表达式[a-z]表示从a到z的字符
     * \s匹配任何空白字符，包括空格、制表符、换页符等等, 等价于[ \f\n\r\t\v],\\s中的第一个\用来转义,+表示匹配多个
     */
    @Test
    public void test01() {
        String str = "I Like Java";
        str = str.replaceAll("[a-z]", "?").replaceAll("\\s+", "+");
        System.out.println(str);

        System.out.println("使用StringBuilder:::");

        StringBuilder sb = new StringBuilder();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (Character.isLowerCase(ch)) {
                sb.append('?');
            } else if (Character.isWhitespace(ch)) {
                sb.append('+');
            } else {
                sb.append(ch);
            }
        }

        // Assign the result to str
        str = sb.toString();

        // Display str
        System.out.println(str);
    }

    /**
     * 需求：
     * 每个单词的第一个字符是一个字母（大写或小写），需要保持原样。
     * 后面的第二个字符可以是任何需要用?替换的单词字符。
     * 字符串的所有空白字符都需要替换为+。
     * <p>
     * https://blog.csdn.net/qq_33539213/article/details/122180733
     * <p>
     * \w指定单词字符。
     * (?<=\p{L})指定字母的正lookbegind，即\p{L}。
     */
    @Test
    public void test02() {
        String str = "I like Java";
        str = str.replaceAll("(?<=\\p{L})\\w", "?").replaceAll("\\s+", "+");
        System.out.println(str);

        System.out.println("使用StringBuilder========");
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i++);
            if (Character.isLetter(ch)) {
                sb.append(ch);
                while (i < len && !Character.isWhitespace(ch = str.charAt(i))) {
                    sb.append('?');
                    i++;
                }
                if (Character.isWhitespace(ch)) {
                    sb.append('+');
                }
            }
        }

        // Assign the result to str
        str = sb.toString();

        // Display str
        System.out.println(str);
    }

    /**
     * Pattern（模式类） ： 用来表达和陈述所要搜索模式的对象。Pattern.compile(pattern) pattern 也就是你写的正则表达式
     * Matcher（匹配器类）：真正影响搜索的对象。上面Pattern.compile(pattern)得到一个Pattern对象 为 r。 r.matcher(line) line也即是你需要进行匹配的字符串
     * ,这样会得到一个 Matcher 的对象。
     * PatternSyntaxException： 当遇到不合法的搜索模式时，会抛出例外
     * <p>
     * Java中需要两个 \\ 反斜杠。表示转义的作用
     */
    @Test
    public void testGroup() {
        // 按指定模式在字符串查找
        String line = "123ra9040 123123aj234 adf12322ad 222jsk22";
        /*
            //d+ 表示最少匹配一个数字
            [a-z]+ 表示最少匹配一个字符
         */
        String pattern = "(\\d+)([a-z]+)(\\d+)";
        // String pattern1 = "([\\u4E00-\\u9FA5]+|\\w+)";
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        int i = 0;
        // m.find 是否找到正则表达式中符合条件的字符串
        while (m.find()) {
            // 拿到上面匹配到的数据
            System.out.println("----i=" + i);
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
            i++;
            System.out.println("|||||||");
            System.out.println("");
        }
    }

    /**
     *    group()方法是针对()来说的,group(0)指的是整个正则表达式,group(1)指的是第一个括号里的东西
     *       正则表达式分组 是从左至右计算其左括号有几个就可以分为几组。编号从1开始
     *       1   ((A)(B(C)))
     *       2    (A)
     *       3    (B(C))
     *       4     (C)
     */
    @Test
    public void testGroup2() {
        Pattern p = Pattern.compile("([a-z]+)(\\d+)");
        Matcher m = p.matcher("aaa2223bb");
        System.out.println(m.find()); // 匹配aaa2223,group(0)是匹配的整个字符串
        System.out.println(m.groupCount()); // 返回2,因为有2组
        System.out.println(m.start(1)); // 返回0 返回第一组匹配到的子字符串在字符串中的索引号
        System.out.println(m.start(2)); // 返回3
        System.out.println(m.end(1)); // 返回3 返回第一组匹配到的子字符串的最后一个字符在字符串中的索引位置.
        System.out.println(m.end(2)); // 返回7
        System.out.println(m.group(1)); // 返回aaa,返回第一组匹配到的子字符串
        System.out.println(m.group(2)); // 返回2223,返回第二组匹配到的子字符串
    }
}
