package com.zensar.services;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/productAdd")
public class HelloFormParam {

	@POST
	@Path("/add")
	@Produces("text/html")
	public Response	 addProduct(@FormParam("id") int id,@FormParam("name") String name,@FormParam("price") double price) {
		
		return Response.status(200)
				.entity("<p>Product Added Successfully !</p>" + 
		
						"<br>Product Id: "+ id +
						"<br>Name: " + name +
						"<br>Price: " + price + "</p>"
						
						)
				.build();

	}
}
