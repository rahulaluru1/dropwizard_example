package com.todos.demo.services;

import com.todos.demo.db.TodoListDao;
import com.todos.demo.model.Todo;
import com.todos.demo.model.TodoList;

import javax.ws.rs.core.Response;
import java.util.List;

public class TodoListService {
    private TodoListDao todoListDao;
    public TodoListService(final TodoListDao todoListDao){
        this.todoListDao=todoListDao;
    }

    public List<TodoList> getTodoLists() {
        return this.todoListDao.getTodoLists();
    }

    public  TodoList getTodoList( final int todolist_id){
        return this.todoListDao.getTodoList(todolist_id);
    }

    public TodoList editTodoList(TodoList todoList) {
         this.todoListDao.editTodoList(todoList);
        return this.todoListDao.getTodoList(Integer.parseInt(String.valueOf(todoList.getId())));
    }

    public int deleteTodoList(int id) {
        return this.todoListDao.deleteTodoList(id);
    }

    public void addTodoList(TodoList todoList){
        this.todoListDao.addTodoList(todoList);
    }

}
