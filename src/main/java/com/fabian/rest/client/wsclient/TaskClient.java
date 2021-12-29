package com.fabian.rest.client.wsclient;

import com.fabian.rest.client.task.AllTaskRequest;
import com.fabian.rest.client.task.AllTaskResponse;
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

    private final WebServiceTemplate template;

    public AllTaskResponse getTasksByUserId(final String userId) {
        final AllTaskRequest request = new AllTaskRequest();
        request.setUserId(userId);

        log.info("Init request to get all tasks for userId {} ", userId);
        final AllTaskResponse response = (AllTaskResponse) template
                .marshalSendAndReceive("http://localhost:8080/ws", request);

        return response;
    }

}
