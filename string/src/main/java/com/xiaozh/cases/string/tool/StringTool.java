package com.xiaozh.cases.string.tool;

/**
 * String's some function
 */
public class StringTool {

    /**
     * 是否是对称字符串
     *
     * @param str
     * @return
     */
    public static boolean isSymmetry(String str) {
        return new StringBuffer(str).reverse().toString().equals(str);
        /*
        boolean isSymmetry = true;
        char[] charArray = str.toCharArray();
        for (int start = 0, end = charArray.length - 1; start < end; start++, end--) {
            if(charArray[start] != charArray[end]) {
                isSymmetry = false;
                break;
            }
        }
        return isSymmetry;
        */
    }

    /**
     * 字符数组转成字符串
     */
    public static String charArrayToString(char[] ch) {
        // 使用StringBuffer拼接
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < ch.length; i++) {
            if (i == ch.length - 1) {
                sb.append(ch[i]).append("]");
            } else {
                sb.append(ch[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 字符串字串的次数
     *
     * @param
     * @return
     */
    public static int getSubStringCount(String str, String subStr) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(subStr)) != -1) {
            count++;
            str = str.substring(index + subStr.length());
        }
        return count;
    }

    /**
     * 打印数组
     *
     * @param obj
     */
    public static void printlnArray(Object[] obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < obj.length; i++) {
            if (i == obj.length - 1) {
                sb.append(obj[i]).append("]");
            } else {
                sb.append(obj[i]).append(",");
            }
        }

        System.out.println(sb.toString());

    }
}
