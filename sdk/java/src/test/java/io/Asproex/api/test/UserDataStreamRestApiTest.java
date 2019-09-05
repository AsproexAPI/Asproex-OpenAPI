package io.Asproex.api.test;

import io.aspoex.api.test.constant.Constants;
import io.asproex.api.client.AsproexApiClientFactory;
import io.asproex.api.client.AsproexApiRestClient;
import io.asproex.api.client.constant.AsproexConstants;

public class UserDataStreamRestApiTest {

    public static void main(String[] args) {

        AsproexApiClientFactory factory = AsproexApiClientFactory.newInstance(Constants.ACCESS_KEY, Constants.SECRET_KEY);
        AsproexApiRestClient client = factory.newRestClient();

        System.out.println("\n ------start user data stream-----");
        String listenKey = client.startUserDataStream(AsproexConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis());
        System.out.println(listenKey);

        System.out.println("\n ------keepAlive user data stream-----");
        client.keepAliveUserDataStream(listenKey, AsproexConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis());

        System.out.println("\n ------close user data stream-----");
        client.closeUserDataStream(listenKey, AsproexConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis());

    }

}
