package com.example.tasks;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    private int id;
    private String title;
    private Priority priority;
    private boolean done;
}
