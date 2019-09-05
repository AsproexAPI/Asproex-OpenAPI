package io.Asproex.api.test;

import io.aspoex.api.test.constant.Constants;
import io.asproex.api.client.AsproexApiClientFactory;
import io.asproex.api.client.AsproexApiRestClient;
import io.asproex.api.client.AsproexApiWebSocketClient;
import io.asproex.api.client.constant.AsproexConstants;

//@Slf4j
public class UserDataStreamTest {

    public static void main(String[] args) {
//
    	AsproexApiWebSocketClient client = AsproexApiClientFactory.newInstance().newWebSocketClient();
    	AsproexApiRestClient restClient = AsproexApiClientFactory.newInstance(Constants.ACCESS_KEY, Constants.SECRET_KEY).newRestClient();

        System.out.println("\n ------Get Listen Key -----");
        System.out.println();
        String listenKey = restClient.startUserDataStream(AsproexConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis());
        System.out.println("listenKey:" + listenKey);
        // order
        client.onUserEvent(listenKey, response -> System.out.println(response), true);

    }
}
