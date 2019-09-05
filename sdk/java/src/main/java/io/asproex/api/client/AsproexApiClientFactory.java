package io.asproex.api.client;

import io.asproex.api.client.constant.AsproexConstants;
import io.asproex.api.client.impl.AsproexApiRestClientImpl;
import io.asproex.api.client.impl.AsproexApiWebSocketClientImpl;
import io.asproex.api.client.impl.AsproexOptionApiRestClientImpl;
import static io.asproex.api.client.impl.AsproexApiServiceGenerator.getSharedClient;

/**
 * A factory for creating asproexApi client objects.
 */
public final class AsproexApiClientFactory {

    /**
     * API Key
     */
    private String apiKey;

    /**
     * Secret.
     */
    private String secret;

    private String baseUrl = AsproexConstants.API_BASE_URL;

    /**
     * Instantiates a new asproex api client factory.
     *
     * @param apiKey the API key
     * @param secret the Secret
     */
    private AsproexApiClientFactory(String apiKey, String secret) {
        this.apiKey = apiKey;
        this.secret = secret;
    }

    private AsproexApiClientFactory(String baseUrl, String apiKey, String secret) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.secret = secret;
    }

    /**
     * New instance.
     *
     * @param apiKey the API key
     * @param secret the Secret
     * @return the asproex api client factory
     */
    public static AsproexApiClientFactory newInstance(String apiKey, String secret) {
        return new AsproexApiClientFactory(apiKey, secret);
    }

    /**
     * for bhop.cloud client and inner test only
     *
     * @param baseUrl
     * @param apiKey
     * @param secret
     * @return
     */
    public static AsproexApiClientFactory newInstance(String baseUrl, String apiKey, String secret) {
        return new AsproexApiClientFactory(baseUrl, apiKey, secret);
    }

    /**
     * New instance without authentication.
     *
     * @return the asproex api client factory
     */
    public static AsproexApiClientFactory newInstance() {
        return new AsproexApiClientFactory(null, null);
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public AsproexApiRestClient newRestClient() {
        return new AsproexApiRestClientImpl(baseUrl, apiKey, secret);
    }


    public AsproexApiWebSocketClient newWebSocketClient() {
        return new AsproexApiWebSocketClientImpl(getSharedClient(), AsproexConstants.WS_API_BASE_URL, AsproexConstants.WS_API_USER_URL);
    }

    /**
     * for bhop.cloud client and inner test only
     *
     * @param wsApiBaseUrl
     * @param wsApiUserUrl
     * @return
     */
    public AsproexApiWebSocketClient newWebSocketClient(String wsApiBaseUrl, String wsApiUserUrl) {
        return new AsproexApiWebSocketClientImpl(getSharedClient(), wsApiBaseUrl, wsApiUserUrl);
    }

    /**
     * Creates a new synchronous/blocking Option REST client.
     */
    public AsproexOptionApiRestClient newOptionRestClient() {
        return new AsproexOptionApiRestClientImpl(baseUrl, apiKey, secret);
    }

}
