
package com.zensar.services.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


import com.zensar.daos.ProductDAO;
import com.zensar.daos.ProductDAOImpl;
import com.zensar.entities.Product;

/*
 * Author: Pickle Rick
 * Creation Date: 26th July 2019 11.39 AM
 * Modified Date: 26th July 2019 11.39 AM
 * Version: 1.0
 * Copyright: Zensar Technologies. All rights reserved.
 * Description: Business Object Interface.
 * It encapsulates logic of application component Product.
 * It interacts with DAO Layer to get data from database.
 * It also interacts with presentation layer to
 * give data as per business requirement.
 * */

public class ProductServiceImpl implements ProductService {

	private ProductDAO dao;
	
	public ProductServiceImpl() {
		// TODO Auto-generated constructor stub
		dao = new ProductDAOImpl();
	}
	
	@Override
	public void create(Product product) {
		// TODO Auto-generated method stub
		dao.insert(product);
	}

	@Override
	public void edit(Product product) {
		// TODO Auto-generated method stub
		Product dbProduct = findProductById(product.getProductId());
		
		if (dbProduct!=null) {
			dbProduct.setName(product.getName());
			dbProduct.setBrand(product.getBrand());
			dbProduct.setPrice(product.getPrice());
			dao.update(dbProduct);
		}
		else {
			System.out.println("Product Not Found");
		}
		
	}

	@Override
	public void remove(Product product) {
		// TODO Auto-generated method stub
		Product dbProduct = findProductById(product.getProductId());
		
		if (dbProduct!=null) {
			dao.delete(dbProduct);
		} else {
			System.out.println("Product Not Found");
		}
	}

	

	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public List<Product> findProductsByBrand(String brand) {
		// TODO Auto-generated method stub
		List<Product> pList = findAllProducts();
		List<Product> pBList = new ArrayList<>();
		
		for (Product product : pList) {
			if (product.getBrand().equals(brand)) {
				pBList.add(product);
			} 
		}
		
		return pBList;
	}

	@Override
	public List<Product> findProductsByPriceRange(float minPrice, float maxPrice) {
		// TODO Auto-generated method stub
		List<Product> pList = findAllProducts();
		List<Product> pPList = new ArrayList<>();
		
		
		for (Product product : pList) {
			if (product.getPrice()> minPrice && product.getPrice()<maxPrice) {
				pPList.add(product);
			}
		}
		
//		Collections.sort(pPList, (o1, o2) -> o1.getPrice() - o2.getPrice());
		
		return pPList;
	}

	@Override
	public int getProductCount() {
		// TODO Auto-generated method stub
		return findAllProducts().size();
	}

	@Override
	public Product findProductById(int productId) {
		// TODO Auto-generated method stub
		return dao.getById(productId);
	}

}
