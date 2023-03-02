import notebook.RepeatType;
import notebook.Task;
import notebook.TaskType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Service {
    public static Map<Integer, Task> Tasks = new HashMap<>();

    public static void create(){
        System.out.println("Создание задачи");
        String header="";
        String describtion="";
        TaskType taskType;
        RepeatType repeatType;
        int k=0;
        Scanner scanner = new Scanner(System.in);
        while (header.isEmpty()) {
            System.out.println("Введите название задачи:");
            header = scanner.nextLine();
        }
        while (describtion.isEmpty()) {
            System.out.print("Введите описание задачи: ");
            describtion = scanner.nextLine();
        }

        do {
            System.out.print("Введите повторяемости задачи: " +
                    "\n1- однократная,\n" +
                    "2- ежедневная,\n" +
                    "3- еженедельная,\n" +
                    "4- ежемесячная,\n" +
                    "5- ежегодная.\n");
            while (!scanner.hasNextInt()) {
                System.out.println("Введите число!");
                scanner.next();
            }
            k= scanner.nextInt();
        } while (k<1);
        switch (k){
            case 1:
                repeatType = RepeatType.SINGLE;
                break;
            case 2:
                repeatType = RepeatType.DAILY;
                break;
            case 3:
                repeatType = RepeatType.WEEKLY;
                break;
            case 4:
                repeatType = RepeatType.MONTHLY;
                break;
            case 5:
                repeatType = RepeatType.ANNUAL;
                break;
            default:
                repeatType = RepeatType.SINGLE;
                break;
        }


        do {
            System.out.print("Введите тип задачи:\n"+"1-Личная\n"+"2-Рабочая\n");
            while (!scanner.hasNextInt()) {
                System.out.println("Введите число!");
                scanner.next();
            }
            System.out.print("Введите тип задачи:\n"+"1-Личная\n"+"2-Рабочая\n");
            k= scanner.nextInt();
        } while (k == 0);
        switch (k){
            case 1:
                taskType = TaskType.PERSONAL;
                break;
            case 2:
                taskType = TaskType.WORK;
                break;
            default:
                taskType = TaskType.PERSONAL;
                break;
        }
        Task task = new Task(header,describtion,taskType,repeatType);
        Tasks.put(task.getId(),task);
        System.out.println("Задача добавлена");
    }

    public static void showAllTasks(){
        updateTasks();
        for (Task task:Tasks.values()) {
            System.out.println(task.toString());
        }
    }

    public static void getAllByDate(){
        LocalDate today = LocalDate.now();
        updateTasks();
        for (Task task:Tasks.values()) {
            if(today.isEqual(task.getDateTime().toLocalDate())){
                System.out.println(task.toString());
            };
        }
    }

    public static void updateTasks(){
        LocalDateTime date = LocalDateTime.now();
        LocalDate today = LocalDate.now();
        for (Task task:Tasks.values()) {

            switch (task.getRepeatType()){
                case SINGLE:
                    if (date.truncatedTo(ChronoUnit.HOURS).isAfter(task.getDateTime().truncatedTo(ChronoUnit.HOURS))){
                        del(task.getId());
                    }
                    break;
                case DAILY:
                    if (date.truncatedTo(ChronoUnit.HOURS).isAfter(task.getDateTime().truncatedTo(ChronoUnit.HOURS))){
                        task.setDateTime(task.getDateTime().plusDays(1));
                    }
                    break;
                case WEEKLY:
                    if (date.truncatedTo(ChronoUnit.DAYS).isAfter(task.getDateTime().truncatedTo(ChronoUnit.DAYS))){
                        task.setDateTime(task.getDateTime().plusDays(7));
                    }
                    break;
                case MONTHLY:
                    if (date.truncatedTo(ChronoUnit.DAYS).isAfter(task.getDateTime().truncatedTo(ChronoUnit.DAYS))){
                        task.setDateTime(task.getDateTime().plusMonths(1));
                    }
                    break;
                case ANNUAL:
                    if (date.truncatedTo(ChronoUnit.DAYS).isAfter(task.getDateTime().truncatedTo(ChronoUnit.DAYS))){
                        task.setDateTime(task.getDateTime().plusMonths(12));
                    }
                    break;
            }
        }
    }

    public static void delete(){
        int k = 0;
        System.out.println("Введите id удаляемой задачи:");
        Scanner scanner = new Scanner(System.in);
        k = scanner.nextInt();
        if (Tasks.containsKey(k)) {
            Tasks.remove(k);
            System.out.println("Задача "+k+" удалена");
        } else {
            System.out.println("Задача не найден");
        }
    }
    public static void del(int k){
        Tasks.remove(k);
    }
}
