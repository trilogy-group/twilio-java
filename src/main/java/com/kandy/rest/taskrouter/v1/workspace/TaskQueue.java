/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Taskrouter
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.taskrouter.v1.workspace;

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
public class TaskQueue extends Resource {
    private static final long serialVersionUID = 234230912116687L;

    public static TaskQueueCreator creator(final String pathWorkspaceSid, final String friendlyName) {
        return new TaskQueueCreator(pathWorkspaceSid, friendlyName);
    }

    public static TaskQueueDeleter deleter(final String pathWorkspaceSid, final String pathSid) {
        return new TaskQueueDeleter(pathWorkspaceSid, pathSid);
    }

    public static TaskQueueFetcher fetcher(final String pathWorkspaceSid, final String pathSid) {
        return new TaskQueueFetcher(pathWorkspaceSid, pathSid);
    }

    public static TaskQueueReader reader(final String pathWorkspaceSid) {
        return new TaskQueueReader(pathWorkspaceSid);
    }

    public static TaskQueueUpdater updater(final String pathWorkspaceSid, final String pathSid) {
        return new TaskQueueUpdater(pathWorkspaceSid, pathSid);
    }

    /**
     * Converts a JSON String into a TaskQueue object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return TaskQueue object represented by the provided JSON
     */
    public static TaskQueue fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, TaskQueue.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a TaskQueue object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return TaskQueue object represented by the provided JSON
     */
    public static TaskQueue fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, TaskQueue.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    public enum TaskOrder {
        FIFO("FIFO"),
        LIFO("LIFO");

        private final String value;

        private TaskOrder(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static TaskOrder forValue(final String value) {
            return Promoter.enumFromString(value, TaskOrder.values());
        }
    }

    private final String accountSid;
    private final String assignmentActivitySid;
    private final String assignmentActivityName;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final String friendlyName;
    private final Integer maxReservedWorkers;
    private final String reservationActivitySid;
    private final String reservationActivityName;
    private final String sid;
    private final String targetWorkers;
    private final TaskQueue.TaskOrder taskOrder;
    private final URI url;
    private final String workspaceSid;
    private final Map<String, String> links;

    @JsonCreator
    private TaskQueue(
            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("assignment_activity_sid") final String assignmentActivitySid,

            @JsonProperty("assignment_activity_name") final String assignmentActivityName,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("date_updated") final String dateUpdated,

            @JsonProperty("friendly_name") final String friendlyName,

            @JsonProperty("max_reserved_workers") final Integer maxReservedWorkers,

            @JsonProperty("reservation_activity_sid") final String reservationActivitySid,

            @JsonProperty("reservation_activity_name") final String reservationActivityName,

            @JsonProperty("sid") final String sid,

            @JsonProperty("target_workers") final String targetWorkers,

            @JsonProperty("task_order") final TaskQueue.TaskOrder taskOrder,

            @JsonProperty("url") final URI url,

            @JsonProperty("workspace_sid") final String workspaceSid,

            @JsonProperty("links") final Map<String, String> links) {
        this.accountSid = accountSid;
        this.assignmentActivitySid = assignmentActivitySid;
        this.assignmentActivityName = assignmentActivityName;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.friendlyName = friendlyName;
        this.maxReservedWorkers = maxReservedWorkers;
        this.reservationActivitySid = reservationActivitySid;
        this.reservationActivityName = reservationActivityName;
        this.sid = sid;
        this.targetWorkers = targetWorkers;
        this.taskOrder = taskOrder;
        this.url = url;
        this.workspaceSid = workspaceSid;
        this.links = links;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getAssignmentActivitySid() {
        return this.assignmentActivitySid;
    }

    public final String getAssignmentActivityName() {
        return this.assignmentActivityName;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    public final String getFriendlyName() {
        return this.friendlyName;
    }

    public final Integer getMaxReservedWorkers() {
        return this.maxReservedWorkers;
    }

    public final String getReservationActivitySid() {
        return this.reservationActivitySid;
    }

    public final String getReservationActivityName() {
        return this.reservationActivityName;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getTargetWorkers() {
        return this.targetWorkers;
    }

    public final TaskQueue.TaskOrder getTaskOrder() {
        return this.taskOrder;
    }

    public final URI getUrl() {
        return this.url;
    }

    public final String getWorkspaceSid() {
        return this.workspaceSid;
    }

    public final Map<String, String> getLinks() {
        return this.links;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TaskQueue other = (TaskQueue) o;

        return Objects.equals(accountSid, other.accountSid)
                && Objects.equals(assignmentActivitySid, other.assignmentActivitySid)
                && Objects.equals(assignmentActivityName, other.assignmentActivityName)
                && Objects.equals(dateCreated, other.dateCreated) && Objects.equals(dateUpdated, other.dateUpdated)
                && Objects.equals(friendlyName, other.friendlyName)
                && Objects.equals(maxReservedWorkers, other.maxReservedWorkers)
                && Objects.equals(reservationActivitySid, other.reservationActivitySid)
                && Objects.equals(reservationActivityName, other.reservationActivityName)
                && Objects.equals(sid, other.sid) && Objects.equals(targetWorkers, other.targetWorkers)
                && Objects.equals(taskOrder, other.taskOrder) && Objects.equals(url, other.url)
                && Objects.equals(workspaceSid, other.workspaceSid) && Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, assignmentActivitySid, assignmentActivityName, dateCreated, dateUpdated,
                friendlyName, maxReservedWorkers, reservationActivitySid, reservationActivityName, sid, targetWorkers,
                taskOrder, url, workspaceSid, links);
    }

}
