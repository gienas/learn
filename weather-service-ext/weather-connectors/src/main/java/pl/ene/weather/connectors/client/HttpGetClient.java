package pl.ene.weather.connectors.client;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import pl.ene.weather.exception.ClientException;
import pl.ene.weather.exception.ServerException;

public class HttpGetClient {

	private static final String CLIENT_EXCEPTION_MSG = "The request was not recognized by the provider ";
	private static final String SERVER_EXCEPTION_MSG = "The server cannot process the request at the moment ";

	protected String getRESTData(String url) throws ServerException, ClientException {

		try (DefaultHttpClient httpClient = new DefaultHttpClient()) {

			// Define a HttpGet request; You can choose between HttpPost,
			// HttpDelete or HttpPut also.
			// Choice depends on type of method you will be invoking.
			final HttpGet getRequest = new HttpGet(url);

			// Set the API media type in http accept header
			getRequest.addHeader("accept", "application/xml");

			// Send the request; It will immediately return the response in
			// HttpResponse object
			HttpResponse response;
			try {
				response = httpClient.execute(getRequest);
			} catch (final ClientProtocolException e) {
				throw new ClientException(CLIENT_EXCEPTION_MSG, e);
			} catch (final IOException e) {
				throw new ServerException(SERVER_EXCEPTION_MSG, e);
			}

			// verify the valid error code first
			final int statusCode = response.getStatusLine().getStatusCode();

			if (statusCode >= 400 && statusCode < 500) {
				throw new ClientException(CLIENT_EXCEPTION_MSG + statusCode);
			} else if (statusCode >= 500) {
				throw new ServerException(SERVER_EXCEPTION_MSG + statusCode);
			} else if (statusCode != 200) {
				throw new IllegalStateException("The server returned unexpeted status code " + statusCode);
			}

			// Now pull back the response object
			final HttpEntity httpEntity = response.getEntity();
			// Get output
			String output = "";

			try {

				output = EntityUtils.toString(httpEntity);

			} catch (final ParseException e) {
				throw new ServerException(SERVER_EXCEPTION_MSG + " problem parse header", e);
			} catch (final IOException e) {
				throw new ServerException(SERVER_EXCEPTION_MSG, e);
			}

			return output;

		}
	}

}
