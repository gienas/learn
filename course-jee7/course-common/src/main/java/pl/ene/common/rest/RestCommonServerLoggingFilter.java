package pl.ene.common.rest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map.Entry;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;

import org.slf4j.LoggerFactory;

@ServerLogged
public class RestCommonServerLoggingFilter implements ContainerRequestFilter {

	private org.slf4j.Logger LOG = LoggerFactory.getLogger(RestCommonServerLoggingFilter.class);

	@Override
	public void filter(ContainerRequestContext rq) throws IOException {

		
		
		StringBuilder  buff = new StringBuilder();
		
		//methods
		buff.append("\nMethod:");
		buff.append("\n\t" + rq.getMethod());
		
		// headers
		buff.append("\nHeaders:");
		for (Entry<String, List<String>> e : rq.getHeaders().entrySet()) {
			String key = e.getKey();
			List<String> vaList = e.getValue();
			buff.append("\n\t" + key);
			for (String val : vaList) {
				buff.append("\n\t\t" + val);
			}
		}
		
		//content
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		//BufferedReader reader = new BufferedReader( new InputStreamReader(rq.getEntityStream()));
		
		InputStream is = rq.getEntityStream();
		int c;
		while ((c= is.read()) != -1)
		{
			baos.write(c);
		}	
		
		buff.append("\nPayload length = " + baos.toByteArray().length + " bytes");
		buff.append("\n"  + baos.toString());
		
		LOG.info(buff.toString());
	}

}
