package edu.mum.scm.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import edu.mum.scm.validator.PlayerId;

@Entity
public class Player implements Serializable {

	private static final long serialVersionUID = -3433452234089925865L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@PlayerId
	private String playerId;

	@Size(min = 4, max = 40, message = "FirstName must lager than 4 characters")
	private String firstName;

	@Size(min = 4, message = "LastName must lager than 4 characters")
	private String lastName;

	@Size(min = 4, message = "Biography must lager than 4 characters")
	private String biography;

	private Double salary;

	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date birthday;

	private String imagePath;

	@Transient
	private MultipartFile image;

	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Id")
	private PlayerPosition playerPosition;

	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

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

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
