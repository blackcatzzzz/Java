package com.zhangchi.JavaLearning.Container;

/**
 * 常量池验证
 */
public class ConstPool {

    /**
     * test3
     * JDK1.6以及以下：false false
     * JDK1.7以及以上：false true
     */
    public static void test3(){
        // test3
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);    // false

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);   // true
    }

    /**
     * test1,test2可做对比
     */
    public static void test2(){
        String str2 = "SEUCalvin";  // 常量池中创建了"SEUCalvin",str2引用之
        String str1 = new String("SEU")+ new String("Calvin");  // 堆中创建str1
        System.out.println(str1.intern() == str1);  // false， str1.intern()发现常量池中存在"SEUCalvin"，无需创建，直接返回常量池中"SEUCalvin"的引用
        System.out.println(str1 == "SEUCalvin");    // false， 显然不等，str1指向堆中，"SEUCalvin"指向常量池中的对象
        System.out.println(str1.intern() == str2);  // true， str1.intern()发现常量池中存在"SEUCalvin"，无需创建，直接返回常量池中"SEUCalvin"的引用，而str2也是指向常量池中"SEUCalvin"
        String s3 = new String("SEU");
        System.out.println(s3.intern() == "SEU");
    }

    public static void test1(){
        String str1 = new String("SEU")+ new String("Calvin");
        System.out.println(str1.intern() == str1);  // true
        System.out.println(str1 == "SEUCalvin");    // true
    }

    // JDK 1.8
    public static void main(String[] args) {

        // test1,test2不要同时运行
        //test1();
        test2();
        //test3();

    }
}
