package edu.mum.scm.exception;

public class TeamNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -238863496523498730L;
	
	private String name;

	public TeamNotFoundException(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
