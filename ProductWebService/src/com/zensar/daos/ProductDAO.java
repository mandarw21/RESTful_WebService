package com.zensar.daos;

import java.util.List;

import com.zensar.entities.Product;

/*
 * Author: Pickle Rick
 * Creation Date: 26th July 2019 10.02 AM
 * Modified Date: 26th July 2019 10.02 AM
 * Version: 1.0
 * Copyright: Zensar Technologies. All rights reserved.
 * Description: Data Access Object Interface.
 * It is used to access Product Data from Database.   
 * */

public interface ProductDAO {

	void insert(Product product);
	void update(Product product);
	void delete(Product product);
	
	Product getById(int productId);
	List<Product> getAll();
	
}
