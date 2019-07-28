/**
 * 
 */
package com.zensar.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author TRG
 *
 */
@Path("/zenHello")
public class Hello {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello from Zensar";
	}
	
	@Path("/welcome")
	@GET
	public String sayHtmlHello() {
		return "<body bgcolor=\"aqua\">\r\n" + 
				"<p>Welcome to Zensar html</p>\r\n" + 
				"</body>";
	}
	
	@Path("/welcomeXml")
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXmlHello() {
		return "<?xml version ='1.0'?>\r\n" + 
				"<messages>\r\n" + 
				"	<message>\r\n" + 
				"		Hello world from Zensar Xml\r\n" + 
				"	</message>\r\n" + 
				"</messages>";
	}
}