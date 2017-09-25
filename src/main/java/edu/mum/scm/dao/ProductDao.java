package edu.mum.scm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.scm.domain.Category;
import edu.mum.scm.domain.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
	public Product getProductByProductcode(String productcode);

	public List<Product> getProductByCategory(Category category);

}
