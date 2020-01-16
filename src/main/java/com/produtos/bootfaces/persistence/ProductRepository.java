package com.produtos.bootfaces.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.bootfaces.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
