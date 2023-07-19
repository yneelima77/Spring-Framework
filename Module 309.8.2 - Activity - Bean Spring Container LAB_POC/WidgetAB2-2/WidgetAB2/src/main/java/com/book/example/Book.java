package com.book.example;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Book implements InitializingBean, DisposableBean{

   private Integer id;
   private String name;

   public Book() {
      super();
   }
 
   public Integer getId() {
      return id;
   }
   public void setId(Integer id) {
      this.id = id;
   }
   
   public String getName() {
      return name;
   }
   
   public void setName(String name) {
      this.name = name;
   }

   @Override
   public String toString() {
      return "Book [Id=" + id + ", name=" + name + "]";
   }
   

   @Override
   public void destroy() throws Exception {
	   // TODO Auto-generated method stub
	   System.out.println("Inside destroy() method");
   }

   //Spring documentation provides clear explanation about preferable ways of initialization:

   //   To interact with the container's management of the bean lifecycle, you can implement 
   // the Spring InitializingBean and DisposableBean interfaces. The container calls 
   // afterPropertiesSet() for the former and destroy() for the latter to allow the bean 
   // to perform certain actions upon initialization and destruction of your beans.

   //   The JSR-250 @PostConstruct and @PreDestroy annotations are generally considered 
   // best practice for receiving lifecycle callbacks in a modern Spring application. 
   // Using these annotations means that your beans are not coupled to Spring specific interfaces.
   
   @Override
   public void afterPropertiesSet() throws Exception {
	   // TODO Auto-generated method stub
	   System.out.println("Inside afterPropertiesSet");	
   }
   
}