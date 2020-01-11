package com.will.asgard.common.annotaion;

public class BusinessLogic {

	public void completeMethod() {
		System.out.println("This method is complete");
	}

	@ToDo(priority = ToDo.Priority.HIGH)
	public void notYetStartedMethod() {

	}

	@ToDo(priority = ToDo.Priority.MEDIUM, author = "mao", status = ToDo.Status.STARTED)
	public void incompleteMethod1() {

	}

	@ToDo(priority = ToDo.Priority.LOW, status = ToDo.Status.STARTED)
	public void incompleteMethod2() {

	}

}
