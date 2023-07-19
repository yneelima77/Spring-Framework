package com.example.AC1demo;

import org.springframework.stereotype.Component;

// When we apply @Component annotation in a Java class, it is 
// considered as a Spring Bean by the Spring Container. However, 
// there are many other annotations that can do the same job, but 
// the @Component is the basic and the most widely used by the developers. 

@Component

public class WidgetB {
	
	public void doSomething() {
		System.out.println("CALLED doSomething() in WidgetB");
	}

}