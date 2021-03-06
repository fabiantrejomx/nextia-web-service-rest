//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.12.29 a las 04:28:17 PM CST 
//


package com.fabian.rest.client.task;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.fabian.rest.client.task package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.fabian.rest.client.task
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TaskRequest }
     * 
     */
    public TaskRequest createTaskRequest() {
        return new TaskRequest();
    }

    /**
     * Create an instance of {@link TaskResponse }
     * 
     */
    public TaskResponse createTaskResponse() {
        return new TaskResponse();
    }

    /**
     * Create an instance of {@link DeleteTaskRequest }
     * 
     */
    public DeleteTaskRequest createDeleteTaskRequest() {
        return new DeleteTaskRequest();
    }

    /**
     * Create an instance of {@link DeleteTaskResponse }
     * 
     */
    public DeleteTaskResponse createDeleteTaskResponse() {
        return new DeleteTaskResponse();
    }

    /**
     * Create an instance of {@link UpdateTaskRequest }
     * 
     */
    public UpdateTaskRequest createUpdateTaskRequest() {
        return new UpdateTaskRequest();
    }

    /**
     * Create an instance of {@link UpdateTaskResponse }
     * 
     */
    public UpdateTaskResponse createUpdateTaskResponse() {
        return new UpdateTaskResponse();
    }

    /**
     * Create an instance of {@link AllTaskRequest }
     * 
     */
    public AllTaskRequest createAllTaskRequest() {
        return new AllTaskRequest();
    }

    /**
     * Create an instance of {@link AllTaskResponse }
     * 
     */
    public AllTaskResponse createAllTaskResponse() {
        return new AllTaskResponse();
    }

    /**
     * Create an instance of {@link TaskInfo }
     * 
     */
    public TaskInfo createTaskInfo() {
        return new TaskInfo();
    }

}
