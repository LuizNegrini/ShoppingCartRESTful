package bases;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

public abstract class BaseController<TDao extends BaseDAO> {
    @Inject
    private TDao dao;

    public TDao getDao(){
        return dao;
    }

    public Response getErrorResponse (Exception ex) {
        return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
    }
}
