package com.nikita.devops_project_nikita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/nikita/tasks")
public class TaskController_Nikita {

    @Autowired
    private TaskRepository_Nikita repository;

    @GetMapping
    public List<Task_Nikita> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Task_Nikita create(@RequestBody Task_Nikita task) {
        return repository.save(task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}