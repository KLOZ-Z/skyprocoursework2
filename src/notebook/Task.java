package notebook;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Task {
    static int ID_BASE = 0;
    private final int id;
    private String header;
    private String describtion;
    private TaskType taskType;
    private RepeatType repeatType;

    private LocalDateTime dateTime;

    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");



    public Task(String header, String describtion, TaskType taskType, RepeatType repeatType){
         this.id = ++ID_BASE;
         this.header = header;
         this.describtion = describtion;
         this.taskType = taskType;
         this.repeatType = repeatType;
         this.dateTime = LocalDateTime.now();
     }



//setters
    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setRepeatType(RepeatType repeatType) {
        this.repeatType = repeatType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

//getters
    public String getHeader() {
        return header;
    }

    public String getDescribtion() {
        return describtion;
    }

    public RepeatType getRepeatType() {
        return repeatType;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Задача: "+this.header+"\nОписание: "+this.describtion+"\nТип: "+this.taskType+"\nПовторяемость: "+this.repeatType+"\nДата: "+this.dateTime.format(timeFormatter)+"\n";
    }
}
