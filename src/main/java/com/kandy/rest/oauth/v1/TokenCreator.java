/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Oauth
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.oauth.v1;

import com.kandy.base.Creator;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;

public class TokenCreator extends Creator<Token> {
    private String grantType;
    private String clientSid;
    private String clientSecret;
    private String code;
    private String codeVerifier;
    private String deviceCode;
    private String refreshToken;
    private String deviceId;

    public TokenCreator(final String grantType, final String clientSid) {
        this.grantType = grantType;
        this.clientSid = clientSid;
    }

    public TokenCreator setGrantType(final String grantType) {
        this.grantType = grantType;
        return this;
    }

    public TokenCreator setClientSid(final String clientSid) {
        this.clientSid = clientSid;
        return this;
    }

    public TokenCreator setClientSecret(final String clientSecret) {
        this.clientSecret = clientSecret;
        return this;
    }

    public TokenCreator setCode(final String code) {
        this.code = code;
        return this;
    }

    public TokenCreator setCodeVerifier(final String codeVerifier) {
        this.codeVerifier = codeVerifier;
        return this;
    }

    public TokenCreator setDeviceCode(final String deviceCode) {
        this.deviceCode = deviceCode;
        return this;
    }

    public TokenCreator setRefreshToken(final String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    public TokenCreator setDeviceId(final String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    @Override
    public Token create(final KandyRestClient client) {
        String path = "/v1/token";

        path = path.replace("{" + "GrantType" + "}", this.grantType.toString());
        path = path.replace("{" + "ClientSid" + "}", this.clientSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.OAUTH.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Token creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Token.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (grantType != null) {
            request.addPostParam("GrantType", grantType);

        }
        if (clientSid != null) {
            request.addPostParam("ClientSid", clientSid);

        }
        if (clientSecret != null) {
            request.addPostParam("ClientSecret", clientSecret);

        }
        if (code != null) {
            request.addPostParam("Code", code);

        }
        if (codeVerifier != null) {
            request.addPostParam("CodeVerifier", codeVerifier);

        }
        if (deviceCode != null) {
            request.addPostParam("DeviceCode", deviceCode);

        }
        if (refreshToken != null) {
            request.addPostParam("RefreshToken", refreshToken);

        }
        if (deviceId != null) {
            request.addPostParam("DeviceId", deviceId);

        }
    }
}
