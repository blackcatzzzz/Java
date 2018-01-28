package com.zhangchi.JavaLearning.Container;


import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CopyOnWriteArrayList;

public class JavaContainer {

    private final Integer i = 1;

    JavaContainer(){
        //i = 1;
    }

    public static void testHashMap(){
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");

        // 错误删除方法
// 		java.util.ConcurrentModificationException
//		at java.util.HashMap$HashIterator.nextNode(HashMap.java:1437)
//		at java.util.HashMap$EntryIterator.next(HashMap.java:1471)
//		at java.util.HashMap$EntryIterator.next(HashMap.java:1469)
//		for (Map.Entry<String, String> entry: map.entrySet()){
//			map.remove(entry.getKey());
//		}

        Iterator<String> itKey = map.keySet().iterator();
        while (itKey.hasNext()){
            System.out.println("Key: " + itKey.next());
        }

        Iterator<String> itValue = map.values().iterator();
        while (itValue.hasNext()){
            System.out.println("Value: " + itValue.next());
        }

        // 正确删除
        for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext();){
            Map.Entry<String, String> entry = it.next();
            it.remove();
            System.out.println(entry.getKey() + "," + entry.getValue());
        }

        for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext();){
            Map.Entry<String, String> entry = it.next();
            System.out.println(entry.getKey() + "," + entry.getValue());
        }
    }

    public static void testPriorityQueue() {
        // 默认小根堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(3);
        pq.offer(6);
        pq.offer(7);
        pq.offer(1);
        pq.offer(2);
        pq.offer(4);
        pq.offer(9);
        pq.offer(8);
        pq.offer(5);

        while (!pq.isEmpty())
            System.out.print(pq.poll() + " ");
        System.out.println();

        // 大根堆
        pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        pq.offer(3);
        pq.offer(6);
        pq.offer(7);
        pq.offer(1);
        pq.offer(2);
        pq.offer(4);
        pq.offer(9);
        pq.offer(8);
        pq.offer(5);

        while (!pq.isEmpty())
            System.out.print(pq.poll() + " ");
        System.out.println();
    }

    public static void testByte(){
        byte[] buff = new byte[8192];
        byte[] b = new byte[0];
        System.arraycopy(b, 0, buff, 0, b.length);

    }

    public static void main(String[] args){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(1,0);

        Iterator<Integer> it = linkedList.iterator();
        System.out.print("linkedList: ");
        while(it.hasNext())
            System.out.print(it.next() + " ");
        System.out.println();

        linkedList.remove(0);
        linkedList.add(0, 1);
        System.out.println("index(1), " + linkedList.get(1));

        String s1 = "hello world";
        System.out.print(s1.substring(0, 2));
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("a","b","c","d"));
        // error demo
//        for(String s:list){
//            if(s.equals("a")){
//                list.remove(s);
//            }
//        }
        testHashMap();
        testPriorityQueue();
        testByte();
    }
}


//interface A{
//    void funA();
//}
//
//interface B{
//    void funB();
//}
//
//interface C extends A , B{
//
//}
//
//class D implements C{
//    public void funB(){};
//    public void funA(){};
//}