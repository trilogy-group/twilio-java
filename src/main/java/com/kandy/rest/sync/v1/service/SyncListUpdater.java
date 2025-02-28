/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Sync
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.sync.v1.service;

import com.kandy.base.Updater;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;

public class SyncListUpdater extends Updater<SyncList> {
    private String pathServiceSid;
    private String pathSid;
    private Integer ttl;
    private Integer collectionTtl;

    public SyncListUpdater(final String pathServiceSid, final String pathSid) {
        this.pathServiceSid = pathServiceSid;
        this.pathSid = pathSid;
    }

    public SyncListUpdater setTtl(final Integer ttl) {
        this.ttl = ttl;
        return this;
    }

    public SyncListUpdater setCollectionTtl(final Integer collectionTtl) {
        this.collectionTtl = collectionTtl;
        return this;
    }

    @Override
    public SyncList update(final KandyRestClient client) {
        String path = "/v1/Services/{ServiceSid}/Lists/{Sid}";

        path = path.replace("{" + "ServiceSid" + "}", this.pathServiceSid.toString());
        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.SYNC.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("SyncList update failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return SyncList.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (ttl != null) {
            request.addPostParam("Ttl", ttl.toString());

        }
        if (collectionTtl != null) {
            request.addPostParam("CollectionTtl", collectionTtl.toString());

        }
    }
}
