package sample.functionalprogramming;

public class LambdaTest{

    public void show(String msg){
        System.out.println(msg);
    }

    public void add(Integer t, Integer u){
        System.out.println(t+u);
    }

    public String msg(int value){
        return String.format(" Hello %s",value);
    }

}
