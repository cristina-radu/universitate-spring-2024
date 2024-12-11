package org.example.qualifier.service;

import org.springframework.stereotype.Component;

@Component("oracle")
public class OracleDbConnection implements DbConnection {

    public void connect(){
        System.out.println("Connecting to oracle..");
    }
}
