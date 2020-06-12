package com.todos.demo.db;

import com.todos.demo.model.Todo;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TodosMapper implements ResultSetMapper<Todo> {

    @Override
    public Todo map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        Todo todo=new Todo(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("description"),
                resultSet.getLong("todo_id"),
                resultSet.getString("todo_name"),
                resultSet.getString("todo_description")
        );

        return todo;
    }
}
