package com.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/di/diBeans.xml");
		CentralController centralController = (CentralController) context.getBean("centralControl"); // Object 형태로 가져옴
		centralController.onAll();
		centralController.offAll();
	}

}
