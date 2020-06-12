package com.todos.demo;

import com.todos.demo.db.TodosDao;
import com.todos.demo.resources.HelloWorldResource;
import com.todos.demo.resources.TodosResource;
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
        environment.jersey().register(todosResource);
    }
}
