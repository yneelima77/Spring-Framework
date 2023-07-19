package com.example.AC1demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Ac1demoApplication {

	public static void main(String[] args) {

    ConfigurableApplicationContext context =  SpringApplication.run(Ac1demoApplication.class, args);

    // get the bean from spring container
    //YOUR_CODE_HERE
        WidgetA widgetA = context.getBean(WidgetA.class);
        System.out.println("Got the Bean");
        System.out.println(widgetA.doSomething());
    
    /* old way, tight coupling
    WidgetA wid = new WidgetA();
    
     call a method on the bean
    System.out.println(wid.doSomething());*/
 
    // close the context
    context.close();
    
	}
}