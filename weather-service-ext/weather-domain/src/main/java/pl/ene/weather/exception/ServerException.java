package pl.ene.weather.exception;

public class ServerException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 8789982601482796620L;

	public ServerException() {
		super();
	}

	public ServerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ServerException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServerException(String message) {
		super(message);
	}

	public ServerException(Throwable cause) {
		super(cause);
	}


}
