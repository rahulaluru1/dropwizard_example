package com.todos.demo.db;

import com.todos.demo.model.Todo;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(TodosMapper.class)
public interface TodosDao {
    @SqlQuery("select * from `todos`")
    public List<Todo> getTodos();
}
