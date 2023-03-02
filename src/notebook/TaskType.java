package notebook;

public enum TaskType {
    WORK("Рабочая"),
    PERSONAL("Личная");

    private String type;

    TaskType(String type){this.type=type;}

    @Override
    public String toString() {
        return this.type;
    }
}
