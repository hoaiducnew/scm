package edu.mum.scm.service;

import edu.mum.scm.domain.Cart;
import edu.mum.scm.domain.LineItem;

public interface CartService {
	public LineItem addToCart(String productcode, Cart cart);

	public void removeFromCart(String productcode, Cart cart);
}
