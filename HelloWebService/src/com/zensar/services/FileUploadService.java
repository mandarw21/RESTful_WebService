package com.zensar.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/fileUpload")
public class FileUploadService {

	@POST
	@Path("/upload")
	@Produces("text/html")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(@FormDataParam("myfile") InputStream uploadStream,@FormDataParam("myfile")FormDataContentDisposition filedetails) {
		
		String fileLocation = "d:/uploads/" + filedetails.getFileName();
		
		//Saving File
		try {
			FileOutputStream fos = new FileOutputStream(new File(fileLocation));
			byte[] b = new byte[1024];
			int data = 0;
			
			while((data = uploadStream.read(b))!=-1) {
				fos.write(b,0,data);
			}
			
			fos.flush();
			fos.close();
			
		}
		catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		catch (IOException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
		
		return Response.status(200).entity("File uploaded to location " + fileLocation).build();
	}
}