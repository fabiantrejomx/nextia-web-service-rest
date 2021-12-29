package com.fabian.rest.client.controller;

import com.fabian.rest.client.task.AllTaskResponse;
import com.fabian.rest.client.wsclient.TaskClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
