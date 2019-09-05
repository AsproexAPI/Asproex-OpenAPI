package io.asproex.api.client.exception;

import io.asproex.api.client.AsproexApiError;

/**
 * An exception which can occur while invoking methods of the Asproex API.
 */
public class AsproexApiException extends RuntimeException {

    private static final long serialVersionUID = 3788669840036201041L;
    /**
     * Error response object returned by Asproex API.
     */
    private AsproexApiError error;

    /**
     * Instantiates a new Asproex api exception.
     *
     * @param error an error response object
     */
    public AsproexApiException(AsproexApiError error) {
        this.error = error;
    }

    /**
     * Instantiates a new Asproex api exception.
     */
    public AsproexApiException() {
        super();
    }

    /**
     * Instantiates a new Asproex api exception.
     *
     * @param message the message
     */
    public AsproexApiException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Asproex api exception.
     *
     * @param cause the cause
     */
    public AsproexApiException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Asproex api exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public AsproexApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @return the response error object from Asproex API, or null if no response object was returned (e.g. server returned 500).
     */
    public AsproexApiError getError() {
        return error;
    }

    @Override
    public String getMessage() {
        if (error != null) {
            return error.getMsg();
        }
        return super.getMessage();
    }
}
