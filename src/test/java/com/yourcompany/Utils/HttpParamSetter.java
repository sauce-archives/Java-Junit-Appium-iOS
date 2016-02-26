package com.yourcompany.Utils;

import org.apache.http.impl.client.CloseableHttpClient;
import org.openqa.selenium.remote.internal.HttpClientFactory;
import org.openqa.selenium.remote.internal.ApacheHttpClient.Factory;
import org.powermock.reflect.Whitebox;

/**
 * Created by mehmetgerceker on 2/26/16.
 */


public final class HttpParamSetter {

    /**
     * Sets default http socket and connection timeouts for the HttpClientFactory class. It works because the factory
     * is static.
     * @param socketTimeout socket timeout in millis. If not >0 the default of 3 hours will remain in effect
     * @param connectionTimeout socket timeout in millis. If not >0 the default of 2 mins will remain in effect
     */
    public static void setTimeouts(int socketTimeout, int connectionTimeout) {
        injectIntoHttpCommandExecutor(createClientFactoryWithSoTimeout(socketTimeout, connectionTimeout));
    }

    private static HttpClientFactory createClientFactoryWithSoTimeout(int socketTimeout, int connectionTimeout) {
        HttpClientFactory httpClientFactory = new HttpClientFactory();
        if (socketTimeout > 0) {
            Whitebox.setInternalStateFromContext(httpClientFactory, "TIMEOUT_THREE_HOURS", socketTimeout);
        }
        if (connectionTimeout > 0) {
            Whitebox.setInternalStateFromContext(httpClientFactory, "TIMEOUT_TWO_MINUTES", connectionTimeout);
        }
        CloseableHttpClient httpClient = httpClientFactory.createHttpClient(null);
        Whitebox.setInternalState(httpClientFactory, "httpClient", httpClient);
        return httpClientFactory;
    }

    private static void injectIntoHttpCommandExecutor(HttpClientFactory httpClientFactory) {
        Whitebox.setInternalState(Factory.class, "defaultClientFactory", httpClientFactory);
    }
}