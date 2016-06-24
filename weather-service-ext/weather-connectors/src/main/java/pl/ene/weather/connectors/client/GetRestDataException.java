package pl.ene.weather.connectors.client;

public class GetRestDataException extends Exception {

	/**
     *
     */
    private static final long serialVersionUID = -1815153660670236122L;

    public GetRestDataException() {
		super();
	}

	public GetRestDataException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public GetRestDataException(String message, Throwable cause) {
		super(message, cause);
	}

	public GetRestDataException(String message) {
		super(message);
	}

	public GetRestDataException(Throwable cause) {
		super(cause);
	}



}
