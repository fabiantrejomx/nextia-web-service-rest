# Getting Started

# Steps in order to start the WS rest.

### Consideration
Use JAVA 8 to compile the application.

Install the dependencies using the following command
```sh
mvn clean install
```

* Run the application as another java application, the port is 8081.

### Test cases
* Consider use Postman
* CREATE
```sh
[POST] - http://localhost:8081/task
```
```sh
{
    "subject": "Create a task using rest client",
    "isDone": false,
    "userId": 1
}
```
* UPDATE
```sh
[PUT] - http://localhost:8081/task
```
```sh
{
    "subject": "Create a task using rest client",
    "isDone": false,
    id: "TaskId"
}
```

* DELETE
```sh
[DELETE] - http://localhost:8081/task/{taskId}
```

* GET ALL TASKS
```sh
[GET] - http://localhost:8081/task/users/{userId}
```