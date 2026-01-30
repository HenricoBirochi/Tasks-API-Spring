package henrico.tasks.adapters.in.rest.task;

import henrico.tasks.application.core.domain.Task;
import henrico.tasks.application.ports.in.TaskInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
public class TaskController {

    public TaskInputPort taskInputPort;

    public TaskController(TaskInputPort taskInputPort) {
        this.taskInputPort = taskInputPort;
    }

    @PostMapping("/")
    public ResponseEntity<Task> insertTask(Task task) {
        var taskResponse = taskInputPort.insertTask(task);
        return ResponseEntity.status(201).body(taskResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTasks(UUID taskGroupId) {
        var allTasks = taskInputPort.findAllTasks(taskGroupId);
        return ResponseEntity.status(200).body(allTasks);
    }

    @GetMapping("/")
    public ResponseEntity<Task> getTask(UUID taskId) {
        var taskResponse = taskInputPort.findTaskById(taskId);
        return ResponseEntity.status(200).body(taskResponse);
    }

}
