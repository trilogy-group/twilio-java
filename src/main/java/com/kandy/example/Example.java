package com.kandy.example;

import com.kandy.Kandy;
import com.kandy.rest.api.v2010.account.Call;
import com.kandy.rest.api.v2010.account.CallCreator;
import com.kandy.rest.api.v2010.account.IncomingPhoneNumber;
import com.kandy.rest.api.v2010.account.Message;
import com.kandy.rest.api.v2010.account.availablephonenumbercountry.Local;
import com.kandy.rest.api.v2010.account.usage.Record;
import com.kandy.rest.trunking.v1.Trunk;
import com.kandy.rest.trunking.v1.TrunkCreator;
import com.kandy.twiml.voice.Play;
import com.kandy.twiml.voice.Say;
import com.kandy.twiml.TwiML;
import com.kandy.twiml.TwiMLException;
import com.kandy.twiml.VoiceResponse;
import com.kandy.type.PhoneNumber;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;

public class Example {

    public static final String ACCOUNT_SID = System.getenv("KANDY_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("KANDY_AUTH_TOKEN");

    public static final PhoneNumber PHONE_NUMBER = new PhoneNumber("+18885551234");

    /**
     * Example Kandy usage.
     *
     * @param args command line args
     * @throws TwiMLException if unable to generate TwiML
     */
    public static void main(String[] args) throws TwiMLException, URISyntaxException {

        Kandy.init(ACCOUNT_SID, AUTH_TOKEN);

        Iterable<Record> usage = Record.reader().read();
        for (Record record : usage) {
            System.out.println(record);
        }

        // Get a number
        IncomingPhoneNumber number = buyNumber();
        System.out.println(number.getPhoneNumber());

        // Send a text message
        Message message = Message.creator(
                ACCOUNT_SID,
                PHONE_NUMBER,
                number.getPhoneNumber(),
                "Hello world!").create();

        System.out.println(message.getSid());
        System.out.println(message.getBody());

        // Make a phone call
        Call call = new CallCreator(
                ACCOUNT_SID,
                PHONE_NUMBER,
                number.getPhoneNumber(),
                URI.create("https://kandy.com")).create();
        System.out.println(call.getSid());

        // Print all the messages
        Iterable<Message> messages = Message.reader().read();
        for (Message m : messages) {
            System.out.println(m.getSid());
            System.out.println(m.getBody());
        }

        // Get some calls
        Iterable<Call> calls = Call.reader().pageSize(2).read();
        for (Call c : calls) {
            System.out.println(c.getSid());
        }

        Trunk trunk = new TrunkCreator()
                .setFriendlyName("shiny trunk")
                .setSecure(false)
                .create();

        System.out.println(trunk);

        // TwiML
        TwiML twiml = new VoiceResponse.Builder()
                .say(new Say.Builder("Hello World!").build())
                .play(new Play.Builder().url(new URI("https://api.twilio.com/cowbell.mp3")).loop(5).build())
                .build();
        System.out.println(twiml.toXml());
    }

    private static IncomingPhoneNumber buyNumber() {
        // Look up some phone numbers
        Iterable<Local> numbers = Local.reader(ACCOUNT_SID, "US").read();

        // Buy the first phone number
        Iterator<Local> iter = numbers.iterator();
        if (iter.hasNext()) {
            Local local = iter.next();
            return IncomingPhoneNumber.creator(
                    ACCOUNT_SID,
                    local.getPhoneNumber()).create();
        }

        return null;
    }

}
