package PW_10;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeLab {

    // перетворення LocalDateTime у прив'язці до ZoneId на Instant (абсолютний час)
    public static Instant toInstant(Event e) {
        return e.getStart().atZone(e.getZone()).toInstant();
    }

    // обчислення різниці в хвилинах між двома подіями через Duration
    public static long minutesBetween(Event a, Event b) {
        Instant instantA = toInstant(a);
        Instant instantB = toInstant(b);
        // використання abs гарантує додатне значення незалежно від порядку переданих подій
        return Duration.between(instantA, instantB).abs().toMinutes();
    }

    // перетворення часу події на інший часовий пояс
    public static ZonedDateTime startInZone(Event e, String targetZone) {
        Instant instant = toInstant(e);
        return instant.atZone(ZoneId.of(targetZone));
    }
}
