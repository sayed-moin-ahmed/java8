package hello;

import hello.functionalprogramming.ExploreCollection;
import hello.functionalprogramming.LambdaTest;
import hello.functionalprogrammingpatterns.CustomerWriter;
import hello.functionalprogrammingpatterns.FileExporter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
		SpringApplication.run(Application.class, args);
		ExploreCollection collection = new ExploreCollection();
		LambdaTest lt = new LambdaTest();
		collection.test("Hello",lt::show);
		collection.sum(1,2,lt::add);
	}

	private static void cf() {
		CompletableFuture future2 = new CompletableFuture().supplyAsync(()->"is");
		CompletableFuture future3 = new CompletableFuture().supplyAsync(()->"Great");
		CompletableFuture future1 = new CompletableFuture();
		boolean result = fcf.apply(future1).complete("Hello");
		System.out.println(result);
		System.out.println(future1.isDone());
		CompletableFuture.allOf(future1,future2,future3);
		List<Object> str;
		str = Stream.of(future2,future3).map(CompletableFuture::join).collect(Collectors.toList());
		System.out.println(str);
	}

	static Function<String, String> function = String::toUpperCase;
	static Function<Throwable,String> throwableFunction = throwable-> {System.out.println(throwable); return "FAILED" ;};
	static Function <CompletableFuture,CompletableFuture> fcf= cf->cf.thenApply(function).exceptionally(throwableFunction);

}