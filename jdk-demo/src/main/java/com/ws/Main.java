package com.ws;

/**
 * @author shuo.wang
 * @date 19-10-10
 */
public class Main {
    public static void main(String[] args) {
        People p1=new Children();
        People p2=new Audilt();

        if(p1 instanceof Children){
            System.out.println("p1 is childre");
        }

        if(p2 instanceof Children){
            System.out.println("p2 is children");
        }
    }
}
