package controllers;

import bases.BaseController;
import dao.ProductDAO;
import dao.ShoppingCartDAO;
import domain.ShoppingCart;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/shoppingcart")
public class ShoppingCartController extends BaseController<ShoppingCart, ShoppingCartDAO> {
}
