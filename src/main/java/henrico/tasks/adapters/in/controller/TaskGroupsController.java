package henrico.tasks.adapters.in.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import henrico.tasks.application.core.domain.TaskGroup;
import henrico.tasks.application.ports.in.TaskGroupInputPort;

@RestController
@RequestMapping("/task-groups")
public class TaskGroupsController {

    public TaskGroupInputPort taskGroupInputPort;

    public TaskGroupsController(TaskGroupInputPort taskGroupInputPort) {
        this.taskGroupInputPort = taskGroupInputPort;
    }

    @PostMapping("/")
    public ResponseEntity<TaskGroup> postTaskGroup(@RequestParam TaskGroup taskGroup) {
        var taskGroupResponse = taskGroupInputPort.insertTaskGroup(taskGroup);
        return ResponseEntity.status(201).body(taskGroupResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TaskGroup>> getAllTaskGroups(UUID userId) {
        var listTaskGroups = taskGroupInputPort.findAllTaskGroups(userId);
        return ResponseEntity.status(200).body(listTaskGroups);
    }

    @GetMapping("/")
    public ResponseEntity<TaskGroup> getTaskGroup(UUID taskGroupId) {
        var taskGorupResponse = taskGroupInputPort.findTaskGroupById(taskGroupId);
        return ResponseEntity.ok(taskGorupResponse);
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteTaskGroup(UUID taskGroupId) {
        taskGroupInputPort.deleteTaskGroup(taskGroupId);
        return ResponseEntity.status(204).build();
    }

}
