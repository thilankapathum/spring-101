package com.spring.core.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class Student{

    private Address address;

    public Student(Address address){
        this.address = address;
    }

    public void print(){
        System.out.println("Student class method...");
        address.print();
    }

}

class Address{
    public void print(){
        System.out.println("Address class method...");
    }

}



@Configuration
class AppConfig{

    @Bean
    public Address address(){
        return new Address();
    }

    @Bean
    public Student student(){
        return new Student(address());
    }

}

public class BeanAnnotationDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        Student student = applicationContext.getBean(Student.class);
        student.print();
    }
}
