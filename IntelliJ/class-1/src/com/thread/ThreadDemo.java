package com.thread;

class NewThread implements Runnable{
    Thread t;
    public NewThread() {
        t=new Thread(this,"Child Thread");
        t.start();}
    public void run() {
        try {
            for(int i=0;i<5;i++){
                System.out.println(t+" "+i);
                Thread.sleep(2000);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("Child Thread Exiting");


    }
}
public class ThreadDemo {
    public static void main(String[] args) {
        new NewThread();
        Thread t=Thread.currentThread();
        System.out.println(t);
        t.setName("My Thread");
        System.out.println(t);
        t.setPriority(8);
        System.out.println(t);
        try {
            for(int i=0;i<5;i++){
                System.out.println(t+" "+i);
                Thread.sleep(1000);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("My Thread Exiting");
    }
}
