package pl.ene.common.rest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

import org.slf4j.LoggerFactory;



@ServerLogged
public class RestCommonReadInterceptor implements ReaderInterceptor, WriterInterceptor {

	private org.slf4j.Logger LOG = LoggerFactory.getLogger(RestCommonReadInterceptor.class);

	@Override
	public Object aroundReadFrom(ReaderInterceptorContext ctx) throws IOException, WebApplicationException {
		// TODO Auto-generated method stub

		LOG.info("Call read interceptor");
		StringBuilder buff = new StringBuilder();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// BufferedReader reader = new BufferedReader( new
		// InputStreamReader(rq.getEntityStream()));

		InputStream is = ctx.getInputStream();
		int c;
		while ((c = is.read()) != -1) {
			baos.write(c);
		}

		buff.append("\n-----------------------Payload length = " + baos.toByteArray().length + " bytes");
		buff.append("\n" + baos.toString());

		LOG.info(buff.toString());

		return ctx.proceed();
	}

	@Override
	public void aroundWriteTo(WriterInterceptorContext arg0) throws IOException, WebApplicationException {
		// TODO Auto-generated method stub
		LOG.info("Call write interceptor");
		arg0.proceed();

	}

}
