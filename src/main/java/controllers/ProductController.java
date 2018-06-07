package controllers;

import bases.BaseController;
import dao.ProductDAO;
import domain.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/product")
public class ProductController extends BaseController<Product, ProductDAO>{
}
