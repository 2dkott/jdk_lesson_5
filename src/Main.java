import java.security.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
        MonkFeeder monkFeeder = new MonkFeeder();
        List<Runnable> tasks = new ArrayList<>();
        tasks.add(new Monk(monkFeeder));
        tasks.add(new Monk(monkFeeder));
        tasks.add(new Monk(monkFeeder));
        tasks.add(new Monk(monkFeeder));
        tasks.add(new Monk(monkFeeder));

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        tasks.forEach(executorService::submit);
        //executorService.invokeAll(tasks);
        executorService.shutdown();
    }
}