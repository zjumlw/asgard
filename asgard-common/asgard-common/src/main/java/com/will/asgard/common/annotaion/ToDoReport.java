package com.will.asgard.common.annotaion;

import java.lang.reflect.Method;

public class ToDoReport {

	public static void main(String[] args) {
		getToDoReportForBusinessLogic();
	}

	private static void getToDoReportForBusinessLogic() {
		Class businessLogicClass = BusinessLogic.class;
		for (Method method : businessLogicClass.getMethods()) {
			ToDo todoAnnotation = method.getAnnotation(ToDo.class);
			if (todoAnnotation != null) {
				System.out.println("Method name: " + method.getName());
				System.out.println("Author: " + todoAnnotation.author());
				System.out.println("Priority: " + todoAnnotation.priority());
				System.out.println("Status: " + todoAnnotation.status());
			}
		}
	}

}
