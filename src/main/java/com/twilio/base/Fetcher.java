package com.kandy.base;

import com.kandy.Kandy;
import com.kandy.http.KandyRestClient;

import java.util.concurrent.CompletableFuture;

/**
 * Executor for fetches of a resource.
 *
 * @param <T> type of the resource
 */
public abstract class Fetcher<T extends Resource> {

    /**
     * Execute an async request using default client.
     *
     * @return future that resolves to requested object
     */
    public CompletableFuture<T> fetchAsync() {
        return fetchAsync(Kandy.getRestClient());
    }

    /**
     * Execute an async request using specified client.
     *
     * @param client client used to make request
     * @return future that resolves to requested object
     */
    public CompletableFuture<T> fetchAsync(final KandyRestClient client) {
        return CompletableFuture.supplyAsync(() -> fetch(client), Kandy.getExecutorService());
    }

    /**
     * Execute a request using default client.
     *
     * @return Requested object
     */
    public T fetch() {
        return fetch(Kandy.getRestClient());
    }

    /**
     * Execute a request using specified client.
     *
     * @param client client used to make request
     * @return Requested object
     */
    public abstract T fetch(final KandyRestClient client);
}
