package com.ws;

import java.util.Scanner;

/**
 * @author shuo.wang
 * @date 19-9-27
 */
public class ProcessDemo {

    public static void main(String[] args) throws Exception{
        Thread.sleep(20000);
        ProcessBuilder pb = new ProcessBuilder("java", "-cp /home/shuowang/IdeaProject/study-demo/jdk-demo/src/main/java","com.ws.ProcessDemo2");
        Process process = pb.start();
        Scanner scanner = new Scanner(process.getInputStream());
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        Thread.sleep(20000);
        scanner.close();
    }
}
