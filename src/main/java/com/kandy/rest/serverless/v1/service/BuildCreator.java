/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Serverless
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.serverless.v1.service;

import com.kandy.base.Creator;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;
import java.util.List;

import java.util.List;

public class BuildCreator extends Creator<Build> {
    private String pathServiceSid;
    private List<String> assetVersions;
    private List<String> functionVersions;
    private String dependencies;
    private String runtime;

    public BuildCreator(final String pathServiceSid) {
        this.pathServiceSid = pathServiceSid;
    }

    public BuildCreator setAssetVersions(final List<String> assetVersions) {
        this.assetVersions = assetVersions;
        return this;
    }

    public BuildCreator setAssetVersions(final String assetVersions) {
        return setAssetVersions(Promoter.listOfOne(assetVersions));
    }

    public BuildCreator setFunctionVersions(final List<String> functionVersions) {
        this.functionVersions = functionVersions;
        return this;
    }

    public BuildCreator setFunctionVersions(final String functionVersions) {
        return setFunctionVersions(Promoter.listOfOne(functionVersions));
    }

    public BuildCreator setDependencies(final String dependencies) {
        this.dependencies = dependencies;
        return this;
    }

    public BuildCreator setRuntime(final String runtime) {
        this.runtime = runtime;
        return this;
    }

    @Override
    public Build create(final KandyRestClient client) {
        String path = "/v1/Services/{ServiceSid}/Builds";

        path = path.replace("{" + "ServiceSid" + "}", this.pathServiceSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.SERVERLESS.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Build creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Build.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (assetVersions != null) {
            for (String prop : assetVersions) {
                request.addPostParam("AssetVersions", prop);
            }

        }
        if (functionVersions != null) {
            for (String prop : functionVersions) {
                request.addPostParam("FunctionVersions", prop);
            }

        }
        if (dependencies != null) {
            request.addPostParam("Dependencies", dependencies);

        }
        if (runtime != null) {
            request.addPostParam("Runtime", runtime);

        }
    }
}
