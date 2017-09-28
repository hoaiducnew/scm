package edu.mum.scm.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

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
	@Size(max=50, min=4)
	private String name;
	
	private String description;
	
	@NotEmpty
	private String leader;
	
	@NotEmpty
	@Email
	private String email;
	
	private String phone;
	
	private String imagePath;
	
	@Transient
	private MultipartFile image;
	
	private String address;
	
	@NotNull
	@Min(value=1)
	private Integer numberOfMembers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
	
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getNumberOfMembers() {
		return numberOfMembers;
	}

	public void setNumberOfMembers(Integer numberOfMembers) {
		this.numberOfMembers = numberOfMembers;
	}
	
}
