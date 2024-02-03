package com.spring.core.sendemail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
    private DataSource dataSource;
    @Autowired  //-- Not necessary since Constructor based
    public EmailService(DataSource dataSource){
        this.dataSource = dataSource;
        System.out.println("emailS");
    }

    public void sendEmail(){
        String[] emailList = dataSource.getEmails();

        for (String email: emailList){
            System.out.println(email);
        }
    }

    /*    public EmailService(DataSource dataSource){
        this.dataSource = dataSource;
        System.out.println("EmailService...");
    }
    void sendEmail(){
        String[] emailList;

        MySQLDataSource mySQLDataSource = new MySQLDataSource();
        PostgreSQLDataSource postgreSQLDataSource = new PostgreSQLDataSource();

        emailList = postgreSQLDataSource.getEmails();

        for (String email: emailList ){
            System.out.println(email);

    }}*/
}
