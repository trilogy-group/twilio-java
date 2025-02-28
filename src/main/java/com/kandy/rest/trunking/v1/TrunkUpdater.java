/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Trunking
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.trunking.v1;

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

public class TrunkUpdater extends Updater<Trunk> {
    private String pathSid;
    private String friendlyName;
    private String domainName;
    private URI disasterRecoveryUrl;
    private HttpMethod disasterRecoveryMethod;
    private Trunk.TransferSetting transferMode;
    private Boolean secure;
    private Boolean cnamLookupEnabled;
    private Trunk.TransferCallerId transferCallerId;

    public TrunkUpdater(final String pathSid) {
        this.pathSid = pathSid;
    }

    public TrunkUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public TrunkUpdater setDomainName(final String domainName) {
        this.domainName = domainName;
        return this;
    }

    public TrunkUpdater setDisasterRecoveryUrl(final URI disasterRecoveryUrl) {
        this.disasterRecoveryUrl = disasterRecoveryUrl;
        return this;
    }

    public TrunkUpdater setDisasterRecoveryUrl(final String disasterRecoveryUrl) {
        return setDisasterRecoveryUrl(Promoter.uriFromString(disasterRecoveryUrl));
    }

    public TrunkUpdater setDisasterRecoveryMethod(final HttpMethod disasterRecoveryMethod) {
        this.disasterRecoveryMethod = disasterRecoveryMethod;
        return this;
    }

    public TrunkUpdater setTransferMode(final Trunk.TransferSetting transferMode) {
        this.transferMode = transferMode;
        return this;
    }

    public TrunkUpdater setSecure(final Boolean secure) {
        this.secure = secure;
        return this;
    }

    public TrunkUpdater setCnamLookupEnabled(final Boolean cnamLookupEnabled) {
        this.cnamLookupEnabled = cnamLookupEnabled;
        return this;
    }

    public TrunkUpdater setTransferCallerId(final Trunk.TransferCallerId transferCallerId) {
        this.transferCallerId = transferCallerId;
        return this;
    }

    @Override
    public Trunk update(final KandyRestClient client) {
        String path = "/v1/Trunks/{Sid}";

        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.TRUNKING.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Trunk update failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Trunk.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);

        }
        if (domainName != null) {
            request.addPostParam("DomainName", domainName);

        }
        if (disasterRecoveryUrl != null) {
            request.addPostParam("DisasterRecoveryUrl", disasterRecoveryUrl.toString());

        }
        if (disasterRecoveryMethod != null) {
            request.addPostParam("DisasterRecoveryMethod", disasterRecoveryMethod.toString());

        }
        if (transferMode != null) {
            request.addPostParam("TransferMode", transferMode.toString());

        }
        if (secure != null) {
            request.addPostParam("Secure", secure.toString());

        }
        if (cnamLookupEnabled != null) {
            request.addPostParam("CnamLookupEnabled", cnamLookupEnabled.toString());

        }
        if (transferCallerId != null) {
            request.addPostParam("TransferCallerId", transferCallerId.toString());

        }
    }
}
