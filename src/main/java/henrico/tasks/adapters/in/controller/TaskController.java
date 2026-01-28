package henrico.tasks.adapters.in.controller;

import henrico.tasks.application.core.domain.Task;
import henrico.tasks.application.ports.in.task.FindAllTasksFromTaskGroupInputPort;
import henrico.tasks.application.ports.in.task.InsertTaskInputPort;
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

    public FindAllTasksFromTaskGroupInputPort findAllTasksFromTaskGroupInputPort;
    public InsertTaskInputPort insertTaskInputPort;

    public TaskController(
            InsertTaskInputPort insertTaskInputPort,
            FindAllTasksFromTaskGroupInputPort findAllTasksFromTaskGroupInputPort
    ) {
        this.insertTaskInputPort = insertTaskInputPort;
        this.findAllTasksFromTaskGroupInputPort = findAllTasksFromTaskGroupInputPort;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTasks(UUID taskGroupId) {
        var allTasks = findAllTasksFromTaskGroupInputPort.findAllTasks(taskGroupId);
        return ResponseEntity.status(200).body(allTasks);
    }

    @PostMapping("/")
    public ResponseEntity<Void> insertTask(Task task) {
        insertTaskInputPort.insertTask(task);
        return ResponseEntity.status(201).build();
    }

}
