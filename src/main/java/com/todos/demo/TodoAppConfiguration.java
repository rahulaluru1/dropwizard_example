package com.todos.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.sql.DataSource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class TodoAppConfiguration extends Configuration {
    @Valid
    @NotNull
    private  DataSourceFactory dataSourceFactory=new DataSourceFactory();

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory(){
        return dataSourceFactory;
    }
    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
        this.dataSourceFactory = dataSourceFactory;
    }
}
