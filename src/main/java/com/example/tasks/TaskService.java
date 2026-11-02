package com.example.tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;
    private final DateTimeFormatter dateFormatter;   // the @Bean from AppConfig

    public List<Task> getAll() {
        return repository.findAll();
    }

    public List<Task> getPending() {
        List<Task> pending = new ArrayList<>();
        for (Task task : repository.findAll()) {
            if (!task.isDone()) {
                pending.add(task);
            }
        }
        log.debug("{} pending tasks", pending.size());
        return pending;
    }

    public String getSummary() {
        String today = LocalDate.now().format(dateFormatter);
        int total = repository.findAll().size();
        int pending = getPending().size();
        log.info("Summary requested: {} tasks, {} pending", total, pending);
        return "Summary for " + today + ": " + total + " tasks, " + pending + " pending";
    }
}
