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
public class ShoppingCartController extends BaseController<ShoppingCartDAO> {
    @Inject
    private ProductDAO pDao;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response doPOST(ShoppingCart objectJson) {
        try {
            return Response.ok(this.getDao().Insert(objectJson)).build();
        } catch (Exception ex) {
            return this.getErrorResponse(ex);
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response doGET() {
        try {
            return Response.ok(this.getDao().GetAll()).build();
        } catch (Exception ex) {
            return this.getErrorResponse(ex);
        }
    }
}
