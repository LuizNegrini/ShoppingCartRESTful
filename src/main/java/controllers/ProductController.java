package controllers;

import bases.BaseController;
import dao.ProductDAO;
import domain.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/product")
public class ProductController extends BaseController<ProductDAO>{

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response POST() {

        Product p = new Product();
        p.setName("Coca-cola");
        p.setValue(3.29);
        Product inserted = this.getDao().Insert(p);

        return Response.ok(inserted).build();
    }
}
