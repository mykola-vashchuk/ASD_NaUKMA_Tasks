package PW_10;

import java.util.Comparator;
import java.util.List;

public class LambdaRefactorLab {

    // Сортування через анонімний клас
    public static void sortAnonymous(List<Event> events) {
        events.sort(new Comparator<Event>() {
            @Override
            public int compare(Event e1, Event e2) {
                return e1.getTitle().compareTo(e2.getTitle());
            }
        });
    }

    // Сортування через лямбда-вираз
    public static void sortLambda(List<Event> events) {
        events.sort((e1, e2) -> e1.getTitle().compareTo(e2.getTitle()));
    }

    // Сортування через method reference
    public static void sortMethodRef(List<Event> events) {
        events.sort(Comparator.comparing(Event::getTitle));
    }
}
