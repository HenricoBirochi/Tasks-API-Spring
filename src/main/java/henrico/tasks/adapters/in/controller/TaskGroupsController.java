package henrico.tasks.adapters.in.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import henrico.tasks.application.core.domain.TaskGroup;
import henrico.tasks.application.ports.in.FindAllTaskGroupsInputPort;

@RestController
@RequestMapping("/task-groups")
public class TaskGroupsController {

    public FindAllTaskGroupsInputPort findAllTaskGroupsInputPort;

    public TaskGroupsController(FindAllTaskGroupsInputPort findAllTaskGroupsInputPort) {
        this.findAllTaskGroupsInputPort = findAllTaskGroupsInputPort;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TaskGroup>> getAllTaskGroups(UUID userId) {
        var listTaskGroups = findAllTaskGroupsInputPort.findAllTaskGroups(userId);
        return ResponseEntity.status(200).body(listTaskGroups);
    }

}
