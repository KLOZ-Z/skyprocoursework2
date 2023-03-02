import notebook.RepeatType;
import notebook.Task;
import notebook.TaskType;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Main {



        public static void printMenu(String[] options){
            for (String option : options){
                System.out.println(option);
            }
            System.out.print("Choose your option : ");
        }
        public static void main(String[] args) {




            String[] options = {"1- Добавить задачу",
                    "2- Получить список всех задач",
                    "3- Удалить задачу по id",
                    "4- Получить задачи на день",
                    "5- Exit",
            };
            Scanner scanner = new Scanner(System.in);
            int option=1;
            while (option!=5){
                printMenu(options);
                    option = scanner.nextInt();
                    switch (option){
                        case 1: Service.create(); break;
                        case 2: Service.showAllTasks(); break;
                        case 3: Service.delete(); break;
                        case 4: Service.getAllByDate();  break;
                        case 5: System.out.println("Выполняется выход из программы"); break;

                }
        }
    }




}


