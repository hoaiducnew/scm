package edu.mum.scm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;

import edu.mum.scm.domain.Category;
import edu.mum.scm.domain.Product;
import edu.mum.scm.repository.ProductRepository;
import edu.mum.scm.service.CategoryService;
import edu.mum.scm.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productdao;
	
	@Autowired
	CategoryService categoryservice;;

	public List<Product> getAllProducts() {

		List<Product> products = (List<Product>)productdao.findAll();
		for (Product product : products) {
			product.setImageFile(Base64Utils.encodeToString(product.getCoverImage()));
		}
		return products;
	}

	public Product getProduct(String productcode) {
		return productdao.getProductByProductcode(productcode);
	}

	public void addProduct(Product product) {
		productdao.save(product);

	}

	public void deleteProduct(Long productId) {
		productdao.delete(productId);

	}

	public void editProduct(Product product) {
		Product productToBeUpdated = productdao.findOne(product.getId());
		productToBeUpdated.setCategory(product.getCategory());
		productToBeUpdated.setDescription(product.getDescription());
		productToBeUpdated.setName(product.getName());
		productToBeUpdated.setImage(product.getImage());
		productToBeUpdated.setCoverImage(product.getCoverImage());
		productToBeUpdated.setQuantity(product.getQuantity());
		productToBeUpdated.setProductcode(product.getProductcode());
		productToBeUpdated.setUnitPrice(product.getUnitPrice());
	}

	public Product getUniqueProduct(Long productId) {
		return productdao.findOne(productId);
	}

	public List<Product> getProductsById(Long id) {
		Category category = categoryservice.getUniqueCategory(id);
		List<Product> products = productdao.getProductByCategory(category);
		for (Product product : products) {
			product.setImageFile(Base64Utils.encodeToString(product.getCoverImage()));
		}
		return products;
	}

}
