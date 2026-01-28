package henrico.tasks.adapters.in.controller;

import henrico.tasks.application.core.domain.Task;
import henrico.tasks.application.ports.in.InsertTaskInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

    public InsertTaskInputPort insertTaskInputPort;

    public TaskController(InsertTaskInputPort insertTaskInputPort) {
        this.insertTaskInputPort = insertTaskInputPort;
    }

    @PostMapping("/")
    public ResponseEntity<Void> insertTask(Task task) {
        insertTaskInputPort.insertTask(task);
        return ResponseEntity.status(201).build();
    }

}
