package com.kandy.example.resource;

import com.kandy.Kandy;
import com.kandy.exception.ApiException;
import com.kandy.rest.api.v2010.account.Call;
import com.kandy.rest.api.v2010.account.CallReader;
import com.kandy.base.ResourceSet;

/**
 * Fetch a list of calls.
 */
public class CallReaderExample {

    @SuppressWarnings("checkstyle:javadocmethod")
    public static void main(final String[] args) {
        Kandy.init("AC123", "AUTH TOKEN");

        try {

            CallReader reader = Call.reader("AC123");
            ResourceSet<Call> calls = reader.read();

            int idx = 1;
            for (Call call : calls) {
                System.out.println(idx + ": " + call.getSid());
                idx++;
            }

            System.out.println("All Done");

        } catch (ApiException e) {
            System.err.println("womp womp");
            System.exit(1);
        }
    }
}
