/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Api
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.api.v2010.account.availablephonenumbercountry;

import com.kandy.base.Reader;
import com.kandy.base.ResourceSet;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;
import com.kandy.base.Page;

public class TollFreeReader extends Reader<TollFree> {
    private String pathCountryCode;
    private String pathAccountSid;
    private Integer areaCode;
    private String contains;
    private Boolean smsEnabled;
    private Boolean mmsEnabled;
    private Boolean voiceEnabled;
    private Boolean excludeAllAddressRequired;
    private Boolean excludeLocalAddressRequired;
    private Boolean excludeForeignAddressRequired;
    private Boolean beta;
    private com.kandy.type.PhoneNumber nearNumber;
    private String nearLatLong;
    private Integer distance;
    private String inPostalCode;
    private String inRegion;
    private String inRateCenter;
    private String inLata;
    private String inLocality;
    private Boolean faxEnabled;
    private Integer pageSize;

    public TollFreeReader(final String pathCountryCode) {
        this.pathCountryCode = pathCountryCode;
    }

    public TollFreeReader(final String pathAccountSid, final String pathCountryCode) {
        this.pathAccountSid = pathAccountSid;
        this.pathCountryCode = pathCountryCode;
    }

    public TollFreeReader setAreaCode(final Integer areaCode) {
        this.areaCode = areaCode;
        return this;
    }

    public TollFreeReader setContains(final String contains) {
        this.contains = contains;
        return this;
    }

    public TollFreeReader setSmsEnabled(final Boolean smsEnabled) {
        this.smsEnabled = smsEnabled;
        return this;
    }

    public TollFreeReader setMmsEnabled(final Boolean mmsEnabled) {
        this.mmsEnabled = mmsEnabled;
        return this;
    }

    public TollFreeReader setVoiceEnabled(final Boolean voiceEnabled) {
        this.voiceEnabled = voiceEnabled;
        return this;
    }

    public TollFreeReader setExcludeAllAddressRequired(final Boolean excludeAllAddressRequired) {
        this.excludeAllAddressRequired = excludeAllAddressRequired;
        return this;
    }

    public TollFreeReader setExcludeLocalAddressRequired(final Boolean excludeLocalAddressRequired) {
        this.excludeLocalAddressRequired = excludeLocalAddressRequired;
        return this;
    }

    public TollFreeReader setExcludeForeignAddressRequired(final Boolean excludeForeignAddressRequired) {
        this.excludeForeignAddressRequired = excludeForeignAddressRequired;
        return this;
    }

    public TollFreeReader setBeta(final Boolean beta) {
        this.beta = beta;
        return this;
    }

    public TollFreeReader setNearNumber(final com.kandy.type.PhoneNumber nearNumber) {
        this.nearNumber = nearNumber;
        return this;
    }

    public TollFreeReader setNearNumber(final String nearNumber) {
        return setNearNumber(Promoter.phoneNumberFromString(nearNumber));
    }

    public TollFreeReader setNearLatLong(final String nearLatLong) {
        this.nearLatLong = nearLatLong;
        return this;
    }

    public TollFreeReader setDistance(final Integer distance) {
        this.distance = distance;
        return this;
    }

    public TollFreeReader setInPostalCode(final String inPostalCode) {
        this.inPostalCode = inPostalCode;
        return this;
    }

    public TollFreeReader setInRegion(final String inRegion) {
        this.inRegion = inRegion;
        return this;
    }

    public TollFreeReader setInRateCenter(final String inRateCenter) {
        this.inRateCenter = inRateCenter;
        return this;
    }

    public TollFreeReader setInLata(final String inLata) {
        this.inLata = inLata;
        return this;
    }

    public TollFreeReader setInLocality(final String inLocality) {
        this.inLocality = inLocality;
        return this;
    }

    public TollFreeReader setFaxEnabled(final Boolean faxEnabled) {
        this.faxEnabled = faxEnabled;
        return this;
    }

    public TollFreeReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<TollFree> read(final KandyRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<TollFree> firstPage(final KandyRestClient client) {
        String path = "/2010-04-01/Accounts/{AccountSid}/AvailablePhoneNumbers/{CountryCode}/TollFree.json";
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        path = path.replace("{" + "AccountSid" + "}", this.pathAccountSid.toString());
        path = path.replace("{" + "CountryCode" + "}", this.pathCountryCode.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.API.toString(),
                path);

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<TollFree> pageForRequest(final KandyRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("TollFree read failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "available_phone_numbers",
                response.getContent(),
                TollFree.class,
                client.getObjectMapper());
    }

    @Override
    public Page<TollFree> previousPage(final Page<TollFree> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.API.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<TollFree> nextPage(final Page<TollFree> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.API.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<TollFree> getPage(final String targetUrl, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (areaCode != null) {

            request.addQueryParam("AreaCode", areaCode.toString());
        }
        if (contains != null) {

            request.addQueryParam("Contains", contains);
        }
        if (smsEnabled != null) {

            request.addQueryParam("SmsEnabled", smsEnabled.toString());
        }
        if (mmsEnabled != null) {

            request.addQueryParam("MmsEnabled", mmsEnabled.toString());
        }
        if (voiceEnabled != null) {

            request.addQueryParam("VoiceEnabled", voiceEnabled.toString());
        }
        if (excludeAllAddressRequired != null) {

            request.addQueryParam("ExcludeAllAddressRequired", excludeAllAddressRequired.toString());
        }
        if (excludeLocalAddressRequired != null) {

            request.addQueryParam("ExcludeLocalAddressRequired", excludeLocalAddressRequired.toString());
        }
        if (excludeForeignAddressRequired != null) {

            request.addQueryParam("ExcludeForeignAddressRequired", excludeForeignAddressRequired.toString());
        }
        if (beta != null) {

            request.addQueryParam("Beta", beta.toString());
        }
        if (nearNumber != null) {

            request.addQueryParam("NearNumber", nearNumber.toString());
        }
        if (nearLatLong != null) {

            request.addQueryParam("NearLatLong", nearLatLong);
        }
        if (distance != null) {

            request.addQueryParam("Distance", distance.toString());
        }
        if (inPostalCode != null) {

            request.addQueryParam("InPostalCode", inPostalCode);
        }
        if (inRegion != null) {

            request.addQueryParam("InRegion", inRegion);
        }
        if (inRateCenter != null) {

            request.addQueryParam("InRateCenter", inRateCenter);
        }
        if (inLata != null) {

            request.addQueryParam("InLata", inLata);
        }
        if (inLocality != null) {

            request.addQueryParam("InLocality", inLocality);
        }
        if (faxEnabled != null) {

            request.addQueryParam("FaxEnabled", faxEnabled.toString());
        }
        if (pageSize != null) {

            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
