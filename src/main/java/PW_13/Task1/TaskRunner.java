package PW_13.Task1;

import java.util.List;

public class TaskRunner {
    public static void runAndWait(List<Runnable> tasks) {
        List<Thread> threads = tasks.stream().map(Thread::new).toList();
        threads.forEach(Thread::start);
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }
}
