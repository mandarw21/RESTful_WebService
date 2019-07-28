package com.zensar.services.business;

import java.util.List;

import com.zensar.entities.Product;

/*
 * Author: Pickle Rick
 * Creation Date: 26th July 2019 11.25 AM
 * Modified Date: 26th July 2019 11.02 AM
 * Version: 1.0
 * Copyright: Zensar Technologies. All rights reserved.
 * Description: Business Object Interface.
 * It focuses on business logic of product.   
 * */
public interface ProductService {

	void create(Product product);
	void edit(Product product);
	void remove(Product product);
	
	Product findProductById(int productId);
	
	List<Product> findAllProducts();
	List<Product> findProductsByBrand(String brand);
	List<Product> findProductsByPriceRange(float minPrice,float maxPrice);
	
	int getProductCount();
	
	
}
