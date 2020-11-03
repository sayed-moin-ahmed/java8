package sample.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CustomTask {
    private int i=0;
    private final Lock queueLock = new ReentrantLock();
    /**
     *Comment and uncomment lock and unlock method in both the place simultaneously
     * Comment and uncomment lock and unlock in either of the methods.
     */
    public void task1() throws InterruptedException {
        queueLock.lock();
        Thread.sleep(100);
        System.out.println((i++) + " Task1Thread: "+Thread.currentThread().getName());
        queueLock.unlock();
    }

    public void task2() throws InterruptedException {
        //queueLock.lock();
        Thread.sleep(100);
        System.out.println((i++) + " Task2Thread: "+Thread.currentThread().getName());
        //queueLock.unlock();
    }

    public static class LockConcept {
        public static void invoke() {
            final CustomTask task = new CustomTask();

            Runnable runnable1 = new Runnable() {
                @Override
                public void run() {
                    try{
                        task.task1();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            Runnable runnable2 = new Runnable() {
                @Override
                public void run() {
                    try{
                        task.task2();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            int i=100;
            while(i>0){
                Thread t = new Thread(runnable1);
                t.start();
                i--;
            }
            while(100>i){
                Thread t = new Thread(runnable2);
                t.start();
                i++;
            }
        }
    }
}
