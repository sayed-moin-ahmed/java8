package hello;

import hello.locks.CustomTask;

public class LockConcept {
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
