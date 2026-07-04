package com.project.todo.springboottodo.app.repositories;

import com.project.todo.springboottodo.app.entities.Task;
import com.project.todo.springboottodo.app.exceptions.NoTaskException;
import com.project.todo.springboottodo.app.utils.PriorityEnum;
import com.project.todo.springboottodo.app.utils.StateEnum;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
    private List<Task> tasks;

    public TaskRepository() {
        this.tasks = new ArrayList<>(
                List.of(
                        new Task(1L, "Aprender Spring", "Repaso para aprender lo básico de spring", PriorityEnum.MEDIA, StateEnum.EN_PROGRESO, LocalDate.now()),
                        new Task(2L, "Aprender React", "Repaso para aprender lo básico de react", PriorityEnum.MEDIA, StateEnum.PENDIENTE, LocalDate.now()),
                        new Task(3L, "Aprender Flutter", "Repaso para aprender lo básico de flutter", PriorityEnum.ALTA, StateEnum.EN_PROGRESO, LocalDate.now())
                )
        );
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Task save(Task task) {
        this.tasks.add(task);
        return task;
    }

    public Task findById(Long id) {
        for(Task task: tasks) {
            if(task.getId_task().equals(id)) {
                return task;
            }
        }
        throw new NoTaskException("No existe una tarea con ese id");
    }

    public Task updateById(Long id, Task task) {
        Task taskDB = findById(id);
        taskDB.setTitle(task.getTitle());
        taskDB.setDescription(task.getDescription());
        taskDB.setPriority(task.getPriority());
        taskDB.setDate(task.getDate());
        taskDB.setState(task.getState());

        return taskDB;
    }

    public Task deleteById(Long id) {
        Task taskDB = findById(id);
        tasks.remove(taskDB);
        return taskDB;
    }

    public Task updateState(Long id, StateEnum state) {
        Task task = findById(id);
        task.setState(state);
        return task;
    }
}
