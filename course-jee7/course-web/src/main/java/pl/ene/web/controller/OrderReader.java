package pl.ene.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;


import org.slf4j.LoggerFactory;

import pl.ene.common.rest.RestCommonReadInterceptor;
import pl.ene.model.rest.Order;


@Provider
@Consumes("application/eneformat")
public class OrderReader implements MessageBodyReader<Order>{

	private org.slf4j.Logger LOG = LoggerFactory.getLogger(RestCommonReadInterceptor.class);
	
	
	@Override
	public boolean isReadable(Class<?> arg0, Type arg1, Annotation[] arg2, MediaType arg3) {
		// TODO Auto-generated method stub
		return true;
	}

	
	@Override
	
	public Order readFrom(Class<Order> arg0, Type arg1, Annotation[] arg2, MediaType arg3,
			MultivaluedMap<String, String> arg4, InputStream arg5) throws IOException, WebApplicationException {
		// TODO Auto-generated method stub
		LOG.info("Order Reader call");
		return null;
	}

}
