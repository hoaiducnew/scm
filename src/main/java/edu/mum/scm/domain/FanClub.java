package edu.mum.scm.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class FanClub implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -250182391860602370L;
	
	@Id
	@GeneratedValue
	Long id;
	
	@NotEmpty
	@Size(max=50, min=4, message="")
	private String name;
	
	private String description;
	
	@NotEmpty
	private String leader;
	
	private Address address;
	
	@NotEmpty
	@Email
	private String email;
	
	private String phone;
	
	@NotNull
	@Min(value=1)
	private Integer numberOfMembers;
}
