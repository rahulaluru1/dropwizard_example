package com.todos.demo.services;

import com.todos.demo.db.TodosDao;
import com.todos.demo.model.Todo;

import java.util.List;

public class TodosService {
    private TodosDao todosDao;
    public TodosService(final TodosDao todosDao){
        this.todosDao=todosDao;
    }

    public List<Todo> getTodos(){
        return this.todosDao.getTodos();
    }
}
