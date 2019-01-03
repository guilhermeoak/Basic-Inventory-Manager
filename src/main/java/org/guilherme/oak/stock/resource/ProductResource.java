package org.guilherme.oak.stock.resource;

import java.util.List;

import org.guilherme.oak.stock.service.ProductService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.guilherme.oak.stock.model.Product;

@Path("/products")
public class ProductResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> list() {
		List<Product> productsList = new ProductService().products();
		return productsList;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product productByIdResource(@PathParam("id") long id) {
		Product product = new ProductService().productById(id);
		return product;
	}

	@POST
	@Path("/record")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response recordResource(Product productObject) {
		Response response = new ProductService().record(productObject);
		return response;
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateResource(Product productObject) {
		Response response = new ProductService().update(productObject);
		return response;
	}
	
	@DELETE
	@Path("/remove/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeResponse(@PathParam("id") long id) {
		Response response = new ProductService().remove(id);
		return response;
	}

}
