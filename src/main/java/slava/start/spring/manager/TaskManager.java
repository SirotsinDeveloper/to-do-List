package slava.start.spring.manager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import slava.start.spring.model.Task;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class TaskManager {
    private static final File PATH_FILE = new File("C:\\Users\\slava\\IdeaProjects\\task-manager\\src\\main\\java\\slava\\start\\spring\\file\\save\\taskSave.json");
    private List<Task> tasks;
    private Scanner scanner;
    private ObjectMapper mapper;

    public void addTask() {
        System.out.println("Please enter a task name: ");
        String taskName = scanner.nextLine();
        System.out.println("Please enter the description of the task you would like to add: ");
        String description = scanner.nextLine();
        tasks.add(new Task(taskName, description));
    }

    public void deleteTask() {
        System.out.println("Введите номер задачи, которую хотите удалить: ");
        int number = scanner.nextInt();
        if (number >= 0 && number < tasks.size()) {
            tasks.remove(number);
            System.out.println("Задача успешно удалена.");
        } else {
            System.out.println("Неверный номер задачи.");
        }
        scanner.nextLine(); // Потребление символа новой строки
    }

    public void displayTasks() {
        for (Object task : tasks) {
            System.out.println(task);
        }
    }

    public void saveTasks() {
        try {
            mapper.writeValue(PATH_FILE, tasks);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Не удалось сохранить задачи.");
        }
    }

    public void loadTasks() {
        try {
            tasks = mapper.readValue(PATH_FILE, new TypeReference<>() {});
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Не удалось загрузить задачи.");
        }
    }
}
