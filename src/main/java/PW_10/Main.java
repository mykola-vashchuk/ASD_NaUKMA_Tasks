package PW_10;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Event> events = new ArrayList<>();
        events.add(new Event("Event 1", LocalDateTime.of(2026, 3, 25, 10, 0), 90, ZoneId.of("Europe/Kyiv"), "Backend"));
        events.add(new Event("Event 2", LocalDateTime.of(2026, 3, 25, 11, 0), 120, ZoneId.of("Europe/Kyiv"), "Backend"));
        events.add(new Event("Event 3", LocalDateTime.of(2026, 3, 25, 14, 0), 60, ZoneId.of("Europe/Kyiv"), "Frontend"));
        events.add(new Event("Event 4", LocalDateTime.of(2026, 3, 25, 9, 0), 45, ZoneId.of("Europe/London"), "DevOps"));

        System.out.println("\n--- Task 1-2: Functions ---");
        EventLab.notifyAll(events, System.out::println);
        /**
        Task 2
         */
        // до 12:00
        Predicate<Event> isMorning = e -> e.getStart().getHour() < 12;
        // трек Backend
        Predicate<Event> isBackend = e -> e.getTrack().equals("Backend");
        // Композиція предикатів
        Predicate<Event> morningBackend = isMorning.and(isBackend);
        // використання predicate
        List<Event> filtered = EventLab.pick(events, morningBackend);
        // використання function
        List<String> labels = EventLab.labels(filtered, Event::label);
        // використання consumer
        EventLab.notifyAll(filtered, e -> System.out.println("Notification: " + e.label()));
        // конфлікти
        List<Event[]> conflicts = EventLab.findConflicts(events);

        for (Event[] pair : conflicts) {
            System.out.println(pair[0].getTitle() + " перетинається з " + pair[1].getTitle());
        }

        /**
         * Task 3
         */
        System.out.println("\n--- Task 3: Sorting ---");
        LambdaRefactorLab.sortAnonymous(events);
        LambdaRefactorLab.sortLambda(events);
        LambdaRefactorLab.sortMethodRef(events);
        EventLab.notifyAll(events, e -> System.out.println("Sorted: " + e.getTitle()));
        /**
         * Task 4
         */
        System.out.println("\n--- Task 4: Java Time ---");
        Event firstEvent = events.get(0);
        Event secondEvent = events.get(1);
        System.out.println("Instant (" + firstEvent.getTitle() + "): " + DateTimeLab.toInstant(firstEvent));
        long diffMinutes = DateTimeLab.minutesBetween(firstEvent, secondEvent);
        System.out.println("Difference between " + firstEvent.getTitle() + " and " + secondEvent.getTitle() + ": " + diffMinutes + " min");
        System.out.println("Start time of " + firstEvent.getTitle() + " in New York: " + DateTimeLab.startInZone(firstEvent, "America/New_York"));
    }
}
