package com.project.todo.springboottodo.app.dtos;

import com.project.todo.springboottodo.app.entities.Task;
import com.project.todo.springboottodo.app.repositories.TaskRepository;
import com.project.todo.springboottodo.app.utils.StateEnum;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class TaskMapperDto {
    private final TaskRepository taskRepository;

    public TaskMapperDto(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTaskRequestDtotoEntity(CreateTaskRequestDto taskDto) {
        Task task = new Task();
        task.setId_task(getNextTaskId());
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setPriority(taskDto.getPriority());
        task.setState(StateEnum.PENDIENTE);
        task.setDate(LocalDate.now());
        return task;
    }

    public TaskResponseDto tasktoDto(Task task) {
        TaskResponseDto taskDto = new TaskResponseDto();
        taskDto.setId_task(task.getId_task());
        taskDto.setTitle(task.getTitle());
        taskDto.setDescription(task.getDescription());
        taskDto.setPriority(task.getPriority());
        taskDto.setState(task.getState());
        taskDto.setDate(task.getDate().toString());
        return taskDto;
    }

    public Task getLastTask() {
        List<Task> tasks = taskRepository.getTasks();
        return tasks.get(tasks.size() - 1);
    }

    private Long getNextTaskId() {
        List<Task> tasks = taskRepository.getTasks();
        if (tasks.isEmpty()) {
            return 1L;
        }
        return getLastTask().getId_task() + 1;
    }
}
