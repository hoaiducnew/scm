package edu.mum.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import edu.mum.scm.domain.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
