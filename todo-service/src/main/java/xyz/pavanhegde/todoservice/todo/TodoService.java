package xyz.pavanhegde.todoservice.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final Logger log = LoggerFactory.getLogger(TodoService.class);
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo createTodo(Todo todo) {
        log.info("Creating todo: {}", todo);
        return todoRepository.save(todo);
    }

    public Todo getTodo(Long id) {
        log.info("Getting todo with id: {}", id);
        return todoRepository.findById(id).orElse(null);
    }

    public Todo updateTodo(Long id, Todo todo) {
        log.info("Updating todo with id: {}", id);
        Todo existingTodo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        existingTodo.setTitle(todo.getTitle());
        existingTodo.setDescription(todo.getDescription());
        existingTodo.setCompleted(todo.getCompleted());
        existingTodo.setDueDate(todo.getDueDate());
        return todoRepository.save(existingTodo);
    }

    public void deleteTodo(Long id) {
        log.info("Deleting todo with id: {}", id);
        todoRepository.deleteById(id);
    }

    public List<Todo> getAllTodos() {
        log.info("Getting all todos");
        return todoRepository.findAll();
    }

}
