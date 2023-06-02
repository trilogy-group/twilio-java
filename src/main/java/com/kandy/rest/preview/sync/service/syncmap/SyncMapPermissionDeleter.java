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

package com.kandy.rest.preview.sync.service.syncmap;

import com.kandy.base.Deleter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;

public class SyncMapPermissionDeleter extends Deleter<SyncMapPermission> {
    private String pathServiceSid;
    private String pathMapSid;
    private String pathIdentity;

    public SyncMapPermissionDeleter(final String pathServiceSid, final String pathMapSid, final String pathIdentity) {
        this.pathServiceSid = pathServiceSid;
        this.pathMapSid = pathMapSid;
        this.pathIdentity = pathIdentity;
    }

    @Override
    public boolean delete(final KandyRestClient client) {
        String path = "/Sync/Services/{ServiceSid}/Maps/{MapSid}/Permissions/{Identity}";

        path = path.replace("{" + "ServiceSid" + "}", this.pathServiceSid.toString());
        path = path.replace("{" + "MapSid" + "}", this.pathMapSid.toString());
        path = path.replace("{" + "Identity" + "}", this.pathIdentity.toString());

        Request request = new Request(
                HttpMethod.DELETE,
                Domains.PREVIEW.toString(),
                path);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("SyncMapPermission delete failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }
        return response.getStatusCode() == 204;
    }
}
