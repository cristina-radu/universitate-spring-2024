package org.example.qualifier.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DaoService {
    private DbConnection dbConnection;

    public DaoService(@Qualifier("mySql") DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void connectingToDb(){
        dbConnection.connect();
    }
}
