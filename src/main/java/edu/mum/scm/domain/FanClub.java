package edu.mum.scm.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getNumberOfMembers() {
		return numberOfMembers;
	}

	public void setNumberOfMembers(Integer numberOfMembers) {
		this.numberOfMembers = numberOfMembers;
	}

	public Long getId() {
		return id;
	}
	
	
}
