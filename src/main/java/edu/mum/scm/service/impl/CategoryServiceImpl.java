package edu.mum.scm.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.scm.dao.CategoryDao;
import edu.mum.scm.domain.Category;
import edu.mum.scm.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDao categorydao;

	public void addCategory(Category category) {
		categorydao.save(category);

	}

	public List<Category> getCategory() {
		return (List<Category>)categorydao.findAll();

	}

	public void deleteCategory(Long catId) {
		categorydao.delete(catId);

		
	}

	public void editCategory( Category c) {
		Category category= categorydao.findOne(c.getId());
		category.setType(c.getType());

		}

	public Category getUniqueCategory(Long catId) {
		return categorydao.findOne(catId);
	}

	

}
