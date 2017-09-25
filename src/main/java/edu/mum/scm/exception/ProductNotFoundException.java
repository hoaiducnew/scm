package edu.mum.scm.exception;

public class ProductNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 4798357498774363373L;
	
	private String productcode;

	public ProductNotFoundException(String productcode) {
		this.productcode = productcode;
	}
	
	public String getProductId() {
		return productcode;
	}
}
