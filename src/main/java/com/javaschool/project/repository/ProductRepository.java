package com.javaschool.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaschool.project.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
