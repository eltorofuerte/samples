package com.xiaozh.cases.string.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 元字符：
 *  .   匹配除换行符以外的任意字符
 *  \w  匹配字母或数字或下划线或汉字
 *  \s  匹配任意空白字符
 *  \d  匹配数字
 *  \b  匹配单词的开始或结束
 *  ^   匹配字符串的开始或结束
 *  $   匹配字符串的结束
 */
public class RegexDemo {
    public static void main(String[] args) {
        String regex = "^b+";
        regex = "[0-9][2-4]";
        String r2 = "^((ab))+$";
        String s =  "(ab)(ab)";

        // 手机号
        String regex2 = "^(130|131|132|155|156|185|186|145|176)\\d{8}$";
        regex2 = "^((13[0-2])|(15[5-6]))\\d{8}$";
//        System.out.println(s.matches(regex));
//        System.out.println("13164319859".matches(regex2));
        System.out.println("85".matches(regex)); // false


        System.out.println("a".matches(".")); // true

        /**
         * 匹配前面的字符
         */
        String regex3 = ".+(?=12)";
        Pattern p = Pattern.compile(regex3);
       Matcher m =  p.matcher("afdsaf12");
       while(m.find()) {
           System.out.println(m.group());
       }
    }
}
