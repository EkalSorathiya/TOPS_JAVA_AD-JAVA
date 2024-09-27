package com.thread;

class Callback{
    public void call(String mes)
    {
        System.out.print("["+mes);
        try{
            Thread.sleep(1000);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("]");
    }
}
class Caller implements Runnable{
    Thread t;
    Callback c;
    String mes;

    public Caller(Callback c, String mes) {
        this.c = c;
        this.mes = mes;
        t=new Thread((this));
        t.start();
    }

    public void run() {
        synchronized (c){
            c.call(mes);
        }
    }
}
public class ThreadSynchronizationDemo {
    public static void main(String[] args) {
        Callback c=new Callback();
        Caller c1=new Caller(c,"Hello1");
        Caller c2=new Caller(c,"Hello2");
        Caller c3=new Caller(c,"Hello3");
    }
}
