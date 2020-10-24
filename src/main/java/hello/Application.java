package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		SpringApplication.run(Application.class, args);
		//cf();
		ExploreCollection collection = new ExploreCollection();
		/*collection.mapExample();
		collection.filterMapExample();
		collection.forEachExample();*/
		collection.reduceExample();
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