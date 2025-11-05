package com.myapp.smarttasks;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks") // default path για όλες τις μεθόδους
public class HelloController {

    // repository για πραγματική βάση δεδομένων
    private final TaskRepository repository;

    public HelloController(TaskRepository repository) {
        this.repository = repository;
    }

    // GET: get all tasks
    @GetMapping
    public List<Task> getTasks() {
        return repository.findAll();
    }

    // POST: create new task
    @PostMapping
    public Task createTask(@RequestBody Task newTask) {
        return repository.save(newTask); // return new task
    }

    // PUT: Upadate task με βάση το id
    // πχ (http://localhost:8080/tasks/1)
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable int id, @RequestBody Task updatedTask) {
        var optionalTask = repository.findById(id);

        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setCompleted(updatedTask.isCompleted());
            repository.save(task);
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body(Map.of("error", "Task not found"));
        }
    }

    // DELETE: task με βάση το id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable int id) {
        var optionalTask = repository.findById(id);

        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            repository.deleteById(id);
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body(Map.of("error", "Task not found"));
        }
    }
}
