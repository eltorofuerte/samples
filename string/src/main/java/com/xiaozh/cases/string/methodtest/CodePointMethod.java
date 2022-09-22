package com.xiaozh.cases.string.methodtest;

/* 代码点和代码单元
 */
public class CodePointMethod {
    public static void main(String[] args) {
        /*int[] s = {1,2,3 };
        System.out.println(s);

        char[] c = {'a','b','d','f'};
        System.out.println(c);

        String str = "\ud835\udd46isa增补字符";
        System.out.println(str.codePointCount(0, str.length())); // 8
        for (int i = 0; i <= str.codePointCount(0, str.length());i++ ) {
            int cp = str.codePointAt(i);// 获得该字符串索引位置的代码点值
            if (Character.isSupplementaryCodePoint(cp)) { // 判断是否为增补字符
                System.out.print(Character.toChars(cp));
                i += 2;
            } else {
                System.out.print(Character.toChars(cp));
                i++;
            }

//            i--;
//            if (Character.isSurrogate(str.charAt(i))) {
//                i--;
//            }
//             cp = str.codePointAt(i);
            System.out.println(cp);
        }*/


//        String s = "\ud835\udd46Ƶis the set of integers";
        String s = "\ud835\udd6bi\ud835\udd46s the set of integers";
        System.out.println((char)s.codePointAt(2));
        System.out.println(s);

        System.out.println(Character.isSupplementaryCodePoint(s.codePointAt(0)));
        int i1 = s.offsetByCodePoints(0,0);
        int i2 = s.offsetByCodePoints(0,1);
        int i3 = s.offsetByCodePoints(0,2);
        System.out.println(i1+ ":" + i2 + ":" + i3);

        System.out.println(s.codePointAt(i1) + ":" + new String(Character.toChars(s.codePointAt(i1))));
        System.out.println(s.codePointAt(i2) + ":" + new String(Character.toChars(s.codePointAt(i2))));
        System.out.println(s.codePointAt(i3) + ":" +new String(Character.toChars(s.codePointAt(i3))));
        System.out.println("charAt()");
        System.out.println(s.charAt(i1));
        System.out.println(s.charAt(i2));
        System.out.println(s.charAt(i3));







//        String s2 = "\uD835\uDD6B";
//        System.out.println(s2);
//        System.out.println(s2.charAt(0));
//        System.out.println(s2.charAt(1));
//
//        System.out.println(((char)s2.codePointAt(0)));
//        System.out.println(s2.length()); // 2
//        System.out.println(s2.codePointCount(0,s2.length())); // 1
       /* System.out.println((char)s.codePointAt(0));
        System.out.println((char)s.codePointAt(1));
        System.out.println((char)s.codePointAt(2));
        System.out.println(s.codePointCount(0,s.length()));
        System.out.println(s.length());*/


    }
}
