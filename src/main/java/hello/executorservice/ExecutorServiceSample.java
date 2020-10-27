package hello.executorservice;

import hello.reactivestream.Customer;
import hello.reactivestream.GreetingWebClient;
import hello.reactivestream.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.lang.Thread.sleep;

public class ExecutorServiceSample {

    public static void process(CompletableFuture<Integer> future){
        future
                .exceptionally(throwable -> {throw new RuntimeException("blown");})
                .thenApply(data->data * 2)
                .thenApply(data->data + 1)
                .thenAccept(System.out::println)
        .exceptionally(throwable ->{System.out.println(throwable.getMessage());return null;})
        ;
    }

    public  void esSample1() {
        ExecutorService service = Executors.newCachedThreadPool();
        ExecutorService service1 = Executors.newFixedThreadPool(2);
        while (true) {
            CompletableFuture.supplyAsync(() -> getOrder(), service)
                    .thenApplyAsync(order -> enrich(order), service1)
                    .thenAccept(System.out::println)
                    .thenRun(System.out::println);
            ;
        }
    }

    private Order enrich(Order order) {
        return order.setEnrich(order.getId());
    }

    private  Order getOrder() {
        return new Order(new Random().nextInt());
    }

    private  void executorService() {
        ExecutorService  service = Executors.newCachedThreadPool();
        while(true) {
            Future<Customer> result = service.submit(new Task());
            try {
                System.out.println(result.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    private  void reactive() {
        GreetingWebClient gwc = new GreetingWebClient();
        System.out.println(gwc.getResult());
    }

    public CompletableFuture<Integer> create() {
        return CompletableFuture.supplyAsync(()-> compute());
    }

    public Consumer consumer = data->{
        System.out.println(data);
        System.out.println("Consumer:"+Thread.currentThread().getName());
    };

    public Runnable runnable = System.out::println;
    public Function fn = data -> {
        System.out.println(data);
        return data;
    };
    private int compute() {
        System.out.println("Thread::"+Thread.currentThread().getName());
        return 2;
    }

    class Task implements Callable<Customer>{

        @Override
        public Customer call() throws Exception {
            return new Customer();
        }
    }

    public static List<Customer> getCustomers(){
        List<Customer> list = new ArrayList<>();
        list.add(new Customer());
        list.add(new Customer());
        return list;
    }

    public static void test() throws InterruptedException {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        //future.completeOnTimeout(500,3 ,TimeUnit.SECONDS);
        future.orTimeout(3, TimeUnit.SECONDS);
        ExecutorServiceSample ess = new ExecutorServiceSample();
        ess.process(future);
        sleep(2000);
        future.complete(2);
        sleep(5000);
    }
}