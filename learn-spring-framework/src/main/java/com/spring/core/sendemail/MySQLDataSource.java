package com.spring.core.sendemail;

import org.springframework.stereotype.Component;

@Component
public class MySQLDataSource implements DataSource{

    @Override
    public String[] getEmails(){
        String[] emails = {"a@b.com","c@d.com"};

        return emails;
    }
}
