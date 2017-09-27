package edu.mum.scm.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Position implements Serializable {

	private static final long serialVersionUID = -882277280882395676L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Size(min = 1, max = 200, message = "description must from 1 to 200")
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
