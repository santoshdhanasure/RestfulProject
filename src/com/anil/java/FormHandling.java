package com.anil.java;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
 
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.anil.java.dao.CustDao;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
 
@Path("/messages")
public class FormHandling {
     
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createMessage(@FormParam("name") String name,
                                @FormParam("adharId") String adharId,
                                @FormParam("adds") List<String> list) {
        if(name.trim().length() > 0 && adharId.trim().length() > 0 && !list.isEmpty()) {
        	CustDao dao=new CustDao();
        	Integer id;
			try {
				id = dao.saveCustData( adharId, name, list.get(0), list.get(1));
				return Response.created(URI.create("/messages/" + String.valueOf(UUID.randomUUID()))).entity("customer created With Customer ID "+id).build();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				return Response.created(URI.create("/messages/" + String.valueOf(UUID.randomUUID()))).entity("Got exception e "+e.getMessage()).build();
			}
            
             
            // This is a more real world "return"
            //return Response.created(URI.create("/messages/" + String.valueOf(UUID.randomUUID()))).build();            
        }
        return Response.status(Response.Status.PRECONDITION_FAILED).build();
    }                   
}