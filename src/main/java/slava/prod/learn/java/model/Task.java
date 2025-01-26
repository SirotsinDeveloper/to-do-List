package slava.start.spring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Task {
    private UUID id;
    private String taskName;
    private String taskDescription;

    public Task(String taskName, String taskDescription) {
        this.id = UUID.randomUUID();
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    @Override
    public String toString() {
        return  "ID task: \n" + id + "\nTask name: \n" + taskName + ", \nTask description: \n" + taskDescription;
    }
}
