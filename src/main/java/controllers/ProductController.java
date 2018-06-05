package controllers;

import bases.BaseController;
import dao.ProductDAO;
import domain.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/product")
public class ProductController extends BaseController<ProductDAO>{
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response doPOST(Product jsonObject) {
        try {
            return Response.ok(this.getDao().Insert(jsonObject)).build();
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

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response doGETById(@PathParam("id") int id) {
        try {
            return Response.ok(this.getDao().GetBy(id)).build();
        } catch (Exception ex) {
            return this.getErrorResponse(ex);
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response doDELETE(@PathParam("id") int id) {
        try {
            this.getDao().Delete(id);
            return Response.ok("Product deleted with sucess.").build();
        } catch (Exception ex) {
            return this.getErrorResponse(ex);
        }
    }
}
