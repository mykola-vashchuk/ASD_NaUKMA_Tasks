package PW_10;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class EventLab {
    // функція перевірки умови; підтримує комбінації об'єднання умов: and, or, negate
    public static List<Event> pick(List<Event> events, Predicate<Event> condition) {
        List<Event> result = new ArrayList<>();
        for (Event e : events) {
            if (condition.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    //перетворення одного типу на інший
    public static List<String> labels(List<Event> events, Function<Event, String> mapper) {
        List<String> result = new ArrayList<>();
        for (Event e : events) {
            result.add(mapper.apply(e));
        }
        return result;
    }

    // виконання події з побоічним ефектом
    // споживач: отримує значення і виконує дію з логом збереженням і тд
    public static void notifyAll(List<Event> events, Consumer<Event> action) {
        for (Event e : events) {
            action.accept(e);
        }
    }

    // відкладене створення; нічого не приймає але повертає значення
    public static Event create(Supplier<Event> factory) {
        return factory.get();
    }

    // перевірка часових перетинів
    // потрібно оскільки 9 ранку в різних часових поясах це різний час, перевіряє перетин двох інтервалів
    public static List<Event[]> findConflicts(List<Event> events) {
        List<Event[]> conflicts = new ArrayList<>();
        for (int i = 0; i < events.size(); i++) {
            for (int j = i + 1; j < events.size(); j++) {
                Event e1 = events.get(i);
                Event e2 = events.get(j);
                // конверція в аабсолютний час
                Instant start1 = e1.getStart().atZone(e1.getZone()).toInstant();
                Instant end1 = e1.end().atZone(e1.getZone()).toInstant();
                Instant start2 = e2.getStart().atZone(e2.getZone()).toInstant();
                Instant end2 = e2.end().atZone(e2.getZone()).toInstant();

                if (start1.isBefore(end2) && start2.isBefore(end1)) { // стартА < ендБ та стартБ < ендА
                    conflicts.add(new Event[]{e1, e2});
                }
            }
        }
        return conflicts;
    }
}
