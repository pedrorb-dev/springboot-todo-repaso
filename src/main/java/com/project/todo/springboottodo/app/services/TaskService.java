package com.project.todo.springboottodo.app.services;

import com.project.todo.springboottodo.app.dtos.CreateTaskRequestDto;
import com.project.todo.springboottodo.app.dtos.TaskMapperDto;
import com.project.todo.springboottodo.app.dtos.TaskResponseDto;
import com.project.todo.springboottodo.app.dtos.UpdateStateRequestDto;
import com.project.todo.springboottodo.app.entities.Task;
import com.project.todo.springboottodo.app.repositories.TaskRepository;
import com.project.todo.springboottodo.app.utils.StateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;
    @Autowired
    private TaskMapperDto mapper;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskResponseDto> findAll() {
        List<Task> tasks = taskRepository.getTasks();
        List<TaskResponseDto> responseDtos = new ArrayList<>();

        for(Task task: tasks) {
            responseDtos.add(mapper.tasktoDto(task));
        }
        return responseDtos;
    }

    public TaskResponseDto findById(Long id) {
        Task task = taskRepository.findById(id);
        return mapper.tasktoDto(task);
    }

    public TaskResponseDto save(CreateTaskRequestDto taskDto) {
        Task task = mapper.createTaskRequestDtotoEntity(taskDto);
        task = taskRepository.save(task);
        return mapper.tasktoDto(task);
    }

    public TaskResponseDto deleteById(Long id) {
        Task task = taskRepository.deleteById(id);
        return mapper.tasktoDto(task);
    }

    public TaskResponseDto updateById(Long id, CreateTaskRequestDto taskDto) {
        Task task = mapper.createTaskRequestDtotoEntity(taskDto);
        task = taskRepository.updateById(id, task);
        return mapper.tasktoDto(task);
    }

    public TaskResponseDto updateState(Long id, UpdateStateRequestDto state) {
        Task task = taskRepository.updateState(id, state.getState());
        return mapper.tasktoDto(task);
    }
}
