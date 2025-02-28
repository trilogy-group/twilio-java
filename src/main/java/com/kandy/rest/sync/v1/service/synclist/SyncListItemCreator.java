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

package com.kandy.rest.sync.v1.service.synclist;

import com.kandy.base.Creator;
import com.kandy.exception.ApiConnectionException;
import com.kandy.converter.Converter;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;
import java.util.Map;
import com.kandy.converter.Converter;

import java.util.Map;

public class SyncListItemCreator extends Creator<SyncListItem> {
    private String pathServiceSid;
    private String pathListSid;
    private Map<String, Object> data;
    private Integer ttl;
    private Integer itemTtl;
    private Integer collectionTtl;

    public SyncListItemCreator(final String pathServiceSid, final String pathListSid, final Map<String, Object> data) {
        this.pathServiceSid = pathServiceSid;
        this.pathListSid = pathListSid;
        this.data = data;
    }

    public SyncListItemCreator setData(final Map<String, Object> data) {
        this.data = data;
        return this;
    }

    public SyncListItemCreator setTtl(final Integer ttl) {
        this.ttl = ttl;
        return this;
    }

    public SyncListItemCreator setItemTtl(final Integer itemTtl) {
        this.itemTtl = itemTtl;
        return this;
    }

    public SyncListItemCreator setCollectionTtl(final Integer collectionTtl) {
        this.collectionTtl = collectionTtl;
        return this;
    }

    @Override
    public SyncListItem create(final KandyRestClient client) {
        String path = "/v1/Services/{ServiceSid}/Lists/{ListSid}/Items";

        path = path.replace("{" + "ServiceSid" + "}", this.pathServiceSid.toString());
        path = path.replace("{" + "ListSid" + "}", this.pathListSid.toString());
        path = path.replace("{" + "Data" + "}", this.data.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.SYNC.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("SyncListItem creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return SyncListItem.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (data != null) {
            request.addPostParam("Data", Converter.mapToJson(data));

        }
        if (ttl != null) {
            request.addPostParam("Ttl", ttl.toString());

        }
        if (itemTtl != null) {
            request.addPostParam("ItemTtl", itemTtl.toString());

        }
        if (collectionTtl != null) {
            request.addPostParam("CollectionTtl", collectionTtl.toString());

        }
    }
}
