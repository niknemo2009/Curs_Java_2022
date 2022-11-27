package user_def_type.meeting;

import java.time.LocalDateTime;

public abstract  class Event implements Comparable<Event>{
    LocalDateTime startPoint;
    int durationPerMinutes;
    String topic;
}
