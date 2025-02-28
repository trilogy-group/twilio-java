/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Flex
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.flexapi.v1;

import com.kandy.base.Updater;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;

import java.net.URI;

public class FlexFlowUpdater extends Updater<FlexFlow> {
    private String pathSid;
    private String friendlyName;
    private String chatServiceSid;
    private FlexFlow.ChannelType channelType;
    private String contactIdentity;
    private Boolean enabled;
    private FlexFlow.IntegrationType integrationType;
    private String integrationFlowSid;
    private URI integrationUrl;
    private String integrationWorkspaceSid;
    private String integrationWorkflowSid;
    private String integrationChannel;
    private Integer integrationTimeout;
    private Integer integrationPriority;
    private Boolean integrationCreationOnMessage;
    private Boolean longLived;
    private Boolean janitorEnabled;
    private Integer integrationRetryCount;

    public FlexFlowUpdater(final String pathSid) {
        this.pathSid = pathSid;
    }

    public FlexFlowUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public FlexFlowUpdater setChatServiceSid(final String chatServiceSid) {
        this.chatServiceSid = chatServiceSid;
        return this;
    }

    public FlexFlowUpdater setChannelType(final FlexFlow.ChannelType channelType) {
        this.channelType = channelType;
        return this;
    }

    public FlexFlowUpdater setContactIdentity(final String contactIdentity) {
        this.contactIdentity = contactIdentity;
        return this;
    }

    public FlexFlowUpdater setEnabled(final Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public FlexFlowUpdater setIntegrationType(final FlexFlow.IntegrationType integrationType) {
        this.integrationType = integrationType;
        return this;
    }

    public FlexFlowUpdater setIntegrationFlowSid(final String integrationFlowSid) {
        this.integrationFlowSid = integrationFlowSid;
        return this;
    }

    public FlexFlowUpdater setIntegrationUrl(final URI integrationUrl) {
        this.integrationUrl = integrationUrl;
        return this;
    }

    public FlexFlowUpdater setIntegrationUrl(final String integrationUrl) {
        return setIntegrationUrl(Promoter.uriFromString(integrationUrl));
    }

    public FlexFlowUpdater setIntegrationWorkspaceSid(final String integrationWorkspaceSid) {
        this.integrationWorkspaceSid = integrationWorkspaceSid;
        return this;
    }

    public FlexFlowUpdater setIntegrationWorkflowSid(final String integrationWorkflowSid) {
        this.integrationWorkflowSid = integrationWorkflowSid;
        return this;
    }

    public FlexFlowUpdater setIntegrationChannel(final String integrationChannel) {
        this.integrationChannel = integrationChannel;
        return this;
    }

    public FlexFlowUpdater setIntegrationTimeout(final Integer integrationTimeout) {
        this.integrationTimeout = integrationTimeout;
        return this;
    }

    public FlexFlowUpdater setIntegrationPriority(final Integer integrationPriority) {
        this.integrationPriority = integrationPriority;
        return this;
    }

    public FlexFlowUpdater setIntegrationCreationOnMessage(final Boolean integrationCreationOnMessage) {
        this.integrationCreationOnMessage = integrationCreationOnMessage;
        return this;
    }

    public FlexFlowUpdater setLongLived(final Boolean longLived) {
        this.longLived = longLived;
        return this;
    }

    public FlexFlowUpdater setJanitorEnabled(final Boolean janitorEnabled) {
        this.janitorEnabled = janitorEnabled;
        return this;
    }

    public FlexFlowUpdater setIntegrationRetryCount(final Integer integrationRetryCount) {
        this.integrationRetryCount = integrationRetryCount;
        return this;
    }

    @Override
    public FlexFlow update(final KandyRestClient client) {
        String path = "/v1/FlexFlows/{Sid}";

        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.FLEXAPI.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("FlexFlow update failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return FlexFlow.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);

        }
        if (chatServiceSid != null) {
            request.addPostParam("ChatServiceSid", chatServiceSid);

        }
        if (channelType != null) {
            request.addPostParam("ChannelType", channelType.toString());

        }
        if (contactIdentity != null) {
            request.addPostParam("ContactIdentity", contactIdentity);

        }
        if (enabled != null) {
            request.addPostParam("Enabled", enabled.toString());

        }
        if (integrationType != null) {
            request.addPostParam("IntegrationType", integrationType.toString());

        }
        if (integrationFlowSid != null) {
            request.addPostParam("Integration.FlowSid", integrationFlowSid);

        }
        if (integrationUrl != null) {
            request.addPostParam("Integration.Url", integrationUrl.toString());

        }
        if (integrationWorkspaceSid != null) {
            request.addPostParam("Integration.WorkspaceSid", integrationWorkspaceSid);

        }
        if (integrationWorkflowSid != null) {
            request.addPostParam("Integration.WorkflowSid", integrationWorkflowSid);

        }
        if (integrationChannel != null) {
            request.addPostParam("Integration.Channel", integrationChannel);

        }
        if (integrationTimeout != null) {
            request.addPostParam("Integration.Timeout", integrationTimeout.toString());

        }
        if (integrationPriority != null) {
            request.addPostParam("Integration.Priority", integrationPriority.toString());

        }
        if (integrationCreationOnMessage != null) {
            request.addPostParam("Integration.CreationOnMessage", integrationCreationOnMessage.toString());

        }
        if (longLived != null) {
            request.addPostParam("LongLived", longLived.toString());

        }
        if (janitorEnabled != null) {
            request.addPostParam("JanitorEnabled", janitorEnabled.toString());

        }
        if (integrationRetryCount != null) {
            request.addPostParam("Integration.RetryCount", integrationRetryCount.toString());

        }
    }
}
