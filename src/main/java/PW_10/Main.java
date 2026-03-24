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
    }

}
