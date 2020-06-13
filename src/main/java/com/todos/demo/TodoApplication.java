package com.todos.demo;

import com.todos.demo.db.TodoListDao;
import com.todos.demo.db.TodosDao;
import com.todos.demo.resources.TodoListResource;
import com.todos.demo.resources.TodosResource;
import com.todos.demo.services.TodoListService;
import com.todos.demo.services.TodosService;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class TodoApplication extends Application<TodoAppConfiguration> {
    public static void main(String[] args) throws Exception {
        new TodoApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<TodoAppConfiguration> bootstrap) {

    }

    public void run(TodoAppConfiguration todoAppConfiguration, Environment environment) throws Exception {
        final DBIFactory dbiFactory=new DBIFactory();
        final DBI dbi=dbiFactory.build(environment,todoAppConfiguration.getDataSourceFactory(), "mysql");

        final TodosDao todosDao=dbi.onDemand(TodosDao.class);
        final TodosService todosService=new TodosService(todosDao);
        final TodosResource todosResource=new TodosResource(todosService);

        final TodoListDao todoListDao=dbi.onDemand(TodoListDao.class);
        final TodoListService todoListService=new TodoListService(todoListDao);
        final TodoListResource todoListResource=new TodoListResource(todoListService);

        environment.jersey().register(todosResource);
        environment.jersey().register(todoListResource);

    }
}
