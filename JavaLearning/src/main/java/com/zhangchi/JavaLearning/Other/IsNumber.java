package com.zhangchi.JavaLearning.Other;

/**
 * 判断字符串是否为数字
 * @author Chi Zhang
 * @date 2018/1/24
 */
public class IsNumber {
    public static boolean isNumber(String s) {
		for (int i = 0; i < s.length(); ++i)
			if (!isDigit(s.charAt(i)))
				return false;
		return true;
	}

	public static boolean isDigit(char c ) {
		if (c < '0' || c > '9')
			return false;
		return true;
	}

    public static void main(String[] args) {
        String s = new String("123");
        StringBuilder sb = new StringBuilder();
        sb.append("123");
        s += "aaa";
        String.valueOf(6);
        Integer i ;
        int j = 5;
        i = 5;
        System.out.println(isNumber("-123456"));
        Integer.valueOf("A", 16);
        String s1 = "123" + 5.0;
        String s2 = "1235.0";
        System.out.println(s1 == s2); // true
    }
}
