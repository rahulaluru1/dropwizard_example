package com.todos.demo.model;

public class Todo extends TodoList{
    private Long id;
    private String name;
    private String description;

    public Todo(Long id, String name, String description, Long id1, String name1, String description1) {
        super(id, name, description);
        this.id = id1;
        this.name = name1;
        this.description = description1;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
