package PW_10;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Event {
    private final String title;
    private final LocalDateTime start;
    private final int durationMinutes;
    private final ZoneId zone;
    private final String track;

    public Event(String title, LocalDateTime start, int durationMinutes, ZoneId zone, String track) {
        this.title = title;
        this.start = start;
        this.durationMinutes = durationMinutes;
        this.zone = zone;
        this.track = track;
    }

    public LocalDateTime end() {
        return start.plusMinutes(durationMinutes);
    }

    public String label() {
        return title + " (" + track + ")";
    }

    public LocalDateTime getStart() { return start; }
    public ZoneId getZone() { return zone; }
    public String getTrack() { return track; }
    public int getDurationMinutes() { return durationMinutes; }
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", start=" + start +
                ", durationMinutes=" + durationMinutes +
                ", zone=" + zone +
                ", track='" + track + '\'' +
                '}';
    }
}
