package com.kandy.example;

import com.kandy.http.KandyRestClient;
import com.kandy.http.ValidationClient;
import com.kandy.rest.accounts.v1.credential.PublicKey;
import com.kandy.rest.api.v2010.account.Message;
import com.kandy.rest.api.v2010.account.NewSigningKey;
import com.kandy.twiml.TwiMLException;
import com.kandy.type.PhoneNumber;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Base64;

public class ValidationExample {

        public static final String ACCOUNT_SID = System.getenv("KANDY_ACCOUNT_SID");
        public static final String AUTH_TOKEN = System.getenv("KANDY_AUTH_TOKEN");

        /**
         * Example Kandy usage.
         *
         * @param args command line args
         * @throws TwiMLException if unable to generate TwiML
         */
        public static void main(String[] args) throws Exception {

                // Generate public/private key pair
                KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
                keyGen.initialize(2048);
                KeyPair pair = keyGen.generateKeyPair();
                java.security.PublicKey pk = pair.getPublic();

                // Use the default rest client
                KandyRestClient client = new KandyRestClient.Builder(ACCOUNT_SID, AUTH_TOKEN)
                                .build();

                // Create a public key and signing key using the default client
                PublicKey key = PublicKey.creator(
                                Base64.getEncoder().encodeToString(pk.getEncoded())).setFriendlyName("Public Key")
                                .create(client);

                NewSigningKey signingKey = NewSigningKey.creator().create(client);

                // Switch to validation client as the default client
                KandyRestClient validationClient = new KandyRestClient.Builder(signingKey.getSid(),
                                signingKey.getSecret())
                                .accountSid(ACCOUNT_SID)
                                .httpClient(new ValidationClient(ACCOUNT_SID, key.getSid(), signingKey.getSid(),
                                                pair.getPrivate()))
                                .build();

                // Make REST API requests
                Iterable<Message> messages = Message.reader().read(validationClient);
                for (Message message : messages) {
                        System.out.println(message.getBody());
                }

                Message message = Message.creator(
                                new PhoneNumber("+1XXXXXXXXXX"),
                                new PhoneNumber("+1XXXXXXXXXX"),
                                "Public Key Client Validation Test").create(validationClient);
                System.out.println(message.getSid());
        }
}
