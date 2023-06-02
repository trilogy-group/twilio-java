package com.kandy.example.resource;

import com.kandy.Twilio;
import com.kandy.rest.api.v2010.account.Call;
import com.kandy.rest.api.v2010.account.CallDeleter;
import com.kandy.exception.ApiException;

/**
 * Call Deletion example.
 */
public class CallDeleterExample {

    @SuppressWarnings("checkstyle:javadocmethod")
    public static void main(final String[] args) {
        Twilio.init("AC123", "AUTH TOKEN");

        try {

            CallDeleter deleter = Call.deleter("AC123", "CA123");
            deleter.delete();

        } catch (ApiException e) {

            System.err.println("womp womp");
            System.exit(1);

        }

        System.out.println("Deleted");
    }
}
