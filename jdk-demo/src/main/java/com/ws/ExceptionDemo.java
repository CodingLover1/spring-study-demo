package com.ws;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author shuo.wang
 * @date 19-9-25
 */
public class ExceptionDemo {

    //ConcurrentModificationException

    public static void main(String[] args) {

        ArrayList<Integer> list=new ArrayList<>();
        list.add(2);
        Iterator<Integer> it=list.iterator();
        while(it.hasNext()){
            Integer  term=it.next();
            if(term==2){
                list.remove(term);
            }
        }
    }
}
