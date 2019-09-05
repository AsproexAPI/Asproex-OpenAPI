package io.asproex.api.client;

/**
 * asproexApiCallback is a functional interface used together with the asproexApiAsyncClient to provide a non-blocking REST client.
 *
 * @param <T> the return type from the callback
 */
@FunctionalInterface
public interface AsproexApiCallback<T> {

    /**
     * Called whenever a response comes back from the asproex API.
     *
     * @param response the expected response object
     */
    void onResponse(T response);

    /**
     * Called whenever an error occurs.
     *
     * @param cause the cause of the failure
     */
    default void onFailure(Throwable cause) {
    }
}
