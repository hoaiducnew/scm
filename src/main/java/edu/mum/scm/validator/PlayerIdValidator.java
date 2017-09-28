package edu.mum.scm.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;


import edu.mum.scm.domain.Player;
import edu.mum.scm.service.PlayerService;

public class PlayerIdValidator implements ConstraintValidator<PlayerId, String>{
	
	@Autowired
	private PlayerService playerService;

	public void initialize(PlayerId constraintAnnotation) {
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		Player player = null;
		try {
			player = playerService.getPlayerByPlayerId(value);
			
		} catch (RuntimeException e) {
			return true;
		}
		
		if(player!= null)
			return false;
		return true;
	}
}
