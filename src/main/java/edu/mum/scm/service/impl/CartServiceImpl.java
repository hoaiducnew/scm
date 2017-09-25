package edu.mum.scm.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.scm.dao.ProductDao;
import edu.mum.scm.domain.Cart;
import edu.mum.scm.domain.LineItem;
import edu.mum.scm.domain.Product;
import edu.mum.scm.service.CartService;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	ProductDao productdao;

	public LineItem addToCart(String productcode, Cart cart) {
		Product product = productdao.getProductByProductcode(productcode);
		if (cart.getItems() == null) {
			cart.setItems(new ArrayList<LineItem>());
		} else {
			for (LineItem item : cart.getItems()) {
				if (item.getProduct().getProductcode().equals(productcode)) {
					int quanity = item.getQuanity();
					item.setQuanity(++quanity);
					double itemtotalprice = item.getTotalprice() * quanity;
					cart.setTotalamout(cart.getTotalamout() - item.getTotalprice() + itemtotalprice);
					item.setTotalprice(itemtotalprice);
					return item;
				}

			}

		}

		LineItem lineintem = new LineItem();
		double carttotalprice = 0.0;
		lineintem.setQuanity(1);
		lineintem.setProduct(product);
		lineintem.setTotalprice(product.getUnitPrice());
		cart.getItems().add(lineintem);

		for (LineItem lineItem : cart.getItems()) {
			carttotalprice = carttotalprice + lineItem.getTotalprice();
		}
		System.out.println("carttotalprice is " + carttotalprice);
		cart.setTotalamout(carttotalprice);
		return lineintem;
	}

	public void removeFromCart(String productcode, Cart cart) {
		for (LineItem item : cart.getItems()) {
			if (item.getProduct().getProductcode().equals(productcode)) {
				cart.getItems().remove(item);
				cart.setTotalamout(cart.getTotalamout() - item.getTotalprice());
				return;
			}
		}
	}
}
