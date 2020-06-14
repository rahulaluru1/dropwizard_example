package com.todos.demo.services;

import com.todos.demo.db.TodosDao;
import com.todos.demo.model.Todo;

import java.util.List;

public class TodosService {
    private TodosDao todosDao;
    public TodosService(final TodosDao todosDao){
        this.todosDao=todosDao;
    }

    public List<Todo> getTodos() {
        return this.todosDao.getTodos();
    }
    public Todo getTodo(int id){
        return this.todosDao.getTodo(id);
    }

    public void addTodo(Todo todo){
         this.todosDao.addTodo(todo);
    }

    public Todo editTodo(Todo todo){
        this.todosDao.editTodo(todo);
        return this.todosDao.getTodo(Integer.parseInt(String.valueOf(todo.getTodo_id())));
    }

    public  int deleteTodo(int id){
       return  this.todosDao.deleteTodo(id);
    }
}
