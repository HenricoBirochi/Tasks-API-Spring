package henrico.tasks.adapters.in.rest.taskgroup;

import henrico.tasks.application.core.domain.TaskGroup;
import henrico.tasks.application.ports.in.TaskGroupInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task-groups")
public class TaskGroupsController {

    public TaskGroupInputPort taskGroupInputPort;

    public TaskGroupsController(TaskGroupInputPort taskGroupInputPort) {
        this.taskGroupInputPort = taskGroupInputPort;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TaskGroup>> getAllTaskGroups(UUID userId) {
        var listTaskGroups = taskGroupInputPort.findAllTaskGroups(userId);
        return ResponseEntity.status(200).body(listTaskGroups);
    }

}
