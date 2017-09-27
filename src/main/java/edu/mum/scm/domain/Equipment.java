package edu.mum.scm.domain;

import java.io.Serializable;

import javax.persistence.Entity;

//@Entity
public class Equipment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4784695537914476778L;

	private String name;
	
	private String description;
	
	private String contactPeron;
	
	private Integer quantity;
}
