package edu.mum.scm.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.scm.domain.Team;
import edu.mum.scm.exception.TeamNotFoundException;
import edu.mum.scm.service.TeamService;

public class TeamNameValidator implements ConstraintValidator<TeamName, String>{
	@Autowired
	private TeamService teamService;
	
	@Override
	public void initialize(TeamName arg0) {
		//  intentionally left blank; this is the place to initialize the constraint annotation for any sensible default values.
	}

	@Override
	public boolean isValid(String teamName, ConstraintValidatorContext context) {
		if (teamService == null) {
			return true;
		}
		
		Team team;
		
		try {
			team = teamService.getByName(teamName);
		} catch (TeamNotFoundException e) {
			return true;
		}
		
		if (team != null) {
			return false;
		}
		
		return true;
	}

}
