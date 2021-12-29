package com.fabian.rest.client.controller;

import com.fabian.rest.client.task.AllTaskResponse;
import com.fabian.rest.client.task.DeleteTaskRequest;
import com.fabian.rest.client.task.DeleteTaskResponse;
import com.fabian.rest.client.task.TaskRequest;
import com.fabian.rest.client.task.TaskResponse;
import com.fabian.rest.client.task.UpdateTaskRequest;
import com.fabian.rest.client.task.UpdateTaskResponse;
import com.fabian.rest.client.wsclient.TaskClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskClient taskClient;

    @GetMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AllTaskResponse> getAllTasksByUserId(@PathVariable("userId") final String userId){
        return ResponseEntity.ok(taskClient.getTasksByUserId(userId));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskResponse> create(@RequestBody final TaskRequest request){
        return ResponseEntity.ok(taskClient.create(request));
    }

    @DeleteMapping(value = "/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeleteTaskResponse> delete(@PathVariable("taskId") final String taskId){
        return ResponseEntity.ok(taskClient.delete(taskId));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UpdateTaskResponse> update(@RequestBody final UpdateTaskRequest request){
        return ResponseEntity.ok(taskClient.update(request));
    }


}
