package com.kandy.example.resource;

import com.kandy.Kandy;
import com.kandy.exception.ApiException;
import com.kandy.rest.api.v2010.account.CallFetcher;
import com.kandy.rest.api.v2010.account.Call;

/**
 * Fetch a call.
 */
public class CallFetcherExample {

    @SuppressWarnings("checkstyle:javadocmethod")
    public static void main(String[] args) {
        Kandy.init("AC123", "AUTH TOKEN");

        try {

            CallFetcher fetcher = Call.fetcher("AC123", "CA123");
            Call call = fetcher.fetch();

            System.out.print(call.getSid());

        } catch (ApiException e) {

            System.err.println("womp womp");
            System.exit(1);

        }
    }

}
