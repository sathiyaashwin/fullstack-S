package com.training.resource;

import java.util.List;

import com.training.Product;
import com.training.service.ProductService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;



@Path("/products")
public class ProductResource {
	
	private static ProductService service = new ProductService();
	public ProductResource() {
		super();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> findAll()
	{
		return service.findAll();
	}
	@GET
	@Path("/{productId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("productId")int id) {
		try {
			Product entity=service.findById(id).orElseThrow(()->new RuntimeException("Id not found"));
		return Response.ok(entity).build();
			}catch(RuntimeException e) {
				e.printStackTrace();
				return Response.ok("id not found").status(400).build();
			}
	}
	
	@DELETE
	@Path("/{productId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteById(@PathParam("productId")int id) {
		int result=service.deleteById(id);
		if(result!=0) {
			return Response.status(204,"One resource deleted").build();
		}else {
			return Response.status(400,"Not Deleted").build();
		}
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProduct(Product entity) {
		int result= service.addProduct(entity);
		if(result!=0) {
			return Response.ok(entity).status(201,"created ya ").build();
		}
		else {
			return Response.status(400,"not created").build();
		}
		 
	}
}
