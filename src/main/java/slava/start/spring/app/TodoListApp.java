package slava.start.spring.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import slava.start.spring.manager.TaskManager;
import slava.start.spring.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoListApp {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager(tasks, scanner, objectMapper);

        boolean running = true;
        while (running) {
            System.out.println("Choice you're looking for: ");
            System.out.println("1. Create new task");
            System.out.println("2. Delete task");
            System.out.println("3. Show all tasks");
            System.out.println("4. Save task");
            System.out.println("5. Load task");
            System.out.println("6. Exit program");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Пропустить новую строку после nextInt()

                switch (choice) {
                    case 1:
                        taskManager.addTask();
                        break;
                    case 2:
                        taskManager.deleteTask();
                        break;
                    case 3:
                        taskManager.displayTasks();
                        break;
                    case 4:
                        taskManager.saveTasks();
                        break;
                    case 5:
                        taskManager.loadTasks();
                        break;
                    case 6:
                        running = false; // Прерывание цикла
                        System.out.println("Программа завершена.");
                        break;
                    default:
                        System.out.println("Ваш выбор некорректен");
                        break;
                }
            } else {
                System.out.println("Пожалуйста, введите число.");
                scanner.next(); // Пропустить некорректный ввод
            }
        }
        scanner.close();
    }
}
