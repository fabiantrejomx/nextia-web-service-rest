package com.fabian.rest.client.wsclient;

import com.fabian.rest.client.security.SecurityHelper;
import com.fabian.rest.client.task.AllTaskRequest;
import com.fabian.rest.client.task.AllTaskResponse;
import com.fabian.rest.client.task.DeleteTaskRequest;
import com.fabian.rest.client.task.DeleteTaskResponse;
import com.fabian.rest.client.task.TaskRequest;
import com.fabian.rest.client.task.TaskResponse;
import com.fabian.rest.client.task.UpdateTaskRequest;
import com.fabian.rest.client.task.UpdateTaskResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskClient {

    private final SecurityHelper securityHelper;
    private final WebServiceTemplate template;
    private static final String WS_URI = "http://localhost:8080/ws";

    public AllTaskResponse getTasksByUserId() {
        final String userId = securityHelper.getUserSessionId();
        final AllTaskRequest request = new AllTaskRequest();
        request.setUserId(userId);

        log.info("Init request to get all tasks for userId {} ", userId);
        final AllTaskResponse response = (AllTaskResponse) template
                .marshalSendAndReceive(WS_URI, request);
        return response;
    }


    public TaskResponse create(final TaskRequest request){
        log.info("Init request to create a new task");
        final TaskResponse response = (TaskResponse) template
                .marshalSendAndReceive(WS_URI, request);
        return  response;
    }

    public DeleteTaskResponse delete(final String taskId){
        final DeleteTaskRequest request = new DeleteTaskRequest();
        request.setTaskId(taskId);
        log.info("Init request to delete a task");
        final DeleteTaskResponse response = (DeleteTaskResponse) template
                .marshalSendAndReceive(WS_URI, request);
        return  response;
    }

    public UpdateTaskResponse update(final UpdateTaskRequest request){
        log.info("Init request to update a task");
        final UpdateTaskResponse response = (UpdateTaskResponse) template
                .marshalSendAndReceive(WS_URI, request);
        return  response;
    }

}
