package enums;

import org.junit.Test;

public class ThreadTest {
    @Test
    public void dummy() throws InterruptedException {
        //
        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("Thread running....");
            }
            public int code(){ return 0;}
        };
        // ->> t1.code();
        t1.start();
        Thread mainThread = Thread.currentThread();
        t1.join();
        //
        MyThread t2 = new MyThread();
        t2.code();
        t2.start();
        t2.join();
    }

    @Test
    public void tes2() throws InterruptedException {
        MyThread t1 = new MyThread();
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run() {
                TrafficLight.trafficLight.setColor(Color.GREEN);
            }
        };
        Thread.sleep(1000);
        t2.start();
        t2.join();
        t1.join();
    }

}

class MyThread extends Thread {
    @Override
    public void run() {
        TrafficLight.trafficLight = new TrafficLight();
        TrafficLight.trafficLight.setColor(Color.RED);
    }
    public int code(){ return 0;}
}
