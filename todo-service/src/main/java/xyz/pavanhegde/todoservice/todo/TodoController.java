package xyz.pavanhegde.todoservice.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final Logger log = LoggerFactory.getLogger(TodoController.class);
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // Get all todos
    @GetMapping
    public List<Todo> getAllTodos() {
        log.info("Getting all todos");
        return todoService.getAllTodos();
    }

    // Get todo by id
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        log.info("Getting todo with id: {}", id);
        return todoService.getTodo(id);
    }

    // Create todo
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        log.info("Creating todo: {}", todo);
        return todoService.createTodo(todo);
    }

    // Update todo
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        log.info("Updating todo with id: {}", id);
        return todoService.updateTodo(id, todo);
    }

    // Delete todo
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        log.info("Deleting todo with id: {}", id);
        todoService.deleteTodo(id);
    }

}
