/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Conversations
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.conversations.v1.conversation;

import com.kandy.base.Creator;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;
import java.time.ZonedDateTime;

public class MessageCreator extends Creator<Message> {
    private String pathConversationSid;
    private Message.WebhookEnabledType xKandyWebhookEnabled;
    private String author;
    private String body;
    private ZonedDateTime dateCreated;
    private ZonedDateTime dateUpdated;
    private String attributes;
    private String mediaSid;
    private String contentSid;
    private String contentVariables;

    public MessageCreator(final String pathConversationSid) {
        this.pathConversationSid = pathConversationSid;
    }

    public MessageCreator setXKandyWebhookEnabled(final Message.WebhookEnabledType xKandyWebhookEnabled) {
        this.xKandyWebhookEnabled = xKandyWebhookEnabled;
        return this;
    }

    public MessageCreator setAuthor(final String author) {
        this.author = author;
        return this;
    }

    public MessageCreator setBody(final String body) {
        this.body = body;
        return this;
    }

    public MessageCreator setDateCreated(final ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public MessageCreator setDateUpdated(final ZonedDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
        return this;
    }

    public MessageCreator setAttributes(final String attributes) {
        this.attributes = attributes;
        return this;
    }

    public MessageCreator setMediaSid(final String mediaSid) {
        this.mediaSid = mediaSid;
        return this;
    }

    public MessageCreator setContentSid(final String contentSid) {
        this.contentSid = contentSid;
        return this;
    }

    public MessageCreator setContentVariables(final String contentVariables) {
        this.contentVariables = contentVariables;
        return this;
    }

    @Override
    public Message create(final KandyRestClient client) {
        String path = "/v1/Conversations/{ConversationSid}/Messages";

        path = path.replace("{" + "ConversationSid" + "}", this.pathConversationSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.CONVERSATIONS.toString(),
                path);
        addPostParams(request);
        addHeaderParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Message creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Message.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (author != null) {
            request.addPostParam("Author", author);

        }
        if (body != null) {
            request.addPostParam("Body", body);

        }
        if (dateCreated != null) {
            request.addPostParam("DateCreated", dateCreated.toInstant().toString());

        }
        if (dateUpdated != null) {
            request.addPostParam("DateUpdated", dateUpdated.toInstant().toString());

        }
        if (attributes != null) {
            request.addPostParam("Attributes", attributes);

        }
        if (mediaSid != null) {
            request.addPostParam("MediaSid", mediaSid);

        }
        if (contentSid != null) {
            request.addPostParam("ContentSid", contentSid);

        }
        if (contentVariables != null) {
            request.addPostParam("ContentVariables", contentVariables);

        }
    }

    private void addHeaderParams(final Request request) {
        if (xKandyWebhookEnabled != null) {
            request.addHeaderParam("X-Kandy-Webhook-Enabled", xKandyWebhookEnabled.toString());

        }
    }
}
