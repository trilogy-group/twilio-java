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

package com.kandy.rest.sync.v1.service.document;

import com.kandy.base.Deleter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;

public class DocumentPermissionDeleter extends Deleter<DocumentPermission> {
    private String pathServiceSid;
    private String pathDocumentSid;
    private String pathIdentity;

    public DocumentPermissionDeleter(final String pathServiceSid, final String pathDocumentSid,
            final String pathIdentity) {
        this.pathServiceSid = pathServiceSid;
        this.pathDocumentSid = pathDocumentSid;
        this.pathIdentity = pathIdentity;
    }

    @Override
    public boolean delete(final KandyRestClient client) {
        String path = "/v1/Services/{ServiceSid}/Documents/{DocumentSid}/Permissions/{Identity}";

        path = path.replace("{" + "ServiceSid" + "}", this.pathServiceSid.toString());
        path = path.replace("{" + "DocumentSid" + "}", this.pathDocumentSid.toString());
        path = path.replace("{" + "Identity" + "}", this.pathIdentity.toString());

        Request request = new Request(
                HttpMethod.DELETE,
                Domains.SYNC.toString(),
                path);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("DocumentPermission delete failed: Unable to connect to server");
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
