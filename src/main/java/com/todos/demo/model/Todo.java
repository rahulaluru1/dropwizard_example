package com.todos.demo.model;

public class Todo extends TodoList{
    private int todo_id;
    private String todo_name;
    private String todo_description;
    private  int todolist_id;
    public Todo(){
        super();

    }
    public Todo(int id,  String name, String description, int id1, String name1, String description1, int todolist_id) {
        super(id,name,description);
        this.todo_id = id1;
        this.todo_name = name1;
        this.todo_description = description1;
        this.todolist_id=todolist_id;
    }

    public int getTodolist_id() {
        return todolist_id;
    }

    public void setTodolist_id(int todolist_id) {
        this.todolist_id = todolist_id;
    }

    public int getTodo_id() {
        return todo_id;
    }

    public void setTodo_id(int todo_id) {
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
