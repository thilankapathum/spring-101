package com.spring.core.sendemail;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PostgreSQLDataSource implements DataSource{

    @Override
    public String[] getEmails(){
        String[] emails = {"w@x.com","y@z.com"};
        return emails;
    }
}
