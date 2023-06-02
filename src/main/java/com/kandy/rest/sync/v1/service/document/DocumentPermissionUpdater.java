/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Sync
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.sync.v1.service.document;

import com.kandy.base.Updater;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.TwilioRestClient;
import com.kandy.rest.Domains;

public class DocumentPermissionUpdater extends Updater<DocumentPermission> {
    private String pathServiceSid;
    private String pathDocumentSid;
    private String pathIdentity;
    private Boolean read;
    private Boolean write;
    private Boolean manage;

    public DocumentPermissionUpdater(final String pathServiceSid, final String pathDocumentSid,
            final String pathIdentity, final Boolean read, final Boolean write, final Boolean manage) {
        this.pathServiceSid = pathServiceSid;
        this.pathDocumentSid = pathDocumentSid;
        this.pathIdentity = pathIdentity;
        this.read = read;
        this.write = write;
        this.manage = manage;
    }

    public DocumentPermissionUpdater setRead(final Boolean read) {
        this.read = read;
        return this;
    }

    public DocumentPermissionUpdater setWrite(final Boolean write) {
        this.write = write;
        return this;
    }

    public DocumentPermissionUpdater setManage(final Boolean manage) {
        this.manage = manage;
        return this;
    }

    @Override
    public DocumentPermission update(final TwilioRestClient client) {
        String path = "/v1/Services/{ServiceSid}/Documents/{DocumentSid}/Permissions/{Identity}";

        path = path.replace("{" + "ServiceSid" + "}", this.pathServiceSid.toString());
        path = path.replace("{" + "DocumentSid" + "}", this.pathDocumentSid.toString());
        path = path.replace("{" + "Identity" + "}", this.pathIdentity.toString());
        path = path.replace("{" + "Read" + "}", this.read.toString());
        path = path.replace("{" + "Write" + "}", this.write.toString());
        path = path.replace("{" + "Manage" + "}", this.manage.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.SYNC.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("DocumentPermission update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return DocumentPermission.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (read != null) {
            request.addPostParam("Read", read.toString());

        }
        if (write != null) {
            request.addPostParam("Write", write.toString());

        }
        if (manage != null) {
            request.addPostParam("Manage", manage.toString());

        }
    }
}
