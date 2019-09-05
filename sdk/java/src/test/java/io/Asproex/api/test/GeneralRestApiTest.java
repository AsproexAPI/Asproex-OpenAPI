package io.Asproex.api.test;

import io.asproex.api.client.AsproexApiClientFactory;
import io.asproex.api.client.AsproexApiRestClient;
import io.asproex.api.client.domain.general.BrokerInfo;


public class GeneralRestApiTest {

    public static void main(String[] args) {

        AsproexApiClientFactory factory = AsproexApiClientFactory.newInstance();
        AsproexApiRestClient client = factory.newRestClient();

        System.out.println("\n ------BrokerInfo-----");
        BrokerInfo brokerInfo = client.getBrokerInfo();
        System.out.println(brokerInfo);

    }


}
