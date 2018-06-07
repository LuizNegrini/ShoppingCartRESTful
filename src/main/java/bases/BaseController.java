package bases;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public abstract class BaseController<TEntity extends BaseEntity, TDao extends BaseDAO> {
    @Inject
    private TDao dao;

    public Response getErrorResponse (Exception ex) {
        return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response doPOST(TEntity jsonObject) {
        try {
            return Response.ok(dao.Insert(jsonObject)).build();
        } catch (Exception ex) {
            return getErrorResponse(ex);
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response doPUT(TEntity jsonbObject)
    {
        try {
            return Response.ok(dao.Update(jsonbObject)).build();
        } catch (Exception ex) {
            return Response.notModified().build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response doGET() {
        try {
            return Response.ok(dao.GetAll()).build();
        } catch (Exception ex) {
            return getErrorResponse(ex);
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response doGETById(@PathParam("id") int id) {
        try {
            return Response.ok(dao.GetBy(id)).build();
        } catch (Exception ex) {
            return this.getErrorResponse(ex);
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response doDELETE(@PathParam("id") int id) {
        try {
            dao.Delete(id);
            return Response.ok("Entity deleted with sucess.").build();
        } catch (Exception ex) {
            return this.getErrorResponse(ex);
        }
    }
}
