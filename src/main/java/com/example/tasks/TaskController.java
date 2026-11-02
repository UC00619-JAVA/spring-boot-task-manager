package com.example.tasks;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @GetMapping("/tasks")
    public List<Task> all() {
        return service.getAll();
    }

    @GetMapping("/tasks/pending")
    public List<Task> pending() {
        return service.getPending();
    }

    @GetMapping("/tasks/summary")
    public String summary() {
        return service.getSummary();
    }
}
