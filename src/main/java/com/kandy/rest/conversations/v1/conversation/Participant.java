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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kandy.base.Resource;
import com.kandy.converter.DateConverter;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;

import com.kandy.exception.ApiException;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;

import java.util.Map;
import java.util.Objects;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Participant extends Resource {
    private static final long serialVersionUID = 164096252184722L;

    public static ParticipantCreator creator(final String pathConversationSid) {
        return new ParticipantCreator(pathConversationSid);
    }

    public static ParticipantDeleter deleter(final String pathConversationSid, final String pathSid) {
        return new ParticipantDeleter(pathConversationSid, pathSid);
    }

    public static ParticipantFetcher fetcher(final String pathConversationSid, final String pathSid) {
        return new ParticipantFetcher(pathConversationSid, pathSid);
    }

    public static ParticipantReader reader(final String pathConversationSid) {
        return new ParticipantReader(pathConversationSid);
    }

    public static ParticipantUpdater updater(final String pathConversationSid, final String pathSid) {
        return new ParticipantUpdater(pathConversationSid, pathSid);
    }

    /**
     * Converts a JSON String into a Participant object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Participant object represented by the provided JSON
     */
    public static Participant fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Participant.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Participant object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Participant object represented by the provided JSON
     */
    public static Participant fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Participant.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    public enum WebhookEnabledType {
        TRUE("true"),
        FALSE("false");

        private final String value;

        private WebhookEnabledType(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static WebhookEnabledType forValue(final String value) {
            return Promoter.enumFromString(value, WebhookEnabledType.values());
        }
    }

    private final String accountSid;
    private final String conversationSid;
    private final String sid;
    private final String identity;
    private final String attributes;
    private final Map<String, Object> messagingBinding;
    private final String roleSid;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final URI url;
    private final Integer lastReadMessageIndex;
    private final String lastReadTimestamp;

    @JsonCreator
    private Participant(
            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("conversation_sid") final String conversationSid,

            @JsonProperty("sid") final String sid,

            @JsonProperty("identity") final String identity,

            @JsonProperty("attributes") final String attributes,

            @JsonProperty("messaging_binding") final Map<String, Object> messagingBinding,

            @JsonProperty("role_sid") final String roleSid,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("date_updated") final String dateUpdated,

            @JsonProperty("url") final URI url,

            @JsonProperty("last_read_message_index") final Integer lastReadMessageIndex,

            @JsonProperty("last_read_timestamp") final String lastReadTimestamp) {
        this.accountSid = accountSid;
        this.conversationSid = conversationSid;
        this.sid = sid;
        this.identity = identity;
        this.attributes = attributes;
        this.messagingBinding = messagingBinding;
        this.roleSid = roleSid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
        this.lastReadMessageIndex = lastReadMessageIndex;
        this.lastReadTimestamp = lastReadTimestamp;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getConversationSid() {
        return this.conversationSid;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getIdentity() {
        return this.identity;
    }

    public final String getAttributes() {
        return this.attributes;
    }

    public final Map<String, Object> getMessagingBinding() {
        return this.messagingBinding;
    }

    public final String getRoleSid() {
        return this.roleSid;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    public final URI getUrl() {
        return this.url;
    }

    public final Integer getLastReadMessageIndex() {
        return this.lastReadMessageIndex;
    }

    public final String getLastReadTimestamp() {
        return this.lastReadTimestamp;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Participant other = (Participant) o;

        return Objects.equals(accountSid, other.accountSid) && Objects.equals(conversationSid, other.conversationSid)
                && Objects.equals(sid, other.sid) && Objects.equals(identity, other.identity)
                && Objects.equals(attributes, other.attributes)
                && Objects.equals(messagingBinding, other.messagingBinding) && Objects.equals(roleSid, other.roleSid)
                && Objects.equals(dateCreated, other.dateCreated) && Objects.equals(dateUpdated, other.dateUpdated)
                && Objects.equals(url, other.url) && Objects.equals(lastReadMessageIndex, other.lastReadMessageIndex)
                && Objects.equals(lastReadTimestamp, other.lastReadTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, conversationSid, sid, identity, attributes, messagingBinding, roleSid,
                dateCreated, dateUpdated, url, lastReadMessageIndex, lastReadTimestamp);
    }

}
