package hello.autocloseable;

public class Application {
    public static void main(String[] args){
        System.out.println("autocloaseable Application");
        try(MyResource mr = new MyResource()){
            System.out.println(mr.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
