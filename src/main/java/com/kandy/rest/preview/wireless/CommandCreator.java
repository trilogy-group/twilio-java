/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Preview
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.preview.wireless;

import com.kandy.base.Creator;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;
import java.net.URI;

import java.net.URI;

public class CommandCreator extends Creator<Command> {
    private String command;
    private String device;
    private String sim;
    private String callbackMethod;
    private URI callbackUrl;
    private String commandMode;
    private String includeSid;

    public CommandCreator(final String command) {
        this.command = command;
    }

    public CommandCreator setCommand(final String command) {
        this.command = command;
        return this;
    }

    public CommandCreator setDevice(final String device) {
        this.device = device;
        return this;
    }

    public CommandCreator setSim(final String sim) {
        this.sim = sim;
        return this;
    }

    public CommandCreator setCallbackMethod(final String callbackMethod) {
        this.callbackMethod = callbackMethod;
        return this;
    }

    public CommandCreator setCallbackUrl(final URI callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    public CommandCreator setCallbackUrl(final String callbackUrl) {
        return setCallbackUrl(Promoter.uriFromString(callbackUrl));
    }

    public CommandCreator setCommandMode(final String commandMode) {
        this.commandMode = commandMode;
        return this;
    }

    public CommandCreator setIncludeSid(final String includeSid) {
        this.includeSid = includeSid;
        return this;
    }

    @Override
    public Command create(final KandyRestClient client) {
        String path = "/wireless/Commands";

        path = path.replace("{" + "Command" + "}", this.command.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.PREVIEW.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Command creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Command.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (command != null) {
            request.addPostParam("Command", command);

        }
        if (device != null) {
            request.addPostParam("Device", device);

        }
        if (sim != null) {
            request.addPostParam("Sim", sim);

        }
        if (callbackMethod != null) {
            request.addPostParam("CallbackMethod", callbackMethod);

        }
        if (callbackUrl != null) {
            request.addPostParam("CallbackUrl", callbackUrl.toString());

        }
        if (commandMode != null) {
            request.addPostParam("CommandMode", commandMode);

        }
        if (includeSid != null) {
            request.addPostParam("IncludeSid", includeSid);

        }
    }
}
