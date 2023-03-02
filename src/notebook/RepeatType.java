package notebook;

public enum RepeatType {
    SINGLE("однократная"),
    DAILY("ежедневная"),
    WEEKLY("еженедельная"),
    MONTHLY("ежемесячная"),
    ANNUAL("ежегодная");

    private String type;

    RepeatType(String type){this.type=type;}

    @Override
    public String toString() {
        return this.type;
    }
}
