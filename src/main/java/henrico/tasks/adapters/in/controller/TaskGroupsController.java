package henrico.tasks.adapters.in.controller;

import henrico.tasks.application.core.domain.TaskGroup;
import henrico.tasks.application.ports.in.FindAllTaskGroupsInputPort;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task-groups")
public class TaskGroupsController {

    public FindAllTaskGroupsInputPort findAllTaskGroupsInputPort;

    public TaskGroupsController(FindAllTaskGroupsInputPort findAllTaskGroupsInputPort) {
        this.findAllTaskGroupsInputPort = findAllTaskGroupsInputPort;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TaskGroup>> getAllTaskGroups(Integer userId) {
        var listTaskGroups = findAllTaskGroupsInputPort.findAllTaskGroups(userId);
        return ResponseEntity.status(200).body(listTaskGroups);
    }

}
