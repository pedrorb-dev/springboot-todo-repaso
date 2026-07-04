package com.project.todo.springboottodo.app.controllers;

import com.project.todo.springboottodo.app.dtos.CreateTaskRequestDto;
import com.project.todo.springboottodo.app.dtos.TaskMapperDto;
import com.project.todo.springboottodo.app.dtos.TaskResponseDto;
import com.project.todo.springboottodo.app.dtos.UpdateStateRequestDto;
import com.project.todo.springboottodo.app.services.TaskService;
import com.project.todo.springboottodo.app.utils.StateEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<TaskResponseDto> findAll() {
        return taskService.findAll();
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<TaskResponseDto> findById(@PathVariable Long id) {
        TaskResponseDto task = taskService.findById(id);
        return ResponseEntity.ok(task);
    }

    @PostMapping("/task")
    public ResponseEntity<TaskResponseDto> save(@RequestBody CreateTaskRequestDto taskDto) {
        TaskResponseDto taskDB = taskService.save(taskDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskDB);
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<TaskResponseDto> deleteById(@PathVariable Long id) {
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<TaskResponseDto> updateById(@PathVariable Long id, @RequestBody CreateTaskRequestDto taskDto) {
        TaskResponseDto taskDB = taskService.updateById(id, taskDto);
        return ResponseEntity.status(HttpStatus.GONE).body(taskDB);
    }

    @PatchMapping("/task/{id}")
    public ResponseEntity<TaskResponseDto> updateState(@PathVariable Long id, @RequestBody UpdateStateRequestDto state) {
        TaskResponseDto taskDto = taskService.updateState(id, state);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskDto);
    }
}
