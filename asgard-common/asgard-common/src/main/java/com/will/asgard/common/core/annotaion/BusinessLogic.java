package com.will.asgard.common.core.annotaion;

import com.will.asgard.common.core.annotaion.ToDo.Priority;
import com.will.asgard.common.core.annotaion.ToDo.Status;

public class BusinessLogic {

	public void completeMethod() {
		System.out.println("This method is complete");
	}

	@ToDo(priority = Priority.HIGH)
	public void notYetStartedMethod() {

	}

	@ToDo(priority = Priority.MEDIUM, author = "mao", status = Status.STARTED)
	public void incompleteMethod1() {

	}

	@ToDo(priority = Priority.LOW, status = Status.STARTED)
	public void incompleteMethod2() {

	}

}
