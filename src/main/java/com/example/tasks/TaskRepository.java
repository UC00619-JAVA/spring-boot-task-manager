package com.example.tasks;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class TaskRepository {

    private final List<Task> tasks = new ArrayList<>();

    @PostConstruct
    public void loadSampleTasks() {
        tasks.add(Task.builder().id(1).title("Install the JDK 21").priority(Priority.HIGH).done(true).build());
        tasks.add(Task.builder().id(2).title("Create the tasks project").priority(Priority.HIGH).done(true).build());
        tasks.add(Task.builder().id(3).title("Add Lombok to the pom.xml").priority(Priority.MEDIUM).done(false).build());
        tasks.add(Task.builder().id(4).title("Read about JPA").priority(Priority.LOW).done(false).build());
        log.info("{} sample tasks loaded", tasks.size());
    }

    public List<Task> findAll() {
        return tasks;
    }
}
