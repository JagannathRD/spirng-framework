package com.xworkz.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.annotation.store.Customer;

public class Tester {

	public static void main(String[] args) {
		try(ClassPathXmlApplicationContext container= new ClassPathXmlApplicationContext("resources/context.xml")){
			Customer customer=container.getBean(Customer.class);
			customer.orderFood();
			customer.cancelFood();
		}
	}
	
}

/*Dec-18			
	"public class Customer{

name;
email;

Order order;

public void orderFood(){
this.order.book();
}
public void cancelFood(){
this.order.cancel();

}

}
public interface Order {


               boolean book();
			   boolean cancel();

}
//create using spring
public class OnlineOrder implements Order{

//impl book and cancel 

}
//create using spring
public class OfflineOrder implements Order {


}
"		 */