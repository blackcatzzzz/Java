package com.zhangchi.JavaLearning.IO;

import java.io.*;

/**
 * @author Chi Zhang
 * @date 2018/2/2
 */
public class DataStreamTest {
    public static void main(String args[])throws IOException {

        DataInputStream in = new DataInputStream(new FileInputStream("DataStream.txt"));
        DataOutputStream out = new DataOutputStream(new  FileOutputStream("DataStream1.txt"));
        BufferedReader d  = new BufferedReader(new InputStreamReader(in));

        String count;
        while((count = d.readLine()) != null){
            String u = count.toUpperCase();
            System.out.println(u);
            out.writeBytes(u + "  ,");
        }
        d.close();
        out.close();
    }
}
