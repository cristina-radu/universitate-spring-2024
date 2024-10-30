package org.example.qualifier.service;

import org.springframework.stereotype.Component;

@Component("mySql")
public class MySqlDbConnection implements DbConnection {

    public void connect(){
        System.out.println("Connecting to mySql..");
    }
}
