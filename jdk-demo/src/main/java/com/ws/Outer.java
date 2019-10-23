package com.ws;

/**
 * @author shuo.wang
 * @date 19-9-25
 */
public class Outer {

    private String name="outer";

    private class Inner{
        private String name="inner";

        public void print(){
            System.out.println(Outer.this.name+" "+this.name);
        }
    }

}
