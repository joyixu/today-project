package mood;

public enum Mood {
    ONE (1),
    TWO (2),
    THREE (3),
    FOUR (4),
    FIVE (5);

    private final int moodLevel;

    Mood (int moodLevel) {
        this.moodLevel = moodLevel;
    }

    private int getMoodLevel() {
        return this.moodLevel;
    }
}
