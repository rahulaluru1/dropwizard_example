package com.todos.demo.model;

public class Todo{
    private Long todo_id;
    private String todo_name;
    private String todo_description;
    private  Long todolist_id;
    public Todo(){

    }
    public Todo(Long id1, String name1, String description1,Long todolist_id) {
        this.todo_id = id1;
        this.todo_name = name1;
        this.todo_description = description1;
        this.todolist_id=todolist_id;
    }

    public Long getTodolist_id() {
        return todolist_id;
    }

    public void setTodolist_id(Long todolist_id) {
        this.todolist_id = todolist_id;
    }

    public Long getTodo_id() {
        return todo_id;
    }

    public void setTodo_id(Long todo_id) {
        this.todo_id = todo_id;
    }

    public String getTodo_name() {
        return todo_name;
    }

    public void setTodo_name(String todo_name) {
        this.todo_name = todo_name;
    }

    public String getTodo_description() {
        return todo_description;
    }

    public void setTodo_description(String todo_description) {
        this.todo_description = todo_description;
    }
}
