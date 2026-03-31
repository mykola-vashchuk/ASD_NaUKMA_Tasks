package PW_11;

import java.util.*;
import java.util.stream.Collectors;

// basic data models
record Book(String title, String author, int year, List<String> tags) {}
record Sale(String customerEmail, String product, int cents) {}

// hierarchy for task 4
sealed interface Result permits Success, Failure {}
record Success(String data) implements Result {}
record Failure(String message) implements Result {}

public class Main {
    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book("Clean Code", "Robert Martin", 2008, List.of("clean", "practice", "java")),
                new Book("Effective Java", "Joshua Bloch", 2018, List.of("java", "best", "api")),
                new Book("Modern Java", "Nicolai Parlog", 2020, List.of("java", "streams", "records")),
                new Book("Java Concurrency", "Brian Goetz", 2006, List.of("concurrency", "java"))
        );

        List<Sale> sales = List.of(
                new Sale("a@ex.com", "Tea", 120),
                new Sale("b@ex.com", "Cake", 200),
                new Sale("a@ex.com", "Tea", 120),
                new Sale("c@ex.com", "Coffee", 150),
                new Sale("b@ex.com", "Cake", 200)
        );

        List<Result> results = List.of(
                new Success("data loaded"),
                new Failure("connection timeout"),
                new Success("processing finished")
        );

        // task 1: stream pipeline on books
        // filtering books published after 2015, converting titles to uppercase, sorting alphabetically, and limiting to top 3
        List<String> topRecentBooks = books.stream()
                .filter(b -> b.year() > 2015)
                .map(b -> b.title().toUpperCase())
                .sorted()
                .limit(3)
                .toList();
        System.out.println("\ntask 1 - top recent books: " + topRecentBooks);

        // task 2: flatmap and distinct for tags
        // step 1: flattening nested tag lists into a single stream, removing duplicates, and sorting naturally
        List<String> uniqueSortedTags = books.stream()
                .flatMap(b -> b.tags().stream())
                .distinct()
                .sorted()
                .toList();
        System.out.println("\ntask 2 - unique sorted tags: " + uniqueSortedTags);

        // step 2: grouping tags and counting their occurrences to build a frequency map
        Map<String, Long> tagFrequency = books.stream()
                .flatMap(b -> b.tags().stream())
                .collect(Collectors.groupingBy(t -> t, Collectors.counting())); // collect objects in map, where the key is object itself, and he value is the number of its occurrences
        System.out.println("task 2 - tag frequency: " + tagFrequency);

        // step 3: sorting map entries by value descending, then by key alphabetically, and extracting top 5 keys
        List<String> topTags = tagFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("task 2 - top " + 5 + " tags: " + topTags);

        // task 3: collectors on sales
        // summing up revenue per product using toMap collector with a merge function for duplicate keys
        Map<String, Integer> revenueByProduct = sales.stream()
                .collect(Collectors.toMap(
                        Sale::product,
                        Sale::cents,
                        Integer::sum
                ));
        System.out.println("\ntask 3 - revenue by product (cents): " + revenueByProduct);

        // counting total transactions per customer using groupingBy collector
        Map<String, Long> transactionsByCustomer = sales.stream()
                .collect(Collectors.groupingBy(
                        Sale::customerEmail,
                        Collectors.counting()
                ));
        System.out.println("task 3 - transactions by customer: " + transactionsByCustomer);

        // task 4: record and sealed result processing
        // counting instances of success using pattern matching
        long successCount = results.stream()
                .filter(r -> r instanceof Success)
                .count();
        System.out.println("\ntask 4 - success count: " + successCount);

        // counting instances of failure
        long failureCount = results.stream()
                .filter(r -> r instanceof Failure)
                .count();
        System.out.println("task 4 - failure count: " + failureCount);

        // extracting error messages from failure instances
        List<String> failureMessages = results.stream()
                .filter(r -> r instanceof Failure)
                .map(r -> ((Failure) r).message())
                .toList();
        System.out.println("task 4 - failure messages: " + failureMessages);
    }
}