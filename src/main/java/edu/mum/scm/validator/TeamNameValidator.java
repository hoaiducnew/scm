package edu.mum.scm.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.scm.domain.Product;
import edu.mum.scm.exception.ProductNotFoundException;
import edu.mum.scm.service.ProductService;

public class TeamNameValidator implements ConstraintValidator<TeamName, String>{
	@Autowired
	private ProductService productService;
	
	@Override
	public void initialize(TeamName arg0) {
		
	}

	@Override
	public boolean isValid(String productcode, ConstraintValidatorContext cnxt) {
		Product product;
		try {
			product = productService.getProduct(productcode);
			
		} catch (ProductNotFoundException e) {
			return true;
		}
		
		if(product!= null) {
			return false;
		}
		
		return true;
	
	}

}
