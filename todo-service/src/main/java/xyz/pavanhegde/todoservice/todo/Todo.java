package xyz.pavanhegde.todoservice.todo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Boolean completed;
    private LocalDate dueDate;

    public Todo() {
    }

    public Todo(String title, String description, Boolean completed, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.dueDate = dueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                ", dueDate=" + dueDate +
                '}';
    }

    public static class Builder {
        private final Todo todo;

        public Builder() {
            todo = new Todo();
        }

        public Builder withTitle(String title) {
            todo.setTitle(title);
            return this;
        }

        public Builder withDescription(String description) {
            todo.setDescription(description);
            return this;
        }

        public Builder withCompleted(Boolean completed) {
            todo.setCompleted(completed);
            return this;
        }

        public Builder withDueDate(LocalDate dueDate) {
            todo.setDueDate(dueDate);
            return this;
        }

        public Todo build() {
            return todo;
        }
    }
}
