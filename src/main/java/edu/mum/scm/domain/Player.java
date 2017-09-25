package edu.mum.scm.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Player implements Serializable {
	
	private static final long serialVersionUID = -3433452234089925865L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String playerId;
	
	@Size(min = 4, max = 40, message = "firstName must between 4 and 40")
	private String firstName;
	
	@Size(min = 4, max = 40, message = "lastName must between 4 and 40")
	private String lastName;
	
	private String biography;
	
	@Min(500000)
	private Double salary;
	
	private Date birthday;
	
	@OneToOne
	@JoinColumn
	private PlayerPosition playerPosition;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public PlayerPosition getPlayerPosition() {
		return playerPosition;
	}

	public void setPlayerPosition(PlayerPosition playerPosition) {
		this.playerPosition = playerPosition;
	}
	
	
}
