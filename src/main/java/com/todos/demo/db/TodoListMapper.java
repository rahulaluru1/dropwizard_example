package com.todos.demo.db;

import com.todos.demo.model.TodoList;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TodoListMapper implements ResultSetMapper<TodoList> {
    @Override
    public TodoList map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        int id=resultSet.getObject("id")!=null ? resultSet.getInt("id") : 0 ;
        String name=resultSet.getString("name")!=null ? resultSet.getString("name") : "";
        String description=resultSet.getString("description")!=null ? resultSet.getString("description") : "";
        TodoList todoList=new TodoList(id,name,description);

        return todoList;
    }
}
