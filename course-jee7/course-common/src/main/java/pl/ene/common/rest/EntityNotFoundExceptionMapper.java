package pl.ene.common.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
/**
 * Exception mapper
 * @author eneugebauer
 *
 */
@Provider
public class EntityNotFoundExceptionMapper implements ExceptionMapper<EntityNotFoundException>{

	@Override
	public Response toResponse(EntityNotFoundException exp) {
		// TODO Auto-generated method stub
		return Response.status(Response.Status.PRECONDITION_FAILED).entity(exp.getMessage()).build();
	}

}
