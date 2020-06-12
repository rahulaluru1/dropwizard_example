package com.todos.demo;

import com.todos.demo.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TodoApplication extends Application<TodoAppConfiguration> {
    public static void main(String[] args) throws Exception {
        new TodoApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<TodoAppConfiguration> bootstrap) {

    }

    public void run(TodoAppConfiguration todoAppConfiguration, Environment environment) throws Exception {
        environment.jersey().register(new HelloWorldResource());
    }
}
