package org.example.qualifier;

import org.example.qualifier.config.ApplicationConfigFour;
import org.example.qualifier.service.DaoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class QualifierMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfigFour.class);
        DaoService daoService = (DaoService) applicationContext.getBean("daoService");
        daoService.connectingToDb();
    }

}
